package com.eats.msorders.orders.infrastructure.rabbitmq;

import com.eats.msorders.exceptions.ResourceNotFoundException;
import com.eats.msorders.orders.domain.Order;
import com.eats.msorders.orders.domain.OrderStatus;
import com.eats.msorders.orders.infrastructure.OrderRepository;
import com.eats.msorders.orders.infrastructure.dto.PaymentDoneDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class PaymentDoneListener {

    private final Logger logger = LoggerFactory.getLogger(PaymentDoneListener.class);
    private final OrderRepository repository;

    public PaymentDoneListener(OrderRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "payments.payment-done")
    @Transactional
    public void receiveMessage(@Payload PaymentDoneDto dto) {
        Optional<Order> possibleOrder = repository.findById(dto.getId());

        if (possibleOrder.isEmpty()) {
            throw new ResourceNotFoundException("Order not found with id " + dto.getId());
        }

        Order order = possibleOrder.get();

        order.setStatus(OrderStatus.PAYMENT_DONE);
        repository.save(order);

        logger.info("Order " + dto.getId() + " status updated to payment done");
    }

}
