package com.projuris.controller;



import com.projuris.dto.ClientDTO;
import com.projuris.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClientControllerTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createClient() {
        ClientDTO clientDTO = new ClientDTO();
        ClientDTO createdClientDTO = new ClientDTO();

        when(clientService.createClient(clientDTO)).thenReturn(createdClientDTO);

        ResponseEntity<ClientDTO> response = clientController.createClient(clientDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdClientDTO, response.getBody());
        verify(clientService, times(1)).createClient(clientDTO);
    }

    @Test
    void getAllClients() {
        ClientDTO client1 = new ClientDTO();
        ClientDTO client2 = new ClientDTO();
        List<ClientDTO> clientList = Arrays.asList(client1, client2);

        when(clientService.getAllClients()).thenReturn(clientList);

        ResponseEntity<List<ClientDTO>> response = clientController.getAllClients();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clientList, response.getBody());
        verify(clientService, times(1)).getAllClients();
    }
}
