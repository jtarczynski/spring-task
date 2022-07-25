package com.deloitte.carApp.facility.dto;

import com.deloitte.carApp.facility.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacilityDto {

    private Long id;

    private String phoneNumber;

    private String email;

    private Address address;

}
