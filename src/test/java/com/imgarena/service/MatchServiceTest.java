package com.imgarena.service;

import com.imgarena.repository.MapMatchRepository;
import com.imgarena.repository.MatchRepository;
import com.imgarena.repository.entity.Match;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MatchServiceTest {

    @Test
    public void shouldRetrieveMatchById() {
        // Given
        MatchRepository matchRepository = new MapMatchRepository();
        MatchService matchService = new MatchService(matchRepository);
        Match match = new Match(1, "First Match");

        // When
        Match returnedMatch = matchService.saveMatch(match);

        // Then
        verify(matchRepository).save(match);
    }

    @Test
    public void shouldRetrieveAllMatches() {
        // Given
        MatchRepository matchRepository = new MapMatchRepository();
        MatchService matchService = new MatchService(matchRepository);
        List<Match> matches = List.of(new Match(1, "First Match"),
                new Match(2, "Second Match"),
                new Match(3, "Third Match"));

        when(matchRepository.findAll()).thenReturn(matches);

        // When
        List<Match> returnedMatches = matchService.retrieveAllMatches();

        // Then
        assertThat(returnedMatches).containsExactlyInAnyOrder(matches);
    }

}