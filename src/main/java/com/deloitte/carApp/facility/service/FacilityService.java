package com.deloitte.carApp.facility.service;

import com.deloitte.carApp.car.service.CarService;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.facility.dto.FacilityDto;
import com.deloitte.carApp.facility.entity.Facility;
import com.deloitte.carApp.facility.repository.FacilityRepository;
import com.deloitte.carApp.worker.dto.WorkerDto;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.worker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FacilityService {

    private FacilityRepository facilityRepository;

    private WorkerService workerService;

    private CarService carService;

    private ModelMapper modelMapper;

    public FacilityDto getFacilityDto(Long id) {
        return modelMapper.map(findFacility(id), FacilityDto.class);
    }

    public Facility findFacility(Long id) {
        return facilityRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.FACILITY_NOT_FOUND));
    }

    public List<FacilityDto> findAllFacilities() {
        return facilityRepository.findAll()
                .stream()
                .map(facility -> modelMapper.map(facility, FacilityDto.class))
                .collect(Collectors.toList());
    }

    public List<WorkerDto> findAllFacilityWorkers(Long id) {
        return facilityRepository
                .findAllFacilityWorkers(findFacility(id))
                .stream()
                .map(worker -> modelMapper.map(worker, WorkerDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public Facility saveFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Transactional
    public Facility saveFacilityFromDto(FacilityDto facilityDto) {
        return saveFacility(modelMapper.map(facilityDto, Facility.class));
    }

    @Transactional
    public Facility updateFacility(Long facilityId, FacilityDto facilityDto) {
        Facility facility = findFacility(facilityId);
        facility.setAddress(facilityDto.getAddress());
        facility.setEmail(facilityDto.getEmail());
        facility.setPhoneNumber(facilityDto.getPhoneNumber());
        return saveFacility(facility);
    }

    @Transactional
    public Worker assignWorkerToFacility(Long facilityId, Long workerId) {
        Facility facility = findFacility(facilityId);
        Worker worker = workerService.findWorker(workerId);
        worker.setFacility(facility);
        workerService.saveWorker(worker);
        return worker;
    }

    @Transactional
    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }

    public List<WorkerDto> findAllFacilityWorkersByCar(Long carId) {
        return facilityRepository
                .findAllFacilityWorkersByCar(carService.findCar(carId))
                .stream()
                .map(worker -> modelMapper.map(worker, WorkerDto.class))
                .collect(Collectors.toList());
    }

    public List<Worker> findFacilityWorkers(Facility facility) {
        return facility.getWorkers();
    }

}
