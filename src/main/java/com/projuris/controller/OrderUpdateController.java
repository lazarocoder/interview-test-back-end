package com.projuris.controller;

import com.projuris.dto.OrderUpdateDTO;
import com.projuris.service.OrderUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/orders/{orderId}/updates", produces = {"application/json"}  )
    @Tag(name = "Controller of the order and update")
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
public class OrderUpdateController {

    @Autowired
    private OrderUpdateService orderUpdateService;

    @Operation(method = "PUT", summary = "Update orders by id", description = "Update orders by id.")
    @ApiResponse(responseCode = "200", description = "OK")
    @PutMapping
    public ResponseEntity<OrderUpdateDTO> createOrderUpdate(
            @PathVariable Long orderId,
            @RequestBody OrderUpdateDTO orderUpdateDTO) {
        OrderUpdateDTO createdOrderUpdate = orderUpdateService.createOrderUpdate(orderId, orderUpdateDTO);
        return new ResponseEntity<>(createdOrderUpdate, HttpStatus.CREATED);
    }

   /* @GetMapping
    public ResponseEntity<List<OrderUpdateDTO>> getOrderUpdatesByOrderId(@PathVariable Long orderId) {
        List<OrderUpdateDTO> orderUpdates = orderUpdateService.getOrderUpdatesByOrderId(orderId);
        return new ResponseEntity<>(orderUpdates, HttpStatus.OK);
    }*/
}
