package de.fhdo.warehouseMgmtSys.service;

import de.fhdo.warehouseMgmtSys.repositories.OrderRepository;
import de.fhdo.warehouseMgmtSys.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return this.orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public Optional<Order> updateOrder(long id,Order order) {
        return orderRepository.findById(id).map(existing -> {
            existing.setOrderId(order.getOrderId());
            existing.setCustomerId(order.getCustomerId());
            existing.setStatus(order.getStatus());
            existing.setCreatedDate(order.getCreatedDate());
            return orderRepository.save(existing);
        });


    }

    public boolean deleteOrder(long id) {
        if(this.orderRepository.existsById(id)) {
            this.orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
