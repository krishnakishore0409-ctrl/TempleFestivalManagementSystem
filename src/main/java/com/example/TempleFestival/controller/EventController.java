package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TempleFestival.service.EventService;
import com.example.TempleFestival.DTO.request.EventRequestDTO;
import com.example.TempleFestival.DTO.response.EventResponseDTO;
import java.util.List;

import jakarta.validation.Valid;

@RestController 
public class EventController {
    
    @Autowired
    private EventService service;

    //Event
     @PostMapping("/event/create")
     public String eventInsert(@Valid @RequestBody EventRequestDTO request){
        return service.eventInsert(request);
     }

     @GetMapping("/event/get")
     public List<EventResponseDTO> eventGet(){
        return service.eventGet();
     }

     @GetMapping("/event/getId/{id}")
     public EventResponseDTO eventGetId(@PathVariable int id){
        return service.eventGetId(id);
     }

     @PutMapping("/event/update/{id}")
     public String eventUpdate(@PathVariable int id , @Valid @RequestBody EventRequestDTO request){
        return service.eventUpdate(id,request);
     }

     @DeleteMapping("/event/deleteId")
        public String eventDeleteId(@PathVariable int id){
            return service.eventDeleteId(id);
        }
     
}
