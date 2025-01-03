package de.fhdo.warehouseMgmtSys.graphqlapi;

import de.fhdo.warehouseMgmtSys.domain.Order;
import de.fhdo.warehouseMgmtSys.service.OrderService;
import de.fhdo.warehouseMgmtSys.domain.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderGraphQlController {

    private final OrderService orderService;

    @Autowired
    public OrderGraphQlController(OrderService orderService) {
        this.orderService = orderService;
    }

    @QueryMapping("orders")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @QueryMapping("order")
    public Optional<Order> getOrder(@Argument Long id) {
        return orderService.getOrderById(id);
    }

    @MutationMapping("createOrder")
    public Order createOrder(@Argument long customerId, @Argument String status, @Argument String createdDate) {
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setStatus(OrderStatus.valueOf(status.toUpperCase())); // Assuming enum values are uppercase
        order.setCreatedDate(LocalDateTime.parse(createdDate)); // ISO-8601 format
        return orderService.createOrder(order);
    }

    @MutationMapping("updateOrder")
    public Optional<Order> updateOrder(@Argument long id, @Argument String status) {
        return orderService.updateOrder(id, new Order(
                id,
                0, // Customer ID placeholder, won't be updated
                OrderStatus.valueOf(status.toUpperCase()),
                null // Created Date placeholder, won't be updated
        ));
    }

    @MutationMapping("deleteOrder")
    public boolean deleteOrder(@Argument long id) {
        return orderService.deleteOrder(id);
    }
}
