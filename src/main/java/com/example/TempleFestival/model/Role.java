package com.example.TempleFestival.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Role{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int roleId;

    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<CommitteeMember> committeeMember;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    

}