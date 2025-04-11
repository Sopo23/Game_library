package com.sopo.steam.Controller;

import com.sopo.steam.Entity.Game;
import com.sopo.steam.Entity.Whishlist;
import com.sopo.steam.Repository.CustomerRepository;
import com.sopo.steam.Repository.GameRepository;
import com.sopo.steam.Repository.WhishlistRepository;
import com.sopo.steam.Service.WhishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/whishlist")
public class WhishlistController {
    private final WhishListService whishListService;

    public WhishlistController(WhishListService whishListService) {
        this.whishListService = whishListService;
    }

    @PostMapping("/createWhishlist/{username}")
    public ResponseEntity<Whishlist> createWhishlist(@PathVariable String username){
        return new ResponseEntity<>(
                whishListService.createWhishlist(username),
                HttpStatus.CREATED);
    }
    @PutMapping("/addGamesToList/{gameName}")
    public ResponseEntity<List<Game>> addToWhislist(@PathVariable String gameName,@RequestParam Long id){
        System.out.println(id);
        return new ResponseEntity<>(
                whishListService.addGame(gameName,id),
                HttpStatus.OK
        );
    }
}
