package com.deloitte.carApp.rent.dto;

import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.client.entity.Client;
import com.deloitte.carApp.facility.entity.Facility;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentDto {

    private Long id;

    private int loan;

    private LocalDate rentalDate;

    private Car rentCar;

    private Client client;

    private Facility startFacility;

    private Facility endFacility;
}
