package de.fhdo.warehouseMgmtSys.domain;

import jakarta.persistence.*;

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
    @Column(name = "PHONE_NUMBER")
    private String phoneNo;

    public User(long userId, String name, String address, Role role, String phoneNo) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.role = role;
        this.phoneNo = phoneNo;
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


    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
