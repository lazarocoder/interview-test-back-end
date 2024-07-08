package com.projuris.controller;



import com.projuris.dto.OrderDTO;
import com.projuris.service.OrderService;
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

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOrder() {
        OrderDTO orderDTO = new OrderDTO();
        OrderDTO createdOrderDTO = new OrderDTO();

        when(orderService.createOrder(orderDTO)).thenReturn(createdOrderDTO);

        ResponseEntity<OrderDTO> response = orderController.createOrder(orderDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdOrderDTO, response.getBody());
        verify(orderService, times(1)).createOrder(orderDTO);
    }

    @Test
    void getOrdersByResponsible() {
        Long responsibleId = 1L;
        OrderDTO order1 = new OrderDTO();
        OrderDTO order2 = new OrderDTO();
        List<OrderDTO> orderList = Arrays.asList(order1, order2);

        when(orderService.getOrdersByResponsible(responsibleId)).thenReturn(orderList);

        ResponseEntity<List<OrderDTO>> response = orderController.getOrdersByResponsible(responsibleId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orderList, response.getBody());
        verify(orderService, times(1)).getOrdersByResponsible(responsibleId);
    }

    @Test
    void updateOrder() {
        Long orderId = 1L;
        OrderDTO orderDTO = new OrderDTO();
        OrderDTO updatedOrderDTO = new OrderDTO();

        when(orderService.updateOrder(orderId, orderDTO)).thenReturn(updatedOrderDTO);

        ResponseEntity<OrderDTO> response = orderController.updateOrder(orderId, orderDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedOrderDTO, response.getBody());
        verify(orderService, times(1)).updateOrder(orderId, orderDTO);
    }
}
