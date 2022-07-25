package com.deloitte.carApp.human.service;

import com.deloitte.carApp.client.dto.ClientDto;
import com.deloitte.carApp.client.entity.Client;
import com.deloitte.carApp.client.service.ClientService;
import com.deloitte.carApp.worker.dto.WorkerDto;
import com.deloitte.carApp.worker.entity.Worker;
import com.deloitte.carApp.worker.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class HumanService {

    private WorkerService workerService;

    private ClientService clientService;


    @Transactional
    public Worker saveWorker(WorkerDto workerDto) {
        return workerService.saveWorker(Worker.builder()
                .name(workerDto.getName())
                .surname(workerDto.getSurname())
                .occupation(workerDto.getOccupation())
                .phoneNumber(workerDto.getPhoneNumber())
                .birthDate(workerDto.getBirthDate())
                .build());
    }

    @Transactional
    public Client saveClient(ClientDto clientDto) {
        return clientService.saveClient(Client.builder()
                .name(clientDto.getName())
                .surname(clientDto.getSurname())
                .cardNumber(clientDto.getCardNumber())
                .phoneNumber(clientDto.getPhoneNumber())
                .birthDate(clientDto.getBirthDate())
                .build());
    }
}
