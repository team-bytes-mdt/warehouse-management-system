package de.fhdo.warehouseMgmtSys.graphqlapi;

import de.fhdo.warehouseMgmtSys.domain.Order;
import de.fhdo.warehouseMgmtSys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

@Controller
public class OrderGraphQlController {

    private final OrderService orderService;

    @Autowired
    public OrderGraphQlController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Query to fetch all orders
    @QueryMapping
    public List<Order> orders() {
        return orderService.getAllOrders();
    }

    // Query to fetch an order by ID
    @QueryMapping
    public Order order(@Argument Long orderId) {
        return orderService.getOrderById(orderId).orElse(null);
    }

    // Mutation to create a new order
    @MutationMapping
    public Order createOrder(@Argument Order order) {
        return orderService.createOrder(order);
    }

    // Mutation to update an existing order
    @MutationMapping
    public Order updateOrder(@Argument Long orderId, @Argument Order order) {
        return orderService.updateOrder(orderId, order).orElse(null);
    }

    // Mutation to delete an order by ID
    @MutationMapping
    public Boolean deleteOrder(@Argument Long orderId) {
        return orderService.deleteOrder(orderId);
    }
}
