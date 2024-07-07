package com.projuris.dto;

import com.projuris.enumerated.OrderUpdateType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderUpdateDTO {
    private Long id;
    private String description;
    private LocalDateTime timestamp;
    private OrderUpdateType type;

    public OrderUpdateDTO(Long id, String description, LocalDateTime timestamp, OrderUpdateType type) {
        this.id = id;
        this.description = description;
        this.timestamp = timestamp;
        this.type = type;
    }

}
