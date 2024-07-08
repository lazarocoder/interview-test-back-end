package com.projuris.controller;


import com.projuris.dto.OrderUpdateDTO;
import com.projuris.service.OrderUpdateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderUpdateControllerTest {

    @Mock
    private OrderUpdateService orderUpdateService;

    @InjectMocks
    private OrderUpdateController orderUpdateController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOrderUpdate() {
        Long orderId = 1L;
        OrderUpdateDTO orderUpdateDTO = new OrderUpdateDTO();
        OrderUpdateDTO createdOrderUpdateDTO = new OrderUpdateDTO();

        when(orderUpdateService.createOrderUpdate(orderId, orderUpdateDTO)).thenReturn(createdOrderUpdateDTO);

        ResponseEntity<OrderUpdateDTO> response = orderUpdateController.createOrderUpdate(orderId, orderUpdateDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdOrderUpdateDTO, response.getBody());
        verify(orderUpdateService, times(1)).createOrderUpdate(orderId, orderUpdateDTO);
    }
}
