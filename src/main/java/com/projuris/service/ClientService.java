package com.projuris.service;

import com.projuris.dto.ClientDTO;
import com.projuris.exception.EntityException;
import com.projuris.model.Client;
import com.projuris.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientService {


    private final ClientRepository clientRepository;

    public ClientDTO createClient(ClientDTO clientDTO) {
        try {
            Client client = new Client();
            client.setName(clientDTO.getName());
            client.setAddress(clientDTO.getAddress());
            client.setPhone(clientDTO.getPhone());
            client.setEmail(clientDTO.getEmail());

            Client savedClient = clientRepository.save(client);
            return convertToDTO(savedClient);
        } catch (Exception e) {
            throw new EntityException("Error creating client");
        }
    }

    public List<ClientDTO> getAllClients() {
        try {
            List<Client> clients = clientRepository.findAll();
            return clients.stream().map(this::convertToDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new EntityException("Error fetching all clients");
        }
    }

    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityException("Client not found with id " + id));
        return convertToDTO(client);
    }

    private ClientDTO convertToDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setEmail(client.getEmail());
        return clientDTO;
    }
}
