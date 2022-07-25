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

    /*
    *  How to decide and manipulate data that we want to show or serialize?
    *  For example if we want to display rent we would get all the data displayed along with the relationships below.
    *  We could annotate something with @JsonIgnore, but it seems not to be a good practice. Moreover even though
    *  we want to display for example startFacility field, but we don't want to display workers of the facility
    *  how can we do it? Assuming that we can't use @JsonIgnore on the workers in facility entity because we need it
    *  somewhere else
    * */
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
