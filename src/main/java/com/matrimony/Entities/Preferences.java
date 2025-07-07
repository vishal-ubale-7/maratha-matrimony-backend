package com.matrimony.Entities;

import jakarta.persistence.*;

@Entity
public class Preferences
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ;

   private String  preferredCaste;
   private String  preferredEducation;
   private String preferredJob;
   private int minAge;
   private int maxAge;
   private String preferredLocation;


   @OneToOne
  private  User user;

   public Preferences()
   {

   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public String getPreferredCaste() {
        return preferredCaste;
    }

    public void setPreferredCaste(String preferredCaste) {
        this.preferredCaste = preferredCaste;
    }

    public String getPreferredEducation() {
        return preferredEducation;
    }

    public void setPreferredEducation(String preferredEducation) {
        this.preferredEducation = preferredEducation;
    }

    public String getPreferredJob() {
        return preferredJob;
    }

    public void setPreferredJob(String preferredJob) {
        this.preferredJob = preferredJob;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Preferences(Long id, int maxAge, int minAge, String preferredCaste, String preferredEducation, String preferredJob, String preferredLocation, User user) {
        this.id = id;
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.preferredCaste = preferredCaste;
        this.preferredEducation = preferredEducation;
        this.preferredJob = preferredJob;
        this.preferredLocation = preferredLocation;
        this.user = user;
    }
}
