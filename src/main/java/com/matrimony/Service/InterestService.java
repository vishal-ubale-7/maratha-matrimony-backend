package com.matrimony.Service;



import com.matrimony.Entities.Interest;
import com.matrimony.Entities.User;
import com.matrimony.Repositories.InterestRepository;
import com.matrimony.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InterestService
{


    @Autowired
    private InterestRepository interestRepo;

    @Autowired
    private UserRepository userRepo;

    public String likeUser(Long senderId, Long receiverId)
    {
        User sender = userRepo.findById(senderId).orElseThrow();
        User receiver = userRepo.findById(receiverId).orElseThrow();

        if (interestRepo.existsBySenderAndReceiver(sender, receiver)) {
            return "Already liked this user.";
        }

        Interest interest = new Interest();
        interest.setSender(sender);
        interest.setReceiver(receiver);
        interest.setStatus("PENDING");
        interest.setTimestamp(LocalDateTime.now().toString());

        interestRepo.save(interest);
        return "Interest sent successfully!";
    }

    public List<Interest> getReceivedLikes(Long userId)
    {
        User receiver = userRepo.findById(userId).orElseThrow();
        return interestRepo.findByReceiver(receiver);
    }


    public List<Interest> getSentLikes(Long userId)
    {
        User sender = userRepo.findById(userId).orElseThrow();
        return interestRepo.findBySender(sender);
    }

    public String respondToInterest(Long interestId, String action) {
        Interest interest = interestRepo.findById(interestId).orElseThrow(() -> new RuntimeException("Interest not found"));

        if (action.equalsIgnoreCase("accept")) {
            interest.setStatus("ACCEPTED");
        } else if (action.equalsIgnoreCase("reject")) {
            interest.setStatus("REJECTED");
        } else {
            return "Invalid action. Use 'accept' or 'reject'.";
        }

        interestRepo.save(interest);
        return "Interest " + interest.getStatus().toLowerCase() + " successfully!";
    }



}
