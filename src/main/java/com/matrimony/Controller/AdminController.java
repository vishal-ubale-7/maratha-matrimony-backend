package com.matrimony.Controller;


import com.matrimony.Entities.User;
import com.matrimony.Service.AdminService;
import com.matrimony.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController
{

    @Autowired
    private AdminService adminService;

    //  Get all users
    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return adminService.getAllUsers();
    }

    //  Get user by ID
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id)
    {
        return Optional.ofNullable(adminService.getUserById(id));
    }

    //  Delete a user by ID
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        return adminService.deleteUser(id);
    }

}
