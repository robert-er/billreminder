package com.billreminder.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private int month;
    @OneToMany(targetEntity = Bill.class,
            mappedBy = "board",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Bill> bills;
}
