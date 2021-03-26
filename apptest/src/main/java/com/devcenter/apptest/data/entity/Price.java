package com.devcenter.apptest.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Price implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double cost;

    public Price(Long id, LocalDate startDate, LocalDate endDate, Double cost) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }
}
