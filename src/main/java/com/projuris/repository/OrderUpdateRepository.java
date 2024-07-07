package com.projuris.repository;

import com.projuris.model.OrderUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderUpdateRepository extends JpaRepository<OrderUpdate, Long> {
    Collection<Object> findByOrderId(Long orderId);
}
