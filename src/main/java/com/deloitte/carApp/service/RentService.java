package com.deloitte.carApp.service;

import com.deloitte.carApp.entity.Facility;
import com.deloitte.carApp.entity.Rent;
import com.deloitte.carApp.entity.Worker;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.repository.FacilityRepository;
import com.deloitte.carApp.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentService {
    private RentRepository rentRepository;

    public Rent findRentById(Long id) {
        return rentRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public List<Rent> findAllRents() {
        return rentRepository.findAll();
    }

    public void saveRentById(Long id) {
        rentRepository.save(findRentById(id));
    }

    public void deleteRentById(Long id) {
        rentRepository.deleteById(id);
    }
}
