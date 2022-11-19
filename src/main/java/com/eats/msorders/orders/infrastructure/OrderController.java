package com.eats.msorders.orders.infrastructure;

import com.eats.msorders.orders.application.OrderService;
import com.eats.msorders.orders.domain.Items;
import com.eats.msorders.orders.domain.Order;
import com.eats.msorders.orders.infrastructure.dto.CreateOrderRequest;
import com.eats.msorders.orders.infrastructure.dto.CreateOrderResponse;
import com.eats.msorders.orders.infrastructure.dto.ItemsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody @Valid CreateOrderRequest request) {
        Order order = service.createOrderAndItems(request);

        return ResponseEntity
                .ok(new CreateOrderResponse(
                        order.getId(),
                        order.getPrice(),
                        order.getStatus(),
                        order.getUserId(),
                        order.getItems()
                ));
    }

}
