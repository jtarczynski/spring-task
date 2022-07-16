package com.deloitte.carApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = HumanType.Values.WORKER)
@Table(name = "workers")
public class Worker extends Human {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Long id;

    @Column(name = "occupation")
    private String occupation;

    @ManyToMany
    List<Car> workerCars;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    Facility facility;

}
