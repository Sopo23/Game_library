package com.sopo.steam.Service;

import com.sopo.steam.Entity.Customer;
import com.sopo.steam.Entity.Game;
import com.sopo.steam.Repository.CustomerRepository;
import com.sopo.steam.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    public CustomerRepository customerRepository;
    @Autowired
    public GameRepository gameRepository;
    public Customer createAccount(String username,String password){
       Customer customer=new Customer();
       customer.setUsername(username);
       customer.setPassword(password);
       customer.setFunds(0.00F);
       customerRepository.save(customer);
       return customer;
    }
    public float addFunds(String username,float funds){
        Customer customer = customerRepository.findCustomerByUsername(username);
        customer.setFunds(customer.getFunds()+funds);
        customerRepository.save(customer);
        return customer.getFunds();
    }
    public String changePassword(String username,String newpassword){
        Customer customer=customerRepository.findCustomerByUsername(username);
        customer.setPassword(newpassword);
        customerRepository.save(customer);
        return customer.getPassword();
    }
    //sa gaseasca customerul by name,
    //sa gasesc jocul
    //sa adauge numele jocului in list of games
    public List<Game> addAGame(String username, String gameName){
        Customer customer=customerRepository.findCustomerByUsername(username);
        Game game=gameRepository.findGameByName(gameName);
        List<Game> temporar =customer.getListOfGames();
        temporar.add(game);
        customerRepository.save(customer);
        return customer.getListOfGames();
    }
    public Customer login(String username,String password){
        Customer customer=customerRepository.findCustomerByUsername(username);
        if(customer==null)
        {
            System.out.println("Wrong username");
            return null;
        }
            if(!customer.getPassword().equals(password))
            {
                System.out.println("Wrong password");
                return null;
            }
        return customer;
    }
}

