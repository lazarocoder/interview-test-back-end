package com.projuris.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class OrderDTO {

    private String description;
    private String solutionDetails;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long clientId;
    private Long equipmentId;
    private Long responsibleId;

    public OrderDTO() {}

}
