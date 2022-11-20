package com.eats.msorders.orders.infrastructure.dto;

public class PaymentDoneDto {
    private Long id;
    private Long userId;

    @Deprecated
    public PaymentDoneDto() {}

    public PaymentDoneDto(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }
}
