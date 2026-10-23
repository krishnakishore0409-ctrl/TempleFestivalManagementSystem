package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.TempleFestival.service.UnitService;
import com.example.TempleFestival.DTO.request.UnitRequestDTO;
import com.example.TempleFestival.DTO.response.UnitResponseDTO;
import java.util.List;
import jakarta.validation.Valid;


@RestController 
public class UnitController {
    
    @Autowired 
    private UnitService service;

    //Unit
      @PostMapping("/unit/create")
      public String unitInsert(@Valid @RequestBody UnitRequestDTO request){
         return service.unitInsert(request);
      }

      @GetMapping("/unit/get")
      public List<UnitResponseDTO> unitInsert(){
         return service.unitGet();
      }

      @GetMapping("/unit/getId/{id}")
      public UnitResponseDTO unitGetId(@PathVariable int id){
         return service.unitGetId(id);
      }

      @PutMapping("/unit/update/{id}")
      public String unitUpdate(@PathVariable int id , @Valid @RequestBody UnitRequestDTO request){
         return service.unitUpdate(id,request);
      }

      @DeleteMapping("/unit/deleteId/{id}")
      public String unitDeleteId(@PathVariable int id){
         return service.unitDeleteId(id);
      }

}
