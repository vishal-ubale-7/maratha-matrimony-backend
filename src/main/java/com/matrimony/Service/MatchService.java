package com.matrimony.Service;


import com.matrimony.Entities.Match;
import com.matrimony.Repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService
{

    @Autowired
    private MatchRepository matchRepository;


    // save match
    public Match saveMatch(Match match)
    {
        return matchRepository.save(match);
    }

    //  getAllMatches
    public List<Match> getAllMatches()
    {
        return matchRepository.findAll();
    }


    // getMatchById
    public Optional<Match> getMatchById(Long id)
    {
        return matchRepository.findById(id);
    }

    //update match
    public Match updateMatch(Long id, Match updatedMatch)
    {
        updatedMatch.setId(id);
        return matchRepository.save(updatedMatch);
    }

    // delete match
    public void deleteMatch(Long id)
    {
        matchRepository.deleteById(id);
    }

}
