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

    public OrderReportDTO() {
    }

}
