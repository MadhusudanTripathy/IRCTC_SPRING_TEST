package com.irctc.IRCTC.repository;

import com.irctc.IRCTC.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
    @Query
    public List<Passenger> findAllByDate(LocalDate localDate);
}
