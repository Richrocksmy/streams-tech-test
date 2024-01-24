package com.imgarena.repository;

import com.imgarena.repository.entity.Match;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MapMatchRepositoryTest {

    @Test
    public void shouldSaveAndRetrieveMatchById() {
        // Given
        MatchRepository matchRepository = new MapMatchRepository();
        Match match = new Match(1, "First Match");

        // When
        matchRepository.save(match);
        Match returnedMatch = matchRepository.findById(1).get();

        // Then
        assertThat(returnedMatch).isEqualTo(match);
    }

    @Test
    public void shouldRetrieveAllMatches() {
        // Given
        MatchRepository matchRepository = new MapMatchRepository();
        Match match1 = new Match(1, "First Match");
        Match match2 = new Match(2, "Second Match");
        Match match3 = new Match(3, "Third Match");

        // When
        matchRepository.save(match1);
        matchRepository.save(match2);
        matchRepository.save(match3);

        List<Match> returnedMatches = matchRepository.findAll();

        // Then
        assertThat(returnedMatches).containsExactlyInAnyOrder(match1, match2, match3);
    }

}