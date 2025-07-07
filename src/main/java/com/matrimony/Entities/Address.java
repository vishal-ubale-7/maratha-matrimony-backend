package com.matrimony.Entities;

import jakarta.persistence.*;

@Entity
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String village;
   private String city;
   private String district;
   private String state;
   private String country;
   private String pinCode;

   @OneToOne
   private User user;

public Address()
{

}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Address(String city, String country, String district, Long id, String pinCode, String state, User user, String village) {
        this.city = city;
        this.country = country;
        this.district = district;
        this.id = id;
        this.pinCode = pinCode;
        this.state = state;
        this.user = user;
        this.village = village;
    }
}
