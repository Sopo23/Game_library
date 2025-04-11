package com.sopo.steam.Service;

import com.sopo.steam.Entity.Game;
import com.sopo.steam.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game findGame(String name){
        Game game=gameRepository.findGameByName(name);
        System.out.println(game.getPrice());
       return  game;
    }
    public List<Game> findByGenre(String genre){
        return gameRepository.findGamesByGenre(genre);
    }
    public Game createGame(String name, String genre,Float price){
        Game game=new Game();

        game.setName(name);
        game.setGenre(genre);
        game.setPrice(price);
        gameRepository.save(game);
        return game;
    }
    public List<Game> showLibrary(){
        return gameRepository.findAll();
    }
}
