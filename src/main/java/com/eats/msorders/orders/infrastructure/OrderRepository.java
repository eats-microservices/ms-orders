package com.eats.msorders.orders.infrastructure;

import com.eats.msorders.orders.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
