package com.deloitte.carApp.facility.service;

import com.deloitte.carApp.address.service.AddressService;
import com.deloitte.carApp.address.entity.Address;
import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.facility.dto.CreateFacilityDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class FacilityAddressService {

    private FacilityService facilityService;

    private AddressService addressService;

    private ModelMapper modelMapper;

    @Transactional
    public Facility saveAddressFacility(CreateFacilityDto createFacilityDto) {
        addressService.saveAddress(modelMapper.map(createFacilityDto.getAddress(), Address.class));
        return facilityService.saveFacilityFromDto(createFacilityDto);
    }
}
