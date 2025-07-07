package com.matrimony.Entities;

import jakarta.persistence.*;

@Entity
public class UserGallery
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public UserGallery() {}

    public UserGallery(String imagePath, User user) {
        this.imagePath = imagePath;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // toString
    @Override
    public String toString()
    {
        return "UserGallery{" + "id=" + id + ", imagePath='" + imagePath + '\'' + ", userId=" + (user != null ? user.getId() : null) + '}';
    }
}
