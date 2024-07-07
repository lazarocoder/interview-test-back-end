package com.projuris.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderReportDTO {
    private Long orderId;
    private String orderDescription;
    private LocalDateTime orderStartDate;
    private LocalDateTime orderEndDate;
    private String clientName;
    private String clientEmail;
    private String equipmentType;
    private String equipmentBrand;
    private String responsibleName;

    public OrderReportDTO(Long orderId, String orderDescription, LocalDateTime orderStartDate, LocalDateTime orderEndDate,
                          String clientName, String clientEmail, String equipmentType, String equipmentBrand,
                          String responsibleName) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.orderStartDate = orderStartDate;
        this.orderEndDate = orderEndDate;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.equipmentType = equipmentType;
        this.equipmentBrand = equipmentBrand;
        this.responsibleName = responsibleName;
    }

}
