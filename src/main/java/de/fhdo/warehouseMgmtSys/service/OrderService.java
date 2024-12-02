package de.fhdo.warehouseMgmtSys.service;

import de.fhdo.warehouseMgmtSys.data.OrderRepository;
import de.fhdo.warehouseMgmtSys.models.Order;

import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        Order existingOrder = orderRepository.findById(order.getOrderId()).orElse(null);
        if (existingOrder != null) {
            existingOrder.setCustomerId(order.getCustomerId());
            existingOrder.setStatus(order.getStatus());
            existingOrder.setCreatedDate(order.getCreatedDate());

            return orderRepository.save(existingOrder);
        }
        return null;

    }
}
