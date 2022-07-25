package com.deloitte.carApp.client.service;

import com.deloitte.carApp.client.dto.ClientDto;
import com.deloitte.carApp.client.entity.Client;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.client.repository.ClientRepository;
import com.deloitte.carApp.worker.dto.WorkerDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;

    private ModelMapper modelMapper;

    public Client findClient(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.CLIENT_NOT_FOUND));
    }

    public WorkerDto getClientDto(Long id) {
        return modelMapper.map(findClient(id), WorkerDto.class);
    }

    public List<ClientDto> findAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
