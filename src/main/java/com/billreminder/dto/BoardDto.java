package com.billreminder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class BoardDto {

    private Long id;
    private int year;
    private int month;
    private BigDecimal monthlyPayment;

    public BoardDto(int year, int month) {
        this.year = year;
        this.month = month;
    }
}
