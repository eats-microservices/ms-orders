package com.eats.msorders.orders.infrastructure;

import com.eats.msorders.orders.domain.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Long> {
}
