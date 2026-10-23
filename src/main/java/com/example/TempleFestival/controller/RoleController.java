package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.TempleFestival.service.RoleService;
import com.example.TempleFestival.DTO.request.RoleRequestDTO;
import com.example.TempleFestival.DTO.response.RoleResponseDTO;
import java.util.List;
import jakarta.validation.Valid;

@RestController 
public class RoleController {
    
    @Autowired 
    private RoleService service;

    //role
      @PostMapping("/role/create")
      public String roleInsert(@Valid @RequestBody RoleRequestDTO request){
         return service.roleInsert(request);
      }

      @GetMapping("/role/get")
      public List<RoleResponseDTO> roleGet(){
         return service.roleGet();
      }

      @GetMapping("/role/getId/{id}")
      public RoleResponseDTO roleGetId(@PathVariable int id){
         return service.roleGetId(id);
      }

      @PutMapping("/role/update/{id}")
      public String roleUpdate(@PathVariable int id , @Valid @RequestBody RoleRequestDTO request){
         return service.roleUpdate(id,request);
      }

      @DeleteMapping("/role/deleteId/{id}")
      public String roleDeleteId(@PathVariable int id){
         return service.roleDeleteId(id);
      }
}
