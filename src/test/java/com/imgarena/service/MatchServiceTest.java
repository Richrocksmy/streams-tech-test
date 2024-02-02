package com.imgarena.service;

import com.imgarena.repository.MatchRepository;
import com.imgarena.repository.entity.Match;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MatchServiceTest {

    @Test
    public void shouldRetrieveMatchById() {
        // Given
        MatchRepository matchRepository = mock(MatchRepository.class);
        MatchService matchService = new MatchService(matchRepository);
        Match match = new Match(1, "First Match");

        when(matchRepository.findById(1)).thenReturn(Optional.ofNullable(match));

        // When
        matchService.saveMatch(match);
        Match returnedMatch = matchService.retrieveMatch(1);

        // Then
        verify(matchRepository).save(match);
        assertThat(returnedMatch).isEqualTo(match);
    }

    @Test
    public void shouldRetrieveAllMatches() {
        // Given
        MatchRepository matchRepository = mock(MatchRepository.class);
        MatchService matchService = new MatchService(matchRepository);
        List<Match> matches = List.of(new Match(1, "First Match"),
                new Match(2, "Second Match"),
                new Match(3, "Third Match"));

        when(matchRepository.findAll()).thenReturn(matches);

        // When
        List<Match> returnedMatches = matchService.retrieveAllMatches();

        // Then
        assertThat(returnedMatches).containsExactlyElementsOf(matches);
    }

}