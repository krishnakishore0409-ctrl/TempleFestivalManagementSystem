package com.example.TempleFestival.mapper;

import com.example.TempleFestival.DTO.request.RoleRequestDTO;
import com.example.TempleFestival.DTO.response.RoleResponseDTO;
import com.example.TempleFestival.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public Role  toEntity(RoleRequestDTO request){

        Role role = new Role();

        role.setRoleName(request.getRoleName());

        return role;

    }

    public RoleResponseDTO toResponse(Role role){

        RoleResponseDTO response = new RoleResponseDTO();

        response.setRoleId(role.getRoleId());
        response.setRoleName(role.getRoleName());

        return response;

    }
    
}
