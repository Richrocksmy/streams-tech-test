package com.imgarena.repository;

import com.imgarena.repository.entity.Match;

import java.util.List;
import java.util.Optional;

public interface MatchRepository {

    void save(Match match);

    List<Match> findAll();

    Optional<Match> findById(int id);
}
