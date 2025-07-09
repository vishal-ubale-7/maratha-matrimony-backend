package com.matrimony.Controller;


import com.matrimony.Entities.Interest;
import com.matrimony.Service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interests")
@CrossOrigin
public class InterestController
{

    @Autowired
    private InterestService interestService;


    // Send a like/interest
    @PostMapping("/like")
    public String likeUser(@RequestParam Long senderId, @RequestParam Long receiverId)
    {
        return interestService.likeUser(senderId, receiverId);
    }

    // See all likes received
    @GetMapping("/received/{userId}")
    public List<Interest> getReceived(@PathVariable Long userId)
    {
        return interestService.getReceivedLikes(userId);
    }

    // See all likes sent
    @GetMapping("/sent/{userId}")
    public List<Interest> getSent(@PathVariable Long userId)
    {
        return interestService.getSentLikes(userId);
    }

    @PutMapping("/respond")
    public String respondToInterest(
            @RequestParam Long interestId,
            @RequestParam String action  // "accept" or "reject"
    )
    {
        return interestService.respondToInterest(interestId, action);
    }


}
