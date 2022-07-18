package com.deloitte.carApp.facility.service;

import com.deloitte.carApp.car.entity.Car;
import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.facility.dto.CreateFacilityDto;
import com.deloitte.carApp.facility.repository.FacilityRepository;
import com.deloitte.carApp.facility.dto.GetFacilityDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class FacilityService {

    private FacilityRepository facilityRepository;

    private ModelMapper modelMapper;

    public GetFacilityDto getFacilityDto(Long id) {
        Facility facility = facilityRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.FACILITY_NOT_FOUND));
        return modelMapper.map(facility, GetFacilityDto.class);
    }

    public Facility findFacility(Long id) {
        return facilityRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.FACILITY_NOT_FOUND));
    }

    public List<GetFacilityDto> findAllFacilities() {
        return facilityRepository.findAll()
                .stream()
                .map(facility -> modelMapper.map(facility, GetFacilityDto.class))
                .toList();
    }

    @Transactional
    public Facility saveFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Transactional
    public Facility saveFacilityFromDto(CreateFacilityDto createFacilityDto) {
        return facilityRepository.save(modelMapper.map(createFacilityDto, Facility.class));
    }

    @Transactional
    public Facility updateFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Transactional
    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }

    @Transactional
    public void deleteWorkerFromFacility(Facility facility, Worker worker) {
        facility.getWorkers().remove(worker);
        facilityRepository.save(facility);
    }

    public List<Worker> findAllFacilityWorkersByCar(Car car) {
        return facilityRepository.findAllFacilityWorkersByCar(car);
    }

    public List<Worker> findFacilityWorkers(Facility facility) {
        return facility.getWorkers();
    }


}
