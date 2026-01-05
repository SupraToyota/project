package com.official_dealer.auto.bootstrap;

import com.official_dealer.auto.entity.Role;
import com.official_dealer.auto.entity.User;
import com.official_dealer.auto.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminBootstrap {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminBootstrap(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner initAdmin() {
        return args -> {
            if (userRepository.existsByRole(Role.ADMIN)) {
                return;
            }

            User admin = new User(
                "admin@dealer.system",
                passwordEncoder.encode("admin123"),
                Role.ADMIN,
                null
            );
            admin.setActive(true);

            userRepository.save(admin);
        };
    }
}