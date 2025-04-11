package com.sopo.steam.Controller;

import com.sopo.steam.Entity.Customer;
import com.sopo.steam.Entity.Game;
import com.sopo.steam.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/newCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.createAccount(customer.getUsername(),customer.getPassword()),
                HttpStatus.CREATED);
    }
   @PutMapping("/addFunds/{username}")
    public ResponseEntity<Float> addFunds(@PathVariable String username, @RequestParam float funds){
        return new ResponseEntity<>(customerService.addFunds(username, funds), HttpStatus.OK);
   }
   @PutMapping("/changepassword/{username}")
   public ResponseEntity<String> changePassword(@PathVariable String username,@RequestParam String newPassword){
        return new ResponseEntity<>(customerService.changePassword(username,newPassword),HttpStatus.OK);
   }
   @PutMapping("/addGameToCustomer/{username}/{gameName}")
    public ResponseEntity<List<Game>> addGameToCustomer(@PathVariable String username,@PathVariable String gameName){
        return new ResponseEntity<>(
                customerService.addAGame(username,gameName)
                ,HttpStatus.CREATED);
   }
    @RequestMapping(value = "logincheck",method = RequestMethod.POST)
    public ResponseEntity<Customer> login (@RequestBody Map<String,String> loginData){
        return new ResponseEntity<>(customerService.login(loginData.get("username"),loginData.get("password")),
                HttpStatus.FOUND
        );
    }

}
