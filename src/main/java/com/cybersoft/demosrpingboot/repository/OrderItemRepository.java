package com.cybersoft.demosrpingboot.repository;

import com.cybersoft.demosrpingboot.entity.OrderItem;
import com.cybersoft.demosrpingboot.entity.keys.KeyOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,KeyOrderItem> {
}
