package com.projuris.service;

import com.projuris.dto.OrderDTO;
import com.projuris.exception.EntityException;
import com.projuris.model.Client;
import com.projuris.model.Equipment;
import com.projuris.model.Order;
import com.projuris.model.Responsible;
import com.projuris.repository.ClientRepository;
import com.projuris.repository.EquipmentRepository;
import com.projuris.repository.OrderRepository;
import com.projuris.repository.ResponsibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private ResponsibleRepository responsibleRepository;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setDescription(orderDTO.getDescription());
        order.setStartDate(orderDTO.getStartDate());
        order.setEndDate(orderDTO.getEndDate());

        Client client = clientRepository.findById(orderDTO.getClientId())
                .orElseThrow(() -> new EntityException("Client not found"));
        order.setClient(client);

        Equipment equipment = equipmentRepository.findById(orderDTO.getEquipmentId())
                .orElseThrow(() -> new EntityException("Equipment not found"));
        order.setEquipment(equipment);

        Responsible responsible = responsibleRepository.findById(orderDTO.getResponsibleId())
                .orElseThrow(() -> new EntityException("Responsible not found"));
        order.setResponsible(responsible);

        orderRepository.save(order);
        return convertToDTO(order);
    }

    public List<OrderDTO> getOrdersByResponsible(Long responsibleId) {
        List<Order> orders = orderRepository.findByResponsibleId(responsibleId);
        return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityException("Order not found"));
        order.setDescription(orderDTO.getDescription());
        order.setStartDate(orderDTO.getStartDate());
        order.setEndDate(orderDTO.getEndDate());

        orderRepository.save(order);
        return convertToDTO(order);
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDescription(order.getDescription());
        orderDTO.setStartDate(order.getStartDate());
        orderDTO.setEndDate(order.getEndDate());
        orderDTO.setClientId(order.getClient().getId());
        orderDTO.setEquipmentId(order.getEquipment().getId());
        orderDTO.setResponsibleId(order.getResponsible().getId());
        return orderDTO;
    }
}
