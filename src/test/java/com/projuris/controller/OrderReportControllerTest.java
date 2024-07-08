package com.projuris.controller;

import com.projuris.dto.OrderReportDTO;
import com.projuris.service.OrderReportService;
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

class OrderReportControllerTest {

    @Mock
    private OrderReportService orderReportService;

    @InjectMocks
    private OrderReportController orderReportController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getOrderReport() {
        OrderReportDTO report1 = new OrderReportDTO();
        OrderReportDTO report2 = new OrderReportDTO();
        List<OrderReportDTO> reportList = Arrays.asList(report1, report2);

        when(orderReportService.getOrderReport()).thenReturn(reportList);

        ResponseEntity<List<OrderReportDTO>> response = orderReportController.getOrderReport();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reportList, response.getBody());
        verify(orderReportService, times(1)).getOrderReport();
    }
}
