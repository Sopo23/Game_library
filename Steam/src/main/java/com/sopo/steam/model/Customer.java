package com.sopo.steam.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CustomerData")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "Customer_Id")
    Long customer_Id;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "Funds")
    private float funds;
    @Column(name = "listofgames",nullable = true)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Customer_game",
            joinColumns = @JoinColumn(name = "Customer_Id"),
            inverseJoinColumns = @JoinColumn(name = "Game_id"))
    private List<Game> listOfGames;
    @OneToOne(targetEntity = Whishlist.class)
    private Whishlist whishlist;
}
