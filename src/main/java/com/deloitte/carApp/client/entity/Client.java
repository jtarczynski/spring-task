package com.deloitte.carApp.client.entity;

import com.deloitte.carApp.human.entity.Human;
import com.deloitte.carApp.human.entity.HumanType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = HumanType.Values.CLIENT)
public class Client extends Human {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

}
