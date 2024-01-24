package com.imgarena.repository;

import com.imgarena.repository.entity.Match;

import java.util.List;
import java.util.Optional;

public class MapMatchRepository implements MatchRepository {
    @Override
    public void save(Match match) {

    }

    @Override
    public List<Match> findAll() {
        return null;
    }

    @Override
    public Optional<Match> findById(int id) {
        return Optional.empty();
    }
}
