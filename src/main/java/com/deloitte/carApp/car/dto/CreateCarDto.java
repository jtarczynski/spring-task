package com.deloitte.carApp.car.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCarDto {

    private String carType;

    private String brand;

    private String color;

    private String engine;

    private String power;

    private int productionYear;

    private int mileage;
}
