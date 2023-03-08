package com.irctc.IRCTC.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "food_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn
    private Passenger passenger;
    private int train_id;
    private int price;
}
