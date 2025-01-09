package de.fhdo.warehouseMgmtSys.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @Column(name="ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;

    @Column(name = "CUSTOMER_ADDRESS", nullable = false)
    private String customerAddress;

    @Column(name = "CUSTOMER_PHONE_NUMBER", nullable = false)
    private String customerPhoneNumber;

    @Column(name="STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus status; // Enum for OrderStatus

    @Column(name="CREATED_DATE", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    public Order() {

    }

    // Constructor
    public Order(long orderId, String customerName, String customerAddress, String customerPhoneNumber, OrderStatus status, LocalDateTime createdDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.status = status;
        this.createdDate = createdDate;
    }


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() { return customerName;}

    public void setCustomerName(String customerName) {this.customerName = customerName;}

    public String getCustomerAddress() {return customerAddress;}

    public void setCustomerAddress(String customerAddress) {this.customerAddress = customerAddress;}

    public String getCustomerPhoneNumber() {return customerPhoneNumber;}

    public void setCustomerPhoneNumber(String customerPhoneNumber) {this.customerPhoneNumber = customerPhoneNumber;}

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

    @PrePersist
    private void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        this.createdDate = LocalDateTime.now();
    }
}
