package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.TempleFestival.service.ItemService;
import com.example.TempleFestival.DTO.request.ItemRequestDTO;
import com.example.TempleFestival.DTO.response.ItemResponseDTO;
import java.util.List;
import jakarta.validation.Valid;

@RestController 
public class ItemController {
    
      @Autowired 
      private ItemService service;

     //item
      @PostMapping("/item/create")
      public String itemInsert(@Valid @RequestBody ItemRequestDTO request){
         return service.itemInsert(request);
      }

      @GetMapping("/item/get")
      public List<ItemResponseDTO> itemGet(){
         return service.itemGet();
      }

      @GetMapping("/item/getId/{id}")
      public ItemResponseDTO itemGetId(@PathVariable int id){
         return service.itemGetId(id);
      }

      @PutMapping("/item/update/{id}")
      public String itemUpdate(@PathVariable  int id, @Valid @RequestBody ItemRequestDTO request){
         return service.itemUpdate(id,request);
      }

      @DeleteMapping("/item/DeleteId/{id}")
      public String itemDeleteId(@PathVariable int id){
         return service.itemDeleteId(id);
      }

}
