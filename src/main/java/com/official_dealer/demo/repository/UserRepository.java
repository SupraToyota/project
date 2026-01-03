package com.official_dealer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.official_dealer.demo.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
