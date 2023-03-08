package com.irctc.IRCTC.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "train")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int train_no;
    private String source;
    private String destination;

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList<>();

//    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
//    List<FoodOrder> foodOrders = new ArrayList<>();


}
