package com.projuris.service;

import com.projuris.dto.OrderDTO;
import com.projuris.model.Client;
import com.projuris.model.Equipment;
import com.projuris.model.Order;
import com.projuris.model.Responsible;
import com.projuris.repository.ClientRepository;
import com.projuris.repository.EquipmentRepository;
import com.projuris.repository.OrderRepository;
import com.projuris.repository.ResponsibleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private ClientRepository clientRepository;

    @MockBean
    private EquipmentRepository equipmentRepository;

    @MockBean
    private ResponsibleRepository responsibleRepository;

   @Test
    public void testCreateOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDescription("Test Order");
        orderDTO.setStartDate(LocalDate.now());
        orderDTO.setEndDate(LocalDate.now().plusDays(1));
        orderDTO.setClientId(1L);
        orderDTO.setEquipmentId(1L);
        orderDTO.setResponsibleId(1L);

        Client client = new Client();
        client.setId(1L);
        client.setName("Test Client");

        Equipment equipment = new Equipment();
        equipment.setId(1L);
        equipment.setType("Test Type");
        equipment.setBrand("Test Brand");

        Responsible responsible = new Responsible();
        responsible.setId(1L);
        responsible.setName("Test Responsible");

        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        Mockito.when(equipmentRepository.findById(1L)).thenReturn(Optional.of(equipment));
        Mockito.when(responsibleRepository.findById(1L)).thenReturn(Optional.of(responsible));
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(new Order());

        OrderDTO createdOrder = orderService.createOrder(orderDTO);

        assertNotNull(createdOrder);
        assertEquals("Test Order", createdOrder.getDescription());
    }
}
