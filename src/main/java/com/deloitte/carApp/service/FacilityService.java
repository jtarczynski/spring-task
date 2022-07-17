package com.deloitte.carApp.service;

import com.deloitte.carApp.entity.Car;
import com.deloitte.carApp.entity.Facility;
import com.deloitte.carApp.entity.Worker;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.repository.FacilityRepository;
import com.deloitte.carApp.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FacilityService {

    private FacilityRepository facilityRepository;

    private WorkerRepository workerRepository;

    public Facility findFacility(Long id) {
        return facilityRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public List<Facility> findAllFacilities() {
        return facilityRepository.findAll();
    }

    @Transactional
    public void saveFacility(Long id) {
        facilityRepository.save(findFacility(id));
    }

    @Transactional
    public void saveFacility(Facility facility) {
        facilityRepository.save(facility);
    }

    @Transactional
    public void updateFacility(Facility facility) {
        facilityRepository.save(facility);
    }

    @Transactional
    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }

    /*
        TODO > ask for bidirectional relationships updates
     */
    @Transactional
    public void addWorkerToFacility(Facility facility, Worker worker) {
        facility.getWorkers().add(worker); //Why Lazy Initialization exception?
        facilityRepository.save(facility);
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
