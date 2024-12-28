package de.fhdo.warehouseMgmtSys.controllers.order;

import de.fhdo.warehouseMgmtSys.converters.OrderConverter;
import de.fhdo.warehouseMgmtSys.domain.Order;
import de.fhdo.warehouseMgmtSys.dto.OrderDto;
import de.fhdo.warehouseMgmtSys.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        // Fetch all Orders and convert them to DTOs
        List<OrderDto> orders = orderService.getAllOrders()
                .stream()
                .map(OrderConverter::toDto)
                .collect(Collectors.toList());

        // Add DTO to the model
        System.out.println("Orders"+orders);
        model.addAttribute("orders", orders);
        return "order/orders";
    }

    @GetMapping("/{id}")
    public String getOrdersById(Model model, @PathVariable long id) {
        // Fetch item and convert it to DTO
        OrderDto order = orderService.getOrderById(id)
                .map(OrderConverter::toDto)
                .orElse(null);

        // Add DTO to the model
        model.addAttribute("order", order);
        return "order/order";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("order", new OrderDto());
        return "order/create-order";
    }

    @PostMapping
    public String createOrder(@ModelAttribute OrderDto orderDto) {
        Order order = OrderConverter.toEntity(orderDto);
        orderService.createOrder(order);
        return "redirect:/order";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable long id) {
        OrderDto order = orderService.getOrderById(id)
                .map(OrderConverter::toDto)
                .orElse(null);
        model.addAttribute("order", order);
        return "order/edit-order";
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable long id, @ModelAttribute OrderDto orderDto) {
        Order order = OrderConverter.toEntity(orderDto);
        orderService.updateOrder(id, order);
        return "redirect:/order";
    }

    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
        return "redirect:/order";
    }
}
