package com.example.TempleFestival.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.TempleFestival.service.FestivalService;
import java.util.List;
import com.example.TempleFestival.DTO.request.FestivalRequestDTO;
import com.example.TempleFestival.DTO.response.FestivalResponseDTO;
import jakarta.validation.Valid;

@RestController
public class FestivalController {

    @Autowired 
    private FestivalService service;
    
    //Festival
     @PostMapping("/festival/create")
     public String festivalInsert(@Valid @RequestBody FestivalRequestDTO request){
        return service.festivalInsert(request);
     }

     @GetMapping("/festival/get")
     public List<FestivalResponseDTO> festivalGet(){
        return service.festivalGet();
     }

     @GetMapping("/festival/getId/{id}")
     public FestivalResponseDTO festivalGetId(@PathVariable int id){
        return service.festivalGetId(id);
     }

     @PutMapping("/festival/update/{id}")
     public String festivalUpdate(@PathVariable int id , @Valid @RequestBody FestivalRequestDTO request){
        return service.festivalUpdate(id,request);
     }

     @DeleteMapping("/festival/deleteId/{id}")
     public String festivalDeleteId(@PathVariable int id){
        return service.festivalDeleteId(id);
     }
}
