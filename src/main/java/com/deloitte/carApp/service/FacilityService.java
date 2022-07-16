package com.deloitte.carApp.service;

import com.deloitte.carApp.entity.Car;
import com.deloitte.carApp.entity.Facility;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.repository.FacilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FacilityService {
    private FacilityRepository facilityRepository;

    public Facility findFacilityById(Long id) {
        return facilityRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public List<Facility> findAllFacilities() {
        return facilityRepository.findAll();
    }

    public void saveFacilityById(Long id) {
        facilityRepository.save(findFacilityById(id));
    }

        public void saveFacility(Facility facility) {
        facilityRepository.save(facility);
    }

    public void updateFacility(Facility facility) {
        facilityRepository.save(facility);
    }

    public void deleteFacilityById(Long id) {
        facilityRepository.deleteById(id);
    }
}
