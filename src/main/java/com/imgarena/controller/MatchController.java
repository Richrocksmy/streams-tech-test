package com.imgarena.controller;

import com.imgarena.repository.entity.Match;
import com.imgarena.service.MatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(final MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping()
    public List<Match> getAllMatches() {
        return matchService.retrieveAllMatches();
    }

    @GetMapping("/{matchId}")
    public Match getMatch(@PathVariable final int matchId) {
        return matchService.retrieveMatch(matchId);
    }
}
