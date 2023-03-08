package com.irctc.IRCTC.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passenger")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticket_id;
    private LocalDate date;
    private int age;
    private String gender;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Train train;

    @OneToMany(mappedBy = "passenger",cascade = CascadeType.ALL)
    List<FoodOrder> foodOrderList= new ArrayList<>();

    @Override
    public String toString() {
        return "Passenger{" +
                "ticket_id=" + ticket_id +
                ", date=" + date +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", train=" + train.getTrain_no() +
                ", foodOrderList=" + foodOrderList +
                '}';
    }
}
