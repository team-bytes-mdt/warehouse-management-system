package de.fhdo.warehouseMgmtSys.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="USER")
public class User {
    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(long userId, String name, String address, Role role) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.role = role;
    }

    public User() {

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
