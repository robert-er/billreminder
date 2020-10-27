package com.billreminder.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private Status status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="board_id")
    private Board board;

    private enum Status {
        PAID, UNPAID, OVERTIME
    }
}
