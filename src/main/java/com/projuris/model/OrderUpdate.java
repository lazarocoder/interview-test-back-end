package com.projuris.model;

import com.projuris.enumerated.OrderUpdateType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class OrderUpdate {
    @jakarta.persistence.Id
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

    public OrderUpdate() {}

    public OrderUpdate(String description, LocalDateTime timestamp, OrderUpdateType type, Order order) {
        this.description = description;
        this.timestamp = timestamp;
        this.type = type;
        this.order = order;
    }

}
