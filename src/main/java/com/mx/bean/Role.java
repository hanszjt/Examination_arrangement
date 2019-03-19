package com.mx.bean;

/**
 * Created by mx on 2019/2/21.
 */
public class Role {
    private String role;
    private String name;

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
