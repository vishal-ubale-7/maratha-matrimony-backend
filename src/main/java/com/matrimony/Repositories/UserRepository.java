package com.matrimony.Repositories;

import com.matrimony.Entities.Job;
import com.matrimony.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User , Long>
{
    // Add this method to find users by email (for login/auth)
    Optional<User> findByEmail(String email);

    List<User> findByGenderAndCasteAndAgeBetween(String gender, String caste, int minAge, int maxAge);

    // search and filter
    @Query("SELECT u FROM User u WHERE "
            + "(:gender IS NULL OR u.gender = :gender) AND "
            + "(:caste IS NULL OR u.caste = :caste) AND "
            + "(:minAge IS NULL OR u.age >= :minAge) AND "
            + "(:maxAge IS NULL OR u.age <= :maxAge)")
    List<User> searchUsers(
            @Param("gender") String gender,
            @Param("caste") String caste,
            @Param("minAge") Integer minAge,
            @Param("maxAge") Integer maxAge
    );
;
    boolean existsByEmail(String email);


}

