package com.ironhack.final_project.demo;

import com.ironhack.final_project.model.Role;
import com.ironhack.final_project.model.User;
import com.ironhack.final_project.service.RoleService;
import com.ironhack.final_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));

        userService.saveUser(new User("Kevin", "kevin", "1234"));
        userService.saveUser(new User("James", "james", "1234"));

        roleService.addRoleToUser("kevin", "ROLE_USER");
        roleService.addRoleToUser("james", "ROLE_ADMIN");
    }
}