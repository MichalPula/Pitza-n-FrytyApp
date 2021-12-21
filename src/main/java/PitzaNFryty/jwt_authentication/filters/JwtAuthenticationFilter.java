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

    private final AuthenticationManager authenticationManager;
    private  final JwtConstants jwtConstants;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, String authenticationURL, JwtConstants jwtConstants) {
        super.setAuthenticationManager(authenticationManager);
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(authenticationURL);
        this.jwtConstants = jwtConstants;
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
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtConstants.getExpiration_time()))
                .sign(Algorithm.HMAC512(jwtConstants.getSecret()));

        response.addHeader(jwtConstants.getHttp_header_string(), jwtConstants.getToken_prefix() + jwtToken);
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
