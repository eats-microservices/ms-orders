package com.eats.msorders.orders.application;

import com.eats.msorders.orders.domain.Items;
import com.eats.msorders.orders.domain.Order;
import com.eats.msorders.orders.infrastructure.ItemsRepository;
import com.eats.msorders.orders.infrastructure.OrderRepository;
import com.eats.msorders.orders.infrastructure.dto.CreateOrderRequest;
import com.eats.msorders.orders.infrastructure.dto.ItemsRequest;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final ItemsRepository itemsRepository;

    public OrderService(OrderRepository repository, ItemsRepository itemsRepository) {
        this.repository = repository;
        this.itemsRepository = itemsRepository;
    }

    public Order createOrderAndItems(CreateOrderRequest request) {
        Order order = request.toModel();
        Set<ItemsRequest> items = request.getItems();

        items.forEach(item -> {
            boolean exists = itemsRepository.existsById(item.id());

            if (!exists) {
                itemsRepository.save(new Items(item));
            }
        });

        order = repository.save(order);
        return order;
    }
}
