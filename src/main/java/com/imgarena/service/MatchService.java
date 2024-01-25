package com.imgarena.service;

import com.imgarena.exception.NotFoundException;
import com.imgarena.repository.MatchRepository;
import com.imgarena.repository.entity.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(final MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void saveMatch(final Match match) {
        matchRepository.save(match);
    }

    public Match retrieveMatch(final int id) {
        return matchRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public List<Match> retrieveAllMatches() {
        return matchRepository.findAll();
    }
}
