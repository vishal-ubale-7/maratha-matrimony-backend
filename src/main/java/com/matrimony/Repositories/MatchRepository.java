package com.matrimony.Repositories;

import com.matrimony.Entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,Long>
{
}
