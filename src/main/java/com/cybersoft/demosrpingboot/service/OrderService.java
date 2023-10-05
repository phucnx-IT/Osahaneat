package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.payload.OrderRequest;
import com.cybersoft.demosrpingboot.repository.OrderRepository;
import com.cybersoft.demosrpingboot.service.imp.OrderServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    private OrderRepository orderRepository;

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Override
    public Boolean insertOrder(OrderRequest orderRequest) {
//        try {
//            Users users = new Users();
//            users.setId(orderRequest.getUserId());
//
//            Restaurant restaurant = new Restaurant();
//            restaurant.setId(orderRequest.getRestaurantId());
//
//            Orders orders = new Orders();
//            orders.setUser(users);
//            orders.setRestaurant(restaurant);
//            orderRepository.save(orders);
//
//            List<OrderItem> orderItemList = new ArrayList<>();
//            for (Integer foodId: orderRequest.getFoodId()) {
//                OrderItem orderItem = new OrderItem();
//                KeyOrderItem keyOrderItem = new KeyOrderItem(orders.getId(), foodId);
//                orderItem.setKeyOrderItem(keyOrderItem);
//                orderItemList.add(orderItem);
//            }
//            orderItemRepository.saveAll(orderItemList);
//            return true;
//        }catch (Exception e){
//            logger.warn(e.getMessage());
//        }
        return false;

    }
}
