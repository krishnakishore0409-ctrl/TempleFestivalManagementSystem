package com.example.TempleFestival.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TempleFestival.DTO.request.RoleRequestDTO;
import com.example.TempleFestival.DTO.response.RoleResponseDTO;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.mapper.RoleMapper;
import com.example.TempleFestival.model.Role;
import com.example.TempleFestival.model.Item;
import com.example.TempleFestival.repository.ItemRepository;
import com.example.TempleFestival.repository.RoleRepository;


@Service 
public class RoleService {
      
     @Autowired 
     private ItemRepository itemRepository;

      @Autowired
      private RoleRepository roleRepository;

      @Autowired
      private RoleMapper roleMapper;

      public String roleInsert(RoleRequestDTO request){

        Role role = roleMapper.toEntity(request);

        roleRepository.save(role);

        return "Role added Successfully...";

      }

      public List<RoleResponseDTO> roleGet(){
        List<Role> role = roleRepository.findAll();

        List<RoleResponseDTO> response = new ArrayList<>();

        for(Role r : role){

          RoleResponseDTO dto = roleMapper.toResponse(r);

          response.add(dto);

        }

        return response;

      }

      public RoleResponseDTO roleGetId(int id){

        Role role =  roleRepository.findById(id). 
        orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " +id));

        RoleResponseDTO response = roleMapper.toResponse(role);

        return response;
      }

      public String roleUpdate(int id,RoleRequestDTO  request){
      
         Role existingRole = roleRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id ));
        
         roleRepository.save(existingRole);

         return "Role Updated Succeessfully...";

      }

      public String roleDeleteId(int id){

         Item existingItem = itemRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));

        roleRepository.deleteById(existingItem.getItemId());

        return "Role Id :"+id+" Deleted Successfully...";

      }

}
