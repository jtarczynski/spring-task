package com.deloitte.carApp.human.service;

import com.deloitte.carApp.address.service.AddressService;
import com.deloitte.carApp.worker.dto.CreateWorkerDto;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.worker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class HumanService {

    private WorkerService workerService;

    private AddressService addressService;

    @Transactional
    public Worker saveWorker(CreateWorkerDto createWorkerDto) {
        addressService.saveAddress(createWorkerDto.getAddress());
        return workerService.saveWorker(Worker.builder()
                .name(createWorkerDto.getName())
                .surname(createWorkerDto.getSurname())
                .occupation(createWorkerDto.getOccupation())
                .address(createWorkerDto.getAddress())
                .phoneNumber(createWorkerDto.getPhoneNumber())
                .birthDate(createWorkerDto.getBirthDate())
                .build());
    }
}
