package com.projuris.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "equipement")
public class Equipment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;


    public void EquipmentDTO(Long id, String type, String brand) {
        this.id = id;
        this.type = type;
        this.brand = brand;
    }


}




