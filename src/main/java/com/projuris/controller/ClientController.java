package com.projuris.controller;

import com.projuris.dto.ClientDTO;
import com.projuris.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Log
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/clients", produces = {"application/json"} )
@Tag(name = " Controller of the Clients")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "405", description = "Method Not Allowed"),
        @ApiResponse(responseCode = "412", description = "Precondition Failed"),
        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
        @ApiResponse(responseCode = "422", description = "Unprocessable Entity"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
})
public class ClientController {


    private final ClientService clientService;

    @Operation(method = "POST", summary = "Register a customer", description = "Register a customer.")
    @ApiResponse(responseCode = "201", description = "CREATED")
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        log.info("Started, registering a customer...");
        ClientDTO createdClient = clientService.createClient(clientDTO);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);

    }

    @Operation(method = "GET", summary = "Search client", description = "Search client.")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        log.info("Started, searching  customers...");
        List<ClientDTO> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

}
