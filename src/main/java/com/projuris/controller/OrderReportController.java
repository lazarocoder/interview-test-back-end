package com.projuris.controller;

import com.projuris.dto.OrderReportDTO;
import com.projuris.service.OrderReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping(value = "api/reports", produces = {"application/json"}  )
@Tag(name = "Controller of the reports")
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
public class OrderReportController {

    @Autowired
    private OrderReportService orderReportService;

    @Operation(method = "GET", summary = "Searching the reports", description = "Searching the reports.")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<OrderReportDTO>> getOrderReport() {
        List<OrderReportDTO> orderReports = orderReportService.getOrderReport();
        return new ResponseEntity<>(orderReports, HttpStatus.OK);
    }
}
