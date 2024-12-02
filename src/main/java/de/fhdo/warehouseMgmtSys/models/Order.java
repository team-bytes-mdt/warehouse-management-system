package de.fhdo.warehouseMgmtSys.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @Column(name="ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name="CUSTOMER_ID")
    private long customerId;

    @Column(name="STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus status; // Enum for OrderStatus

    @Column(name="CREATED_DATE")
    private LocalDateTime createdDate;

    public Order() {

    }

    // Constructor
    public Order(long orderId, long customerId, OrderStatus status, LocalDateTime createdDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.status = status;
        this.createdDate = createdDate;
    }



    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


}
