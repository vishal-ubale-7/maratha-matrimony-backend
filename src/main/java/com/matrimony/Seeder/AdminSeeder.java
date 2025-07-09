package com.matrimony.Seeder;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.matrimony.Entities.Role;
import com.matrimony.Entities.User;
import com.matrimony.Repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminSeeder
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initAdminUser()
    {
        if (!userRepository.existsByEmail("ubalevishal2019@gmail.com"))
        {
            User admin = new User();
            admin.setName("Vishal");

            admin.setEmail("ubalevishal2019@gmail.com");

            // Set password and role BEFORE saving
            admin.setPassword(passwordEncoder.encode("vishal@1010"));
            admin.setRole(Role.ADMIN);

            userRepository.save(admin);
            System.out.println("Admin user created");
        } else {
            System.out.println("Admin user already exists");
        }
    }

}
