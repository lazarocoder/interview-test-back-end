package com.projuris.controller;

import com.projuris.dto.ResponsibleDTO;
import com.projuris.service.ResponsibleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/responsibles", produces = {"application/json"}  )
@Tag(name = "Controller for the responsibles ")
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
public class ResponsibleController {

    @Autowired
    private ResponsibleService responsibleService;

    @Operation(method = "POST", summary = "Register a responsibles", description = "Register a responsibles.")
    @ApiResponse(responseCode = "201", description = "CREATED")
    @PostMapping
    public ResponseEntity<ResponsibleDTO> createResponsible(@RequestBody ResponsibleDTO responsibleDTO) {
        ResponsibleDTO createdResponsible = responsibleService.createResponsible(responsibleDTO);
        return new ResponseEntity<>(createdResponsible, HttpStatus.CREATED);
    }

    @Operation(method = "GET", summary = "Search the responsibles", description = "Search the responsibles.")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<ResponsibleDTO>> getAllResponsibles() {
        List<ResponsibleDTO> responsibles = responsibleService.getAllResponsibles();
        return new ResponseEntity<>(responsibles, HttpStatus.OK);
    }
}
