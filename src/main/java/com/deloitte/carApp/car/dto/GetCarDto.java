package com.deloitte.carApp.car.dto;

import lombok.*;

@Getter
@Setter
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
