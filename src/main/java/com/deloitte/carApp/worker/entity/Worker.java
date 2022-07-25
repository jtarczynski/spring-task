package com.deloitte.carApp.worker.entity;

import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.human.entity.Human;
import com.deloitte.carApp.human.entity.HumanType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SuperBuilder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = HumanType.Values.WORKER)
public class Worker extends Human {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Long id;

    @Column(name = "occupation")
    private String occupation;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "workerCar", joinColumns =
    @JoinColumn(name = " worker_id"), inverseJoinColumns =
    @JoinColumn(name = "car_id"))
    @JsonIgnore
    List<Car> workerCars;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    @JsonIgnore
    Facility facility;
}
