package com.sopo.steam.Service;

import com.sopo.steam.Entity.Customer;
import com.sopo.steam.Entity.Game;
import com.sopo.steam.Entity.Whishlist;
import com.sopo.steam.Repository.CustomerRepository;
import com.sopo.steam.Repository.GameRepository;
import com.sopo.steam.Repository.WhishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhishListService {
    @Autowired
    public WhishlistRepository whishlistRepository;
    @Autowired
    public GameRepository gameRepository;
    @Autowired
    public CustomerRepository customerRepository;

    public Whishlist createWhishlist(String username){
        Customer customer=customerRepository.findCustomerByUsername(username);
        if(customer!=null){
        Whishlist whishlist=new Whishlist();
        whishlist.setWhishlistName(username+"'s Whishlist");
        whishlistRepository.save(whishlist);
        customer.setWhishlist(whishlist);
        customerRepository.save(customer);
        return whishlist;
        }
        return null;
    }
    public List<Game> addGame (String gameName,Long id){
        Whishlist whishlist=whishlistRepository.getById(id);
        Game game=gameRepository.findGameByName(gameName);
        List<Game> aux=whishlist.getGames();
        aux.add(game);
        whishlist.setGames(aux);
        whishlistRepository.save(whishlist);
        return whishlist.getGames();
    }
}
