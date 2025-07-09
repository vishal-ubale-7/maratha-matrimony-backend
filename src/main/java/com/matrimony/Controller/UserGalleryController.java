package com.matrimony.Controller;

import com.matrimony.Entities.UserGallery;
import com.matrimony.Service.UserGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.matrimony.DTO.UserDTO;
import com.matrimony.Entities.User;
import com.matrimony.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
public class UserGalleryController
{
    @Autowired
    private UserGalleryService galleryService;

    @Autowired
    private  UserService userService;

    // Upload multiple images
    @PostMapping("/upload/{userId}")
    public ResponseEntity<String> uploadGalleryImages(
            @PathVariable Long userId,
            @RequestParam("images") List<MultipartFile> files
    )
    {
        String response = galleryService.uploadImages(userId, files);
        if (response.startsWith("Images uploaded")) {
            return ResponseEntity.ok(response);
        } else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    //  Get all gallery images by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserGallery>> getGalleryByUser(@PathVariable Long userId)
    {
        List<UserGallery> galleryList = galleryService.getImagesByUser(userId);
        return ResponseEntity.ok(galleryList);
    }


    // 🔽 API to create 1 full user with all details
    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {
        return userService.registerFullUser(userDTO);
    }

}
