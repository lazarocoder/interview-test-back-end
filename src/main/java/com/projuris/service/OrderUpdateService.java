package com.projuris.service;

import com.projuris.dto.OrderUpdateDTO;
import com.projuris.exception.EntityException;
import com.projuris.model.Order;
import com.projuris.model.OrderUpdate;
import com.projuris.repository.OrderRepository;
import com.projuris.repository.OrderUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderUpdateService {

    @Autowired
    private OrderUpdateRepository orderUpdateRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderUpdateDTO createOrderUpdate(Long orderId, OrderUpdateDTO orderUpdateDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityException("Order not found with id " + orderId));
        OrderUpdate orderUpdate = new OrderUpdate(
                orderUpdateDTO.getDescription(),
                LocalDateTime.now(),
                orderUpdateDTO.getType(),
                order
        );
        OrderUpdate savedOrderUpdate = orderUpdateRepository.save(orderUpdate);
        return convertToDTO(savedOrderUpdate);
    }

   /* public List<OrderUpdateDTO> getOrderUpdatesByOrderId(Long orderId) {
        return orderUpdateRepository.findByOrderId(orderId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }*/

    private OrderUpdateDTO convertToDTO(OrderUpdate orderUpdate) {
        return new OrderUpdateDTO(
                orderUpdate.getId(),
                orderUpdate.getDescription(),
                orderUpdate.getTimestamp(),
                orderUpdate.getType()
        );
    }
}
