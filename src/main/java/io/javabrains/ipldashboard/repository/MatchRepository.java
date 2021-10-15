package io.javabrains.ipldashboard.repository;

import io.javabrains.ipldashboard.model.Match;
import io.javabrains.ipldashboard.model.Team;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> findByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable page);

    default List<Match> findLatestMatchesByTeam(String teamName, int size){
        Pageable page = PageRequest.of(0,4);
        return findByTeam1OrTeam2OrderByDateDesc(teamName,teamName,page);
    }
}
