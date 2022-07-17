package com.deloitte.carApp.service;

import com.deloitte.carApp.entity.Client;
import com.deloitte.carApp.exception.AppException;
import com.deloitte.carApp.exception.Error;
import com.deloitte.carApp.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;

    public Client findClient(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new AppException(Error.CAR_NOT_FOUND));
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
