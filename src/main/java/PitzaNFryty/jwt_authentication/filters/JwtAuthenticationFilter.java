package PitzaNFryty.jwt_authentication.filters;

import PitzaNFryty.jwt_authentication.LoginRequest;
import PitzaNFryty.jwt_authentication.UserDetailsImpl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SECRET = "PulsonProductions";
    public static final int EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String RESPONSE_HEADER_STRING = "Authorization";

    private final AuthenticationManager authenticationManager;


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, String authenticationURL) {
        super.setAuthenticationManager(authenticationManager);
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(authenticationURL);
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        LoginRequest loginRequest = new LoginRequest();
        try {
            loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword(),
                new ArrayList<>()
        );

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();

        String jwtToken = JWT.create()
                .withSubject(userDetails.getUsername())
                .withClaim("user_id", userDetails.getId())
                .withClaim("role", userDetails.getAuthorities().get(0).getAuthority())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET));

        response.addHeader(RESPONSE_HEADER_STRING, TOKEN_PREFIX + jwtToken);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.sendError(401);
    }

    @Override
    public void setFilterProcessesUrl(String authenticationURL) {
        super.setFilterProcessesUrl(authenticationURL);
    }
}
