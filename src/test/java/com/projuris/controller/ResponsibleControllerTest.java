package com.projuris.controller;



import com.projuris.dto.ResponsibleDTO;
import com.projuris.service.ResponsibleService;
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

class ResponsibleControllerTest {

    @Mock
    private ResponsibleService responsibleService;

    @InjectMocks
    private ResponsibleController responsibleController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createResponsible() {
        ResponsibleDTO responsibleDTO = new ResponsibleDTO();
        ResponsibleDTO createdResponsibleDTO = new ResponsibleDTO();

        when(responsibleService.createResponsible(responsibleDTO)).thenReturn(createdResponsibleDTO);

        ResponseEntity<ResponsibleDTO> response = responsibleController.createResponsible(responsibleDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdResponsibleDTO, response.getBody());
        verify(responsibleService, times(1)).createResponsible(responsibleDTO);
    }

    @Test
    void getAllResponsibles() {
        ResponsibleDTO responsible1 = new ResponsibleDTO();
        ResponsibleDTO responsible2 = new ResponsibleDTO();
        List<ResponsibleDTO> responsibleList = Arrays.asList(responsible1, responsible2);

        when(responsibleService.getAllResponsibles()).thenReturn(responsibleList);

        ResponseEntity<List<ResponsibleDTO>> response = responsibleController.getAllResponsibles();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responsibleList, response.getBody());
        verify(responsibleService, times(1)).getAllResponsibles();
    }
}
