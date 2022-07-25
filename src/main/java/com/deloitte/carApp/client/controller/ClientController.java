package com.deloitte.carApp.client.controller;

import com.deloitte.carApp.client.dto.ClientDto;
import com.deloitte.carApp.client.entity.Client;
import com.deloitte.carApp.client.service.ClientService;
import com.deloitte.carApp.human.service.HumanService;
import com.deloitte.carApp.worker.dto.WorkerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    private HumanService humanService;

    @GetMapping("all")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @GetMapping("client-id/{clientId}")
    public ResponseEntity<WorkerDto> getClient(@PathVariable("clientId") Long clientId) {
        return ResponseEntity.ok(clientService.getClientDto(clientId));
    }

    @PostMapping("add-client")
    public ResponseEntity<Client> addClient(@Valid @RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(humanService.saveClient(clientDto));
    }

    @DeleteMapping("delete-client/client-id/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable("clientId") Long clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.accepted().build();
    }
}
