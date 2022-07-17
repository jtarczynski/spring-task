package com.deloitte.carApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Long id;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "engine")
    private String engine;

    @Column(name = "power")
    private String power;

    @Column(name = "production_year")
    private int productionYear;

    @Column(name = "milleage")
    private int mileage;

    @OneToMany(mappedBy = "rentCar", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Rent> rents;

    @ManyToMany(mappedBy = "workerCars", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Worker> workers;

    @OneToOne
    private Client client;

}
