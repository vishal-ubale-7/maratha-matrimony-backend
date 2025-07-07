package com.matrimony.Service;


import com.matrimony.DTO.AuthResponse;
import com.matrimony.DTO.LoginRequest;
import com.matrimony.DTO.RegisterRequest;
import com.matrimony.Entities.User;
import com.matrimony.Repositories.UserRepository;
import com.matrimony.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Optional;

@Service
public class AuthService
{
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EmailService emailService;

    public String register(RegisterRequest req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));

        user.setAge(req.getAge());
        user.setCaste(req.getCaste());
        user.setGender(req.getGender());
        userRepo.save(user);

        emailService.sendWelcomeEmail(user.getEmail(), user.getName());

        return "User Registered Successfully";



    }

    public AuthResponse login(LoginRequest req) {
        Optional<User> userOpt = userRepo.findByEmail(req.getEmail());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(req.getPassword(), user.getPassword())) {
                String token = jwtUtil.generateToken(user.getEmail());
                return new AuthResponse(token, "Login Successful");
            }
        }
        return new AuthResponse(null, "Invalid email or password");
    }


}
