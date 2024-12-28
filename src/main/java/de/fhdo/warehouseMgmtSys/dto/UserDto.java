package de.fhdo.warehouseMgmtSys.dto;

import de.fhdo.warehouseMgmtSys.domain.Role;

public class UserDto {
    private long userId;
    private String name;
    private String address;
    private Role role;
    private String phone;

    public UserDto() {}
    public UserDto(long userId, String name, String address, Role role, String phone) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.role = role;
        this.phone = phone;
    }

    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
