package com.deloitte.carApp.rent.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateRentDto {

    private Long id;

    private int loan;

    private LocalDate rentalDate;

    private Long carId;

    private Long clientId;

    private Long startFacilityId;

    private Long endFacilityId;

}
