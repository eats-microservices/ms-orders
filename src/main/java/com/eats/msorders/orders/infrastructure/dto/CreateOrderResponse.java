package com.eats.msorders.orders.infrastructure.dto;

import com.eats.msorders.orders.domain.Items;
import com.eats.msorders.orders.domain.OrderStatus;

import java.math.BigDecimal;
import java.util.Set;

public record CreateOrderResponse(
        Long id,
        BigDecimal price,
        OrderStatus status,
        Long userId,
        Set<Items> items
) {
}
