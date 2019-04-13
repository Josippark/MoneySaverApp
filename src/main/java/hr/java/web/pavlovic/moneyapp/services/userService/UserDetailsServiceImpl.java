package hr.java.web.pavlovic.moneyapp.services.userService;

import hr.java.web.pavlovic.moneyapp.model.User;
import hr.java.web.pavlovic.moneyapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class UserDetailsServiceImpl implements UserDetailsService {


    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        if(user == null){
            log.info("User not found..");
            throw new UsernameNotFoundException("User not found!");

        }

        log.info("User: {}", username);

        return new UserDetailsImpl(user);

    }
}
