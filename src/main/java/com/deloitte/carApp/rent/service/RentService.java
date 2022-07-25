package com.deloitte.carApp.rent.service;

import com.deloitte.carApp.car.service.CarService;
import com.deloitte.carApp.client.service.ClientService;
import com.deloitte.carApp.facility.service.FacilityService;
import com.deloitte.carApp.rent.dto.CreateRentDto;
import com.deloitte.carApp.rent.dto.RentDto;
import com.deloitte.carApp.rent.entity.Rent;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.rent.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentService {

    private RentRepository rentRepository;

    private ClientService clientService;

    private CarService carService;

    private FacilityService facilityService;

    private ModelMapper modelMapper;

    public Rent findRent(Long id) {
        return rentRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.RENT_NOT_FOUND));
    }

    public RentDto getRentDto(Long id) {
        return modelMapper.map(findRent(id), RentDto.class);
    }

    public List<RentDto> findAllRents() {
        return rentRepository.findAll()
                .stream()
                .map(rent -> modelMapper.map(rent, RentDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public Rent saveRent(CreateRentDto createRentDto) {
        RentDto rentDto = RentDto.builder()
                .id(createRentDto.getId())
                .loan(createRentDto.getLoan())
                .rentCar(carService.findCar(createRentDto.getCarId()))
                .client(clientService.findClient(createRentDto.getClientId()))
                .startFacility(facilityService.findFacility(createRentDto.getStartFacilityId()))
                .endFacility(facilityService.findFacility(createRentDto.getEndFacilityId()))
                .build();

        return rentRepository.save(modelMapper.map(rentDto, Rent.class));
    }

    @Transactional
    public void deleteRent(Long id) {
        rentRepository.deleteById(id);
    }
}
