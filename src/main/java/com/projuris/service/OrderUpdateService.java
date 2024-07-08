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

@Service
public class OrderUpdateService {

    @Autowired
    private OrderUpdateRepository orderUpdateRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderUpdateDTO createOrderUpdate(Long orderId, OrderUpdateDTO orderUpdateDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityException("Order not found with id " + orderId));

        OrderUpdate orderUpdate = new OrderUpdate();
        orderUpdate.setDescription(orderUpdateDTO.getDescription());
        orderUpdate.setTimestamp(LocalDateTime.now());
        orderUpdate.setType(orderUpdateDTO.getType());
        orderUpdate.setOrder(order);

        OrderUpdate savedOrderUpdate = orderUpdateRepository.save(orderUpdate);
        return convertToDTO(savedOrderUpdate);
    }

    private OrderUpdateDTO convertToDTO(OrderUpdate orderUpdate) {
        OrderUpdateDTO orderUpdateDTO = new OrderUpdateDTO();
        orderUpdateDTO.setId(orderUpdate.getId());
        orderUpdateDTO.setDescription(orderUpdate.getDescription());
        orderUpdateDTO.setTimestamp(orderUpdate.getTimestamp());
        orderUpdateDTO.setType(orderUpdate.getType());
        return orderUpdateDTO;
    }

}
