package com.ironhack.final_project.repository;

import com.ironhack.final_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // todo change to optional
    User findByUsername(String username);
}