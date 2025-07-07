package com.matrimony.Controller;


import com.matrimony.Entities.Match;
import com.matrimony.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/match")
public class MatchController
{
    @Autowired
    private MatchService matchService;

    @PostMapping
    public Match createMatch(@RequestBody Match match)
    {
        return matchService.saveMatch(match);
    }


    @GetMapping
    public List<Match> getAllMatches()
    {
        return matchService.getAllMatches();
    }


    @GetMapping("/{id}")
    public Optional<Match> getMatchById(@PathVariable Long id)
    {
        return matchService.getMatchById(id);
    }

    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match match)
    {
        return matchService.updateMatch(id, match);
    }

    @DeleteMapping("/{id}")
    public String deleteMatch(@PathVariable Long id)
    {
        matchService.deleteMatch(id);
        return "Match deleted successfully for ID: " + id;
    }
}
