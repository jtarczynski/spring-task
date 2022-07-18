package com.deloitte.carApp.address.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAdressDto {

    private String country;

    private String city;

    private String street;

    private int streetNumber;

    private int houseNumber;

}
