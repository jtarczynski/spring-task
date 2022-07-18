package com.deloitte.carApp.facility.dto;

import com.deloitte.carApp.address.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetFacilityDto {

    private Long id;

    private String phoneNumber;

    private String email;

    private Address address;

}
