package com.matrimony.Entities;

import jakarta.persistence.*;

@Entity
public class Interest
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name= "sender_id")
    private  User sender;

    @ManyToOne
    @JoinColumn(name= "receiver_id")
    private User receiver;

    private String status = "Pending";

    private String timestamp;


    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setStatus(String pending)
    {
    }

    public void setReceiver(User receiver)
    {
    }

    public void setSender(User sender)
    {
    }

    public String getStatus()
    {
        return getStatus();
    }
}
