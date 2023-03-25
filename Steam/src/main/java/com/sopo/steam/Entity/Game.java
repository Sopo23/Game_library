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
@Table(name="Game")
public class Game {
    @Id
    @GeneratedValue
    @Column(name = "Game_id")
    Long gameId;
@Column(name = "Name")
    private String name;
@Column(name = "Price")
    private float price;
@Column(name = "Genre")
    private String genre;

}
