package PitzaNFryty.jwt_authentication.filters;

import PitzaNFryty.customer.RegisteredUser.RegisteredUserRepository;
import PitzaNFryty.jwt_authentication.UserDetailsImpl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final RegisteredUserRepository registeredUserRepository;

    public static final String SECRET = "PulsonProductions";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String REQUEST_HEADER_STRING = "Authorization";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager,
                                  RegisteredUserRepository registeredUserRepository) {
        super(authenticationManager);
        this.registeredUserRepository = registeredUserRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String token = request.getHeader(REQUEST_HEADER_STRING);

        if (token != null && token.startsWith(TOKEN_PREFIX)) {
            try {
                String username = JWT.require(Algorithm.HMAC512(SECRET))
                        .build()
                        .verify(token.replace(TOKEN_PREFIX, ""))
                        .getSubject();

                UserDetailsImpl userDetails = new UserDetailsImpl(registeredUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found!")));
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authToken);
            } catch (JWTVerificationException ex) {
                response.setStatus(401);
            }
        }
        chain.doFilter(request, response);
    }
}
