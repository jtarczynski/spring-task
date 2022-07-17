package com.deloitte.carApp.service;

import com.deloitte.carApp.entity.Address;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.repository.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    public Address findAddressById(Long id) {
        return addressRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.ADDRESS_NOT_FOUND));
    }

    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Transactional
    public void saveAddress(Long id) {
        addressRepository.save(findAddressById(id));
    }

    @Transactional
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
