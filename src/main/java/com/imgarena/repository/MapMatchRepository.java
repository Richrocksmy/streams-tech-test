package com.imgarena.repository;

import com.imgarena.repository.entity.Match;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class MapMatchRepository implements MatchRepository {

    private final Map<Integer, Match> repository = new HashMap<>();

    public MapMatchRepository() {
//        repository.put(1, new Match(1, "Mary vs Isadora"));
//        repository.put(2, new Match(2, "Pollyanna vs Isadora"));
    }

    @Override
    public void save(Match match) {
        repository.put(match.id(), match);
    }

    @Override
    public List<Match> findAll() {
        return repository.values().stream().toList();
    }

    @Override
    public Optional<Match> findById(int id) {
        return Optional.ofNullable(repository.get(id));
    }
}
