package com.eats.msorders.orders.domain;

import com.eats.msorders.orders.infrastructure.dto.ItemsRequest;

import javax.persistence.*;

@Entity
public class Items {

    @Id
    private Long id;
    private String name;

    @Deprecated
    public Items() {}

    public Items(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Items(ItemsRequest itemsRequest) {
        this.id = itemsRequest.id();
        this.name = itemsRequest.name();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
