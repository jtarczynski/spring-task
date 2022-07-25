package com.deloitte.carApp.facility.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private String country;

    private String city;

    private String street;

    private int streetNumber;

    private int houseNumber;

}
