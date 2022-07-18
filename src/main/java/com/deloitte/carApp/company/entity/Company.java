package com.deloitte.carApp.company.entity;

import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.client.entity.Client;
import com.deloitte.carApp.facility.entity.Facility;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Long id;

    @OneToMany
    private List<Facility> facilities;

    @OneToMany
    private List<Client> clients;

    @OneToMany
    private List<Car> cars;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int foundationYear;

}
