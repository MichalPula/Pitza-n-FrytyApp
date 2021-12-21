package PitzaNFryty.jwt_authentication;

import PitzaNFryty.customer.RegisteredUser.RegisteredUser;
import PitzaNFryty.customer.RegisteredUser.RegisteredUserRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RegisteredUserRepository registeredUserRepository;

    @Autowired
    public UserDetailsServiceImpl(RegisteredUserRepository registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        RegisteredUser userWhichIsTryingToLogIn = registeredUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return new UserDetailsImpl(userWhichIsTryingToLogIn);
    }
}
