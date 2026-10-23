package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.TempleFestival.service.MemberService;
import java.util.List;
import com.example.TempleFestival.DTO.request.MemberRequestDTO;
import com.example.TempleFestival.DTO.response.MemberResponseDTO;
import jakarta.validation.Valid;

@RestController
public class MemberController {


    @Autowired
    private MemberService service;


    //Member
    @PostMapping("/member/create")
    public String memberInsert(@Valid @RequestBody MemberRequestDTO request){
        return service.memberInsert(request);
    }

     @GetMapping("/member/get")
     public List<MemberResponseDTO> memberGet(){
      return service.memberGet();
     }

     @GetMapping("/member/getId/{id}")
     public MemberResponseDTO memberGetId(@PathVariable int id){
        return service.memberGetId(id);
     }

     @PutMapping("/member/update/{id}")
     public String memberUpdate(@PathVariable  int id , @Valid @RequestBody MemberRequestDTO request){
        return service.memberUpdate(id,request);
     }

     @DeleteMapping("/member/deleteId/{id}")
        public String memberDeleteId(@PathVariable int id){
            return service.memberDeleteId(id);
        }

}
