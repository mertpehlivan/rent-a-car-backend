package com.mertdev.test.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "plate")
    private String plate;

    @Column(name = "dailyPrice")
    private String dailyPrice;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "state")
    private int state; // 1-Available, 2-Rented, 3-Maintenance

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
