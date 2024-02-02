package com.imgarena.controller;

import com.imgarena.controller.dto.MatchDto;
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
    public List<MatchDto> getAllMatches() {
        return matchService.retrieveAllMatches().stream()
                .map(it -> new MatchDto(it.getId(), it.getTitle()))
                .toList();
    }

    @GetMapping("/{matchId}")
    public MatchDto getMatch(@PathVariable final int matchId) {
        Match match = matchService.retrieveMatch(matchId);
        MatchDto matchDto = new MatchDto(match.getId(), match.getTitle());
        return matchDto;
    }
}
