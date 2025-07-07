package com.matrimony.Controller;


import com.matrimony.Entities.User;
import com.matrimony.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.List;
import java.util.Optional;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.core.io.Resource;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    UserService userService;

    @PostMapping("/bulk")
    public ResponseEntity<List<User>> saveAll (@RequestBody List <User> users)
    {
        return new ResponseEntity<>(userService.saveAll(users), HttpStatus.CREATED);
    }

    // getAll User
    @GetMapping
    public List<User> getAll()
    {
        System.out.println("Fetching all users...");
        return userService.getAllUser();
   }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id , @RequestBody User updatedUser)
    {
       User user = userService.updateUser(id,updatedUser);
       if(user != null)
       {
          return ResponseEntity.ok(user);
       }
       else
       {
           return ResponseEntity.notFound().build();// if user not found
       }
    }

    @DeleteMapping("/{id}")
      public ResponseEntity<String> deleteUser(@PathVariable Long id)
      {
          String message = userService.deleteUser(id);
          if (message.equals("User Deleted Successfully"));
          {
              return ResponseEntity.ok(message);
          }
      }

    @PostMapping("/users/{id}/upload-image")
    public ResponseEntity<String> uploadProfileImage(@PathVariable Long id, @RequestParam("image") MultipartFile file)
    {
        try
        {
            Optional<User> optionalUser = userService.getUserById(id);
            if (optionalUser.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }

            User user = optionalUser.get();

            // Create uploads directory if it doesn't exist
            String uploadDir = "uploads/";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdir();
            }

            // Define image path
            String filename = "user_" + id + "_" + file.getOriginalFilename();
            String filePath = uploadDir + filename;

            // Save image to folder
            file.transferTo(new File(filePath));

            // Update User entity with image path
            user.setProfileImagePath(filePath);
            userService.updateUser(id, user);

            return ResponseEntity.ok("Image uploaded successfully");
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }

    @GetMapping("/{id}/photo")
    public ResponseEntity<Resource> getUserPhoto(@PathVariable Long id)
    {
        Optional<User> optionalUser = userService.getUserById(id);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = optionalUser.get();
        String imagePath = user.getProfileImagePath(); // "uploads/user_1_photo.jpg"

        try {
            Path path = Paths.get(imagePath);
            Resource resource = new UrlResource(path.toUri());

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // You can enhance this to detect MIME type
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (Exception e)
        {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/match/suggestions/{userId}")
    public ResponseEntity<List<User>> getMatchSuggestions(@PathVariable Long userId)
    {
        List<User> suggestions = userService.getMatchSuggestions(userId);
        return ResponseEntity.ok(suggestions);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers
            (
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String caste,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge
    )
    {
        List<User> users = userService.searchUsers(gender, caste, minAge, maxAge);
        return ResponseEntity.ok(users);
    }


} 