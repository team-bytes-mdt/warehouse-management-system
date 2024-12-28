package de.fhdo.warehouseMgmtSys.dto;

import de.fhdo.warehouseMgmtSys.domain.OrderStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class OrderDto {
    private long orderId;
    private long customerId;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;

    public OrderDto(long orderId, long customerId, OrderStatus orderStatus, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    public OrderDto() {

    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus status) {
        this.orderStatus = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
