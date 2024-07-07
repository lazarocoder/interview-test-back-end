package com.projuris.service;

import com.projuris.dto.ResponsibleDTO;
import com.projuris.exception.EntityException;
import com.projuris.model.Responsible;
import com.projuris.repository.ResponsibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponsibleService {

    @Autowired
    private ResponsibleRepository responsibleRepository;

    public ResponsibleDTO createResponsible(ResponsibleDTO responsibleDTO) {
        try {
            Responsible responsible = new Responsible();
            responsible.setName(responsibleDTO.getName());

            Responsible savedResponsible = responsibleRepository.save(responsible);
            return convertToDTO(savedResponsible);
        } catch (Exception e) {
            throw new EntityException("Error creating responsible");
        }
    }

    public List<ResponsibleDTO> getAllResponsibles() {
        try {
            List<Responsible> responsibles = responsibleRepository.findAll();
            return responsibles.stream().map(this::convertToDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new EntityException("Error fetching all responsibles");
        }
    }

    public ResponsibleDTO getResponsibleById(Long id) {
        Responsible responsible = responsibleRepository.findById(id)
                .orElseThrow(() -> new EntityException("Responsible not found with id " + id));
        return convertToDTO(responsible);
    }

    private ResponsibleDTO convertToDTO(Responsible responsible) {
        return new ResponsibleDTO(responsible.getId(), responsible.getName());
    }
}
