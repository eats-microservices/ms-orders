package com.eats.msorders.orders.infrastructure.dto;

import com.eats.msorders.orders.domain.Items;
import com.eats.msorders.orders.domain.Order;
import com.eats.msorders.orders.domain.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateOrderRequest {

    private BigDecimal price;
    private Set<ItemsRequest> items;
    private Long userId;

    public CreateOrderRequest(BigDecimal price, Set<ItemsRequest> items, Long userId) {
        this.price = price;
        this.items = items;
        this.userId = userId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<ItemsRequest> getItems() {
        return items;
    }

    public Long getUserId() {
        return userId;
    }

    public Order toModel() {
        return new Order(
                price,
                OrderStatus.PAYMENT_PENDING,
                userId,
                items.stream().map(itemsRequest -> new Items(itemsRequest)).collect(Collectors.toSet()),
                Instant.now(),
                Instant.now()
        );
    }
}
