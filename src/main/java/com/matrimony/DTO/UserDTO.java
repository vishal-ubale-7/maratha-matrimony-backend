package com.matrimony.DTO;

import com.matrimony.Entities.*;

public class UserDTO
{
    private String name;
    private String email;
    private String password;
    private String role;
    private int age;
    private String gender;
    private String caste;
    private Address address;
    private Education education;
    private Job job;
    private Preferences preferences;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public String  Role; Object getRoleS() {
        return  role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public com.matrimony.Entities.Role getRole()
    {
        return null;
    }
}
