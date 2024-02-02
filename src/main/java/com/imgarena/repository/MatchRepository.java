package com.imgarena.repository;

import com.imgarena.repository.entity.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer> {}
