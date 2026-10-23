package com.example.TempleFestival.DTO.request;

import jakarta.validation.constraints.NotBlank;

public class RoleRequestDTO {
    
    @NotBlank (message = "Role name is required")
    private String roleName;
   
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    
}
