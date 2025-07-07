package com.matrimony.Entities;

import jakarta.persistence.*;

@Entity
public class Match
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @OneToOne
    private User user;

    @OneToOne
    private User matchedWith;

    private boolean isAccepted;

  public Match()
  {

  }

    public Match(Long id, boolean isAccepted, User matchedWith, User user) {
        this.id = id;
        this.isAccepted = isAccepted;
        this.matchedWith = matchedWith;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public User getMatchedWith() {
        return matchedWith;
    }

    public void setMatchedWith(User matchedWith) {
        this.matchedWith = matchedWith;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
