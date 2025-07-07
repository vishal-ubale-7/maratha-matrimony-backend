package com.matrimony.Repositories;


import com.matrimony.Entities.UserGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserGalleryRepository extends  JpaRepository<UserGallery,Long>
{
    List<UserGallery> findByUserId(Long userId);

}
