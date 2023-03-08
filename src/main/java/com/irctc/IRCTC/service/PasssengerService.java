package com.irctc.IRCTC.service;

import com.irctc.IRCTC.dto.CustomEntryDTO;
import com.irctc.IRCTC.dto.FemaleEntryDTO;
import com.irctc.IRCTC.dto.PassengerEntryDTO;
import com.irctc.IRCTC.dto.TotalPriceAPIDTO;
import com.irctc.IRCTC.entity.FoodOrder;
import com.irctc.IRCTC.entity.Passenger;
import com.irctc.IRCTC.entity.Train;
import com.irctc.IRCTC.repository.FoodOrderRepository;
import com.irctc.IRCTC.repository.PassengerRepository;
import com.irctc.IRCTC.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class PasssengerService {
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    TrainRepository trainRepository;

    @Autowired
    FoodOrderRepository foodOrderRepository;

    public PasssengerService(){

    }
    public String addPassenger(PassengerEntryDTO passengerEntryDTO){
        Passenger passenger= new Passenger();
        passenger.setAge(passengerEntryDTO.getAge());
        passenger.setDate(passengerEntryDTO.getDate());
        passenger.setGender(passengerEntryDTO.getGender());
        Train train = trainRepository.findById(passengerEntryDTO.getTrain_no()).orElse(new Train());
        passenger.setTrain(train);
        train.getPassengers().add(passenger);
        trainRepository.save(train);
        System.out.println("\n\n\n\n\n\n");
        System.out.println(train.getPassengers());
        System.out.println("\n\n\n\n\n\n");
        return "Success";
    }

    public List<Passenger> getAll(){
        return passengerRepository.findAll();
    }

    public List<Passenger> getCustomXYD(CustomEntryDTO customEntryDTO){
        List<Passenger> passengers=passengerRepository.findAll();
        List<Passenger> filteredPassengers=new ArrayList<>();
        for(Passenger passenger: passengers){
            Train train = trainRepository.findById(passenger.getTrain().getTrain_no()).get();
            if(train.getSource().equals(customEntryDTO.getSource())
            && train.getDestination().equals(customEntryDTO.getDestination())
                    && customEntryDTO.getLocalDate().equals(passenger.getDate())
            ){
                filteredPassengers.add(passenger);
            }
        }
        return filteredPassengers;
    }
    public List<Passenger> getCustomFC(FemaleEntryDTO femaleEntryDTO){
        List<Passenger> passengers=passengerRepository.findAll();
        List<Passenger> filteredPassengers=new ArrayList<>();
        for(Passenger passenger: passengers){
            Train train = trainRepository.findById(passenger.getTrain().getTrain_no()).get();

            if(train.getDestination().equals(femaleEntryDTO.getDestination())
                    && passenger.getAge()>=femaleEntryDTO.getAge_a()
                    && passenger.getAge()<=femaleEntryDTO.getAge_b()
                    && passenger.getGender().equals("F")
            ){
                filteredPassengers.add(passenger);
            }
        }
        return filteredPassengers;
    }

    public int getTotalPrice(TotalPriceAPIDTO totalPriceAPIDTO){
        for(int i=0;i<10;i++){
            FoodOrder foodOrder = new FoodOrder();
            foodOrder.setId(i);
            foodOrder.setPrice(i*100-20);
            Passenger passsenger = new Passenger();
            Train train = trainRepository.findById(1).get();
            passsenger.setTrain(train);
            passsenger.setAge(i*10+2);
            passsenger.setDate(LocalDate.of(2020,12,31));
            passsenger.setGender("F");
            passsenger.getFoodOrderList().add(foodOrder);
            foodOrder.setPassenger(passsenger);
            passengerRepository.save(passsenger);
        }
        List<FoodOrder> foodOrders = foodOrderRepository.findAll();
        int sum=0;
        for(FoodOrder foodOrder:foodOrders){
            if(foodOrder.getPassenger().getDate().equals(totalPriceAPIDTO.getLocalDate())
                    &&foodOrder.getTrain_id()==totalPriceAPIDTO.getTrain_id()){
                sum+=foodOrder.getPrice();
            }
        }
        return sum;
    }
}
