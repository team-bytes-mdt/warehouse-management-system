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

    public boolean deleteOrder(long id) {

        return false;
    }
}
