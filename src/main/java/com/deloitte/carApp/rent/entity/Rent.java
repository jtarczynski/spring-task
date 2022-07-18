package com.deloitte.carApp.rent.entity;

import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.client.entity.Client;
import com.deloitte.carApp.facility.entity.Facility;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rents")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Long id;

    @Column(name = "loan")
    private int loan;

    @Column(name = "rental_date")
    private LocalDate rentalDate;

    @ManyToOne
    @JoinColumn(name = "rentCar")
    private Car rentCar;

    @OneToOne
    private Client client;

    @OneToOne
    private Facility startFacility;

    @OneToOne
    private Facility endFacility;

}
