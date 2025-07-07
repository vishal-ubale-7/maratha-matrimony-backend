package com.matrimony.Service;

import com.matrimony.Entities.User;
import com.matrimony.Entities.UserGallery;
import com.matrimony.Repositories.UserGalleryRepository;
import com.matrimony.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserGalleryService
{
    @Autowired
    private UserGalleryRepository galleryRepo;

    @Autowired
    private UserRepository userRepo;

    public String uploadImages(Long userId, List<MultipartFile> files) {
        Optional<User> userOpt = userRepo.findById(userId);
        if (userOpt.isEmpty()) {
            return "User not found";
        }

        User user = userOpt.get();
        List<UserGallery> uploadedImages = new ArrayList<>();

        String uploadDir = "uploads/gallery/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            for (MultipartFile file : files) {
                String filename = "user_" + userId + "_" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
                String filePath = uploadDir + filename;

                file.transferTo(new File(filePath));

                UserGallery gallery = new UserGallery(filePath, user);
                uploadedImages.add(gallery);
            }

            galleryRepo.saveAll(uploadedImages);
            return "Images uploaded successfully";

        } catch (Exception e) {
            return "Failed to upload images: " + e.getMessage();
        }
    }

    public List<UserGallery> getImagesByUser(Long userId) {
        return galleryRepo.findByUserId(userId);
    }
}
