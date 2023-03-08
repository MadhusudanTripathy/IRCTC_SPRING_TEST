package com.irctc.IRCTC.repository;

import com.irctc.IRCTC.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

}
