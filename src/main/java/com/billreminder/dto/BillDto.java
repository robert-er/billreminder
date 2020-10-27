package com.billreminder.dto;

import com.billreminder.domain.Bill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class BillDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private Bill.Status status;

    public BillDto(String name, String description, BigDecimal amount, LocalDate paymentDate, Bill.Status status) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
    }
}
