package com.matrimony.Entities;

import com.matrimony.Entities.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String caste;
    private int age;
    private String gender;
    private String profileImagePath;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private Job job;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private Education education;


    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;


    public User()
    {}


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public User(String caste, int age, Education education, String gender, Long id, Job job, String name)
    {
        this.caste = caste;
        this.age = age;
        this.education = education;
        this.gender = gender;
        this.id = id;
        this.job = job;
        this.name = name;
    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public User(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public void setRole(Role role)
    {
    }

    public void setPreferences(Preferences savedPreferences)
    {
    }

    public void setAddress(Address savedAddress)
    {
    }
}
