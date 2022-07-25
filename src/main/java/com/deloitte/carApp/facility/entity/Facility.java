package com.deloitte.carApp.facility.entity;


import com.deloitte.carApp.worker.entity.Worker;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "facilities")
public class  Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Embedded
    private Address address;

    /*
        Why does it resolve Lazy init? When I had eager it was a bag problem, even though I got one EAGER in this class,
        when it was lazy I got lazy init.
     */
    @OneToMany(mappedBy = "facility")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Worker> workers;

}
