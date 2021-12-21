package PitzaNFryty;

import PitzaNFryty.customer.RegisteredUser.RegisteredUserRepository;
import PitzaNFryty.jwt_authentication.UserDetailsServiceImpl;
import PitzaNFryty.jwt_authentication.filters.JwtAuthenticationFilter;
import PitzaNFryty.jwt_authentication.filters.JwtAuthorizationFilter;
import PitzaNFryty.jwt_authentication.filters.JwtConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableConfigurationProperties(JwtConstants.class)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailServiceImpl;
    private final RegisteredUserRepository registeredUserRepository;
    private final JwtConstants jwtConstants;


    @Autowired
    public SpringSecurityConfig(UserDetailsServiceImpl userDetailServiceImpl, RegisteredUserRepository registeredUserRepository,
                                JwtConstants jwtConstants) {
        this.userDetailServiceImpl = userDetailServiceImpl;
        this.registeredUserRepository = registeredUserRepository;
        this.jwtConstants = jwtConstants;
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        authenticationProvider.setUserDetailsService(this.userDetailServiceImpl);
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), "/login", jwtConstants))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), this.registeredUserRepository, jwtConstants))
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/everyone").permitAll()
                .antMatchers("/authenticated").authenticated()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/manager").hasAnyRole("MANAGER", "ADMIN");
    }
}
