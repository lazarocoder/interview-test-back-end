package com.projuris.service;

import com.projuris.dto.OrderReportDTO;
import com.projuris.model.Order;
import com.projuris.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderReportService {



    private final OrderRepository orderRepository;

    public List<OrderReportDTO> getOrderReport() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(order -> {
                    OrderReportDTO dto = new OrderReportDTO();
                    dto.setOrderId(order.getId());
                    dto.setOrderDescription(order.getDescription());
                    dto.setOrderStartDate(order.getStartDate().atStartOfDay());
                    dto.setOrderEndDate(order.getEndDate().atStartOfDay());
                    dto.setClientName(order.getClient().getName());
                    dto.setClientEmail(order.getClient().getEmail());
                    dto.setEquipmentType(order.getEquipment().getType());
                    dto.setEquipmentBrand(order.getEquipment().getBrand());
                    dto.setResponsibleName(order.getResponsible().getName());
                    return dto;
                })
                .collect(Collectors.toList());
    }


    private OrderReportDTO convertToOrderReportDTO(Order order) {
        OrderReportDTO dto = new OrderReportDTO();
        dto.setOrderId(order.getId());
        dto.setOrderDescription(order.getDescription());
        dto.setOrderStartDate(order.getStartDate().atStartOfDay());
        dto.setOrderEndDate(order.getEndDate().atStartOfDay());
        dto.setClientName(order.getClient().getName());
        dto.setClientEmail(order.getClient().getEmail());
        dto.setEquipmentType(order.getEquipment().getType());
        dto.setEquipmentBrand(order.getEquipment().getBrand());
        dto.setResponsibleName(order.getResponsible().getName());
        return dto;
    }

}
