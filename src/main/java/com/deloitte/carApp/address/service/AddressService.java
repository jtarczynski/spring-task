package com.deloitte.carApp.address.service;

import com.deloitte.carApp.address.entity.Address;
import com.deloitte.carApp.address.repository.AddressRepository;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    public Address findAddress(Long id) {
        return addressRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.ADDRESS_NOT_FOUND));
    }

    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Transactional
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Transactional
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
