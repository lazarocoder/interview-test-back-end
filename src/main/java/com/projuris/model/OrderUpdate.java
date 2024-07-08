package com.projuris.model;

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
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private OrderUpdateType type;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
