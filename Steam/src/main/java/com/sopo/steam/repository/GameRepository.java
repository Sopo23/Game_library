package com.sopo.steam.Repository;

import com.sopo.steam.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    public Game findGameByName(String name);
    public List<Game> findGamesByGenre(String genre);
}
