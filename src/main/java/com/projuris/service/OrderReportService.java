package com.projuris.service;

import com.projuris.dto.OrderReportDTO;
import com.projuris.model.Order;
import com.projuris.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderReportService {


    @Autowired
    private OrderRepository orderRepository;

    public List<OrderReportDTO> getOrderReport() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> new OrderReportDTO(
                        order.getId(),
                        order.getDescription(),
                        order.getStartDate().atStartOfDay(),
                        order.getEndDate().atStartOfDay(),
                        order.getClient().getName(),
                        order.getClient().getEmail(),
                        order.getEquipment().getType(),
                        order.getEquipment().getBrand(),
                        order.getResponsible().getName()))
                .collect(Collectors.toList());
    }

    private OrderReportDTO convertToOrderReportDTO(Order order) {
        return new OrderReportDTO(
                order.getId(),
                order.getDescription(),
                order.getStartDate().atStartOfDay(),
                order.getEndDate().atStartOfDay(),
                order.getClient().getName(),
                order.getClient().getEmail(),
                order.getEquipment().getType(),
                order.getEquipment().getBrand(),
                order.getResponsible().getName()
        );
    }
}
