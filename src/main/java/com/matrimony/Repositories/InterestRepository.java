package com.matrimony.Repositories;

import com.matrimony.Entities.Interest;
import com.matrimony.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepository extends JpaRepository<Interest,Long>
{

    List<Interest> findByReceiver(User receiver);
    List<Interest> findBySender(User sender);
    boolean existsBySenderAndReceiver(User sender, User receiver);

    List<Interest> findByReceiverAndStatus(User receiver, String status);
    List<Interest> findBySenderAndStatus(User sender, String status);
}
