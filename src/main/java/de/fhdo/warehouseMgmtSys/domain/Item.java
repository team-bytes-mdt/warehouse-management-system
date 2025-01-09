package de.fhdo.warehouseMgmtSys.domain;

import jakarta.persistence.*;

@Entity
@Table(name="ITEM")
public class Item {
    @Id
    @Column(name="ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="QUANTITY")
    private int quantity;
    @Column(name="PRICE")
    private double price;
    @Column(name="CATEGORY")
    private String category;
    @Column(name="INVENTORY_ID")
    private long inventoryId;


    public Item() {

    }

    public Item(long id, String name, String description, int quantity, double price, String category, long inventoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.inventoryId = inventoryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }
}
