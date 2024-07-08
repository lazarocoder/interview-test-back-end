package com.projuris.controller;


import com.projuris.dto.EquipmentDTO;
import com.projuris.service.EquipmentService;
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

class EquipmentControllerTest {

    @Mock
    private EquipmentService equipmentService;

    @InjectMocks
    private EquipmentController equipmentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEquipment() {
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        EquipmentDTO createdEquipmentDTO = new EquipmentDTO();

        when(equipmentService.createEquipment(equipmentDTO)).thenReturn(createdEquipmentDTO);

        ResponseEntity<EquipmentDTO> response = equipmentController.createEquipment(equipmentDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdEquipmentDTO, response.getBody());
        verify(equipmentService, times(1)).createEquipment(equipmentDTO);
    }

    @Test
    void getAllEquipments() {
        EquipmentDTO equipment1 = new EquipmentDTO();
        EquipmentDTO equipment2 = new EquipmentDTO();
        List<EquipmentDTO> equipmentList = Arrays.asList(equipment1, equipment2);

        when(equipmentService.getAllEquipments()).thenReturn(equipmentList);

        ResponseEntity<List<EquipmentDTO>> response = equipmentController.getAllEquipments();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(equipmentList, response.getBody());
        verify(equipmentService, times(1)).getAllEquipments();
    }
}
