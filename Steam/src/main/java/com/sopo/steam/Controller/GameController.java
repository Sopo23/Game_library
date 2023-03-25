package com.sopo.steam.Controller;

import com.sopo.steam.Entity.Customer;
import com.sopo.steam.Entity.Game;
import com.sopo.steam.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller

public class GameController {
    @Autowired
    public GameService gameService;
    @GetMapping ("/FindGame/{name}")
    public ResponseEntity<Game> findGame(@PathVariable String name){
        return new ResponseEntity<>(
                gameService.findGame(name),
                HttpStatus.FOUND);
    }
    @GetMapping("/FindGenere/{genre}")
    public  ResponseEntity<List<Game>> fingByGenre(@PathVariable String genre ){
        return new ResponseEntity<>(
                gameService.findByGenre(genre),
                HttpStatus.FOUND
        );
    }
    @PostMapping("/newGame")
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        return new ResponseEntity<>(gameService.createGame(
                game.getName(), game.getGenre(), game.getPrice()),
                HttpStatus.CREATED);
    }
    @GetMapping("/CreateLibrary")
    public ResponseEntity<List<Game>> createLibrary(){
        return new ResponseEntity<>(
                gameService.showLibrary(),
                HttpStatus.FOUND);
    }

}
