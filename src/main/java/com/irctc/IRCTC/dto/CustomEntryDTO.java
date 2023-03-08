package com.irctc.IRCTC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomEntryDTO {
    private String source;
    private String destination;
    private LocalDate localDate;
}
