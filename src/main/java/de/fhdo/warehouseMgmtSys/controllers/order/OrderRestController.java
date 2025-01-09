package de.fhdo.warehouseMgmtSys.controllers.order;

import de.fhdo.warehouseMgmtSys.converters.OrderConverter;
import de.fhdo.warehouseMgmtSys.dto.OrderDto;
import de.fhdo.warehouseMgmtSys.service.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OrderRestController {
    private final OrderService orderService;


    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Get all inventories
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllInventory() {
        List<OrderDto> OrderDtos = orderService.getAllOrders()
                .stream().map(OrderConverter::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(OrderDtos);
    }

    // Get inventory by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getInventoryById(@PathVariable Long id) {

        return orderService.getOrderById(id)
                .map(OrderConverter::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    // Create a new inventory
    @PostMapping
    public ResponseEntity<OrderDto> createInventory(@RequestBody OrderDto OrderDto) {
        var Order = OrderConverter.toEntity(OrderDto);
        var savedOrder = orderService.createOrder(Order);
        return new ResponseEntity<>(OrderConverter.toDto(savedOrder), HttpStatus.CREATED);

    }

    // Update an inventory
    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateInventory(@PathVariable long id,
                                                   @RequestBody OrderDto OrderDto) {
        var Order = OrderConverter.toEntity(OrderDto);
        var updatedOrder = orderService.updateOrder(id, Order);
        return updatedOrder.map(value -> ResponseEntity.ok(OrderConverter.toDto(value)))
                .orElse(ResponseEntity.notFound().build());

    }

    // Delete an inventory
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDto> deleteInventory(@PathVariable long id) {
        if(orderService.deleteOrder(id)){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }




}
