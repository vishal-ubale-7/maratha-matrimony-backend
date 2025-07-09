package com.matrimony.Service;

import com.matrimony.DTO.UserDTO;
import com.matrimony.Entities.*;
import com.matrimony.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder; // ✅ CORRECT

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PreferencesRepository preferencesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // create users
    public List<User> saveAll(List< User> users)
    {
       return userRepository.saveAll(users);
    }


     // getAllUsers
    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    // getUserById
    public Optional<User>getUserById(Long id)
    {
        return userRepository.findById(id);
    }

    // update user

    public User updateUser( Long id , User updatedUser)
    {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent())
        {
            User existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setAge(updatedUser.getAge());
            existingUser.setGender(updatedUser.getGender());
            existingUser.setCaste(updatedUser.getCaste());
            existingUser.setJob(updatedUser.getJob());
            existingUser.setEducation(updatedUser.getEducation());
            return  userRepository.save(existingUser);
        }
        else
        {
            return null; // handel error properly
        }
    }

    // delete user

    public String deleteUser(Long id )
    {
           if (userRepository.existsById(id))
           {
               userRepository.deleteById(id);
               return "User Deleted Successfully";
           }
           else
           {
               return "User Not Found";
           }

    }

    public List<User> getMatchSuggestions(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            return Collections.emptyList();
        }

        User user = optionalUser.get();

        String targetGender = user.getGender().equalsIgnoreCase("Male") ? "Female" : "Male";
        String caste = user.getCaste();
        int age = user.getAge();

        // Get users of opposite gender and similar caste
        return userRepository.findByGenderAndCasteAndAgeBetween(
                targetGender,
                caste,
                age - 5,
                age + 5
        );
    }


    public List<User> searchUsers(String gender, String caste, Integer minAge, Integer maxAge)
    {
        return userRepository.searchUsers(gender, caste, minAge, maxAge);
    }

    public User registerFullUser(UserDTO dto) {

        // Check if email already exists
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists: " + dto.getEmail());
        }

        // Save sub-entities first
        Address savedAddress = addressRepository.save(dto.getAddress());
        Education savedEducation = educationRepository.save(dto.getEducation());
        Job savedJob = jobRepository.save(dto.getJob());
        Preferences savedPreferences = preferencesRepository.save(dto.getPreferences());

        // Create and save user
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());
        user.setAge(dto.getAge());
        user.setGender(dto.getGender());
        user.setCaste(dto.getCaste());
        user.setAddress(savedAddress);
        user.setEducation(savedEducation);
        user.setJob(savedJob);
        user.setPreferences(savedPreferences);

        return userRepository.save(user);
    }


}



