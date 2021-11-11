package com.example.springbootcruddemo.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private long roleId;

    @Column(name = "roleName")
    private String roleName;

    public Role(String roleName) {
        super();
        this.roleName = roleName;
    }
    public Role(){

    }

    public long getRoleID() {
        return roleId;
    }

    public void setRoleID(long roleID) {
        this.roleId = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
