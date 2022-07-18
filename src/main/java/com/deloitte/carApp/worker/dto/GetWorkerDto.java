package com.deloitte.carApp.worker.dto;

import com.deloitte.carApp.address.entity.Address;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class GetWorkerDto {

    private Long id;

    private String occupation;

    private Address address;

    private String phoneNumber;

    private String name;

    private String surname;

    private LocalDate birthDate;

}
