package com.matrimony.Controller;


import com.matrimony.DTO.AuthResponse;
import com.matrimony.DTO.LoginRequest;
import com.matrimony.DTO.RegisterRequest;
import com.matrimony.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request)
    {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request)
    {
        return authService.login(request);
    }


}
