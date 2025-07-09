package com.matrimony.Service;

import com.matrimony.Entities.User;
import com.matrimony.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService
{
    @Autowired
    private UserRepository userRepository;

    //  Get all users
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    //  Get user by ID
    public User getUserById(Long id)
    {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public String deleteUser(Long id)
    {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}
