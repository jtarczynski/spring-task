package com.deloitte.carApp.facility.dto;


import com.deloitte.carApp.address.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateFacilityDto {

    private String phoneNumber;

    private String email;

    private Address address;

}
