package com.deloitte.carApp.rent.service;

import com.deloitte.carApp.rent.entity.Rent;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.rent.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RentService {
    private RentRepository rentRepository;

    public Rent findRentById(Long id) {
        return rentRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.RENT_NOT_FOUND));
    }

    public List<Rent> findAllRents() {
        return rentRepository.findAll();
    }

    @Transactional
    public void saveRent(Rent rent) {
        rentRepository.save(rent);
    }

    @Transactional
    public void deleteRent(Long id) {
        rentRepository.deleteById(id);
    }
}
