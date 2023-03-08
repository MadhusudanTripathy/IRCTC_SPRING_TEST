package com.irctc.IRCTC.controller;

import com.irctc.IRCTC.dto.CustomEntryDTO;
import com.irctc.IRCTC.dto.FemaleEntryDTO;
import com.irctc.IRCTC.dto.PassengerEntryDTO;
import com.irctc.IRCTC.dto.TotalPriceAPIDTO;
import com.irctc.IRCTC.entity.Passenger;
import com.irctc.IRCTC.service.PasssengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    PasssengerService passsengerService;

    @PostMapping("/")
    public String addPassenger(@RequestBody PassengerEntryDTO passengerEntryDTO){
        return passsengerService.addPassenger(passengerEntryDTO);
    }

    @GetMapping("/all")
    public List<Passenger> getAllPassengers(){
        return passsengerService.getAll();
    }

    @GetMapping("/get-count-of-X-Y-D")
    public List<Passenger> getCustomXYD(@RequestBody CustomEntryDTO customEntryDTO){
        return passsengerService.getCustomXYD(customEntryDTO);

    }
    @GetMapping("/get-count-of-F-C")
    public List<Passenger> getCustomFC(@RequestBody FemaleEntryDTO femaleEntryDTO){
        return passsengerService.getCustomFC(femaleEntryDTO);

    }

    @GetMapping("/get-count-of-total-price")
    public int getAllPrice(@RequestBody TotalPriceAPIDTO totalPriceAPIDTO){
        return passsengerService.getTotalPrice(totalPriceAPIDTO);
    }

}
