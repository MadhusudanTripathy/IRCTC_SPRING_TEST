package com.irctc.IRCTC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TotalPriceAPIDTO {
    private int train_id;
    private LocalDate localDate;
}
