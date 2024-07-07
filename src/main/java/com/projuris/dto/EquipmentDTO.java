package com.projuris.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EquipmentDTO {

    private String type;
    private String brand;

    public EquipmentDTO() {

        this.type = type;
        this.brand = brand;

    }

}
