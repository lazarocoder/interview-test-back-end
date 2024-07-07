package com.projuris.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponsibleDTO {

    private String name;

    public ResponsibleDTO(Long id, String name) {

        this.name = name;
    }

}
