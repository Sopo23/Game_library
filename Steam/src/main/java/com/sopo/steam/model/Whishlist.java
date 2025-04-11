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
@Table(name = "WhishlistData")
public class Whishlist {
    @Id
    @GeneratedValue
    @Column(name = "WhishlistId")
    @JoinColumn(name = "idWhislist",referencedColumnName = "id")
    Long id;
    @Column(name = "WhishlistName")
    private String whishlistName;
    @Column(name = "WhishlistsGame",nullable = true)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "WhishListGame",
            joinColumns = @JoinColumn(name = "WhishlistId"),
            inverseJoinColumns = @JoinColumn(name = "Game_id"))
    private List<Game> games;


}
