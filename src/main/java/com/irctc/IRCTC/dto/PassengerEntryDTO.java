package com.irctc.IRCTC.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class PassengerEntryDTO {
    private LocalDate date;
    private int age;
    private String gender;
    private int train_no;

    public PassengerEntryDTO() {
    }

    public PassengerEntryDTO(LocalDate date, int age, String gender, int train_no) {
        this.date = date;
        this.age = age;
        this.gender = gender;
        this.train_no = train_no;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTrain_no() {
        return train_no;
    }

    public void setTrain_no(int train_no) {
        this.train_no = train_no;
    }
}
