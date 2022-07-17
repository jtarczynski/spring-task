package com.deloitte.carApp.entity;


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
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    /*
        Why does it resolve Lazy init? When I had eager it was a bag problem, even though I got one EAGER in this class,
        when it was lazy I got lazy init.
     */
    @OneToMany(mappedBy = "facility")
    @LazyCollection(LazyCollectionOption.FALSE)
    @ToString.Exclude
    private List<Worker> workers;

}
