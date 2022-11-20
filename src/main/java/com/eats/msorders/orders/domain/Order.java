package com.eats.msorders.orders.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "tb_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Long userId;
    @ManyToMany
    private Set<Items> items;
    private Instant createdAt;
    private Instant updatedAt;

    @Deprecated
    public Order() {}

    public Order(Long id, BigDecimal price, OrderStatus status, Long userId, Set<Items> items, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.price = price;
        this.status = status;
        this.userId = userId;
        this.items = items;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Order(BigDecimal price, OrderStatus status, Long userId, Set<Items> items, Instant createdAt, Instant updatedAt) {
        this.price = price;
        this.status = status;
        this.userId = userId;
        this.items = items;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }

    public Set<Items> getItems() {
        return items;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
