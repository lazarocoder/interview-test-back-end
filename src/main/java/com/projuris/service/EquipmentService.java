package com.projuris.service;

import com.projuris.dto.EquipmentDTO;
import com.projuris.exception.EntityException;
import com.projuris.model.Equipment;
import com.projuris.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public EquipmentDTO createEquipment(EquipmentDTO equipmentDTO) {
        try {
            Equipment equipment = new Equipment();
            equipment.setType(equipmentDTO.getType());
            equipment.setBrand(equipmentDTO.getBrand());

            Equipment savedEquipment = equipmentRepository.save(equipment);
            return convertToDTO(savedEquipment);
        } catch (Exception e) {
            throw new EntityException("Error creating equipment");
        }
    }

    public List<EquipmentDTO> getAllEquipments() {
        try {
            List<Equipment> equipments = equipmentRepository.findAll();
            return equipments.stream().map(this::convertToDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new EntityException("Error fetching all equipments");
        }
    }

    public EquipmentDTO getEquipmentById(Long id) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new EntityException("Equipment not found with id " + id));
        return convertToDTO(equipment);
    }

    private EquipmentDTO convertToDTO(Equipment equipment) {
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        equipmentDTO.setType(equipment.getType());
        equipmentDTO.setBrand(equipment.getBrand());
        return equipmentDTO;
    }
}
