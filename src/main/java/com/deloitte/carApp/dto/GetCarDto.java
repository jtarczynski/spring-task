package com.deloitte.carApp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetCarDto {

    private Long id;

    private String carType;

    private String brand;

    private String color;

    private String engine;

    private String power;

    private int productionYear;

    private int mileage;

}
