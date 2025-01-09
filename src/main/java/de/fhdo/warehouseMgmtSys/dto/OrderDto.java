package de.fhdo.warehouseMgmtSys.dto;

import de.fhdo.warehouseMgmtSys.domain.OrderStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class OrderDto {
    private long orderId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;

    public OrderDto() {

    }

    public OrderDto(long orderId, String customerName, String customerAddress, String customerPhoneNumber, OrderStatus orderStatus, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }



    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
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
