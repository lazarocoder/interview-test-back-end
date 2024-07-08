package com.projuris.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projuris.enumerated.OrderUpdateType;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;




@Getter
@Setter
@Entity
@Table(name = "order_update")
public class OrderUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private OrderUpdateType type;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
