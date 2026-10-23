package com.example.TempleFestival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.TempleFestival.service.CommitteeMemberService;
import com.example.TempleFestival.DTO.request.CommitteeMemberRequestDTO;
import com.example.TempleFestival.DTO.response.CommitteeMemberResponseDTO;
import java.util.List;
import jakarta.validation.Valid;

@RestController 
public class CommitteeMemberController {

    @Autowired 
    private CommitteeMemberService service;
    
     //commiteemember
      @PostMapping("/committeeMember/create")
      public String committeeMemberInsert(@Valid @RequestBody CommitteeMemberRequestDTO request){
         return service.committeeMemberInsert(request);
      }

      @GetMapping("/committeeMember/get")
      public List<CommitteeMemberResponseDTO> committeeMemberGet(){
         return service.committeeMemberGet();
      }

      @GetMapping("/committeeMember/getId/{id}")
         public CommitteeMemberResponseDTO committeeMemberGetId(@PathVariable int id){
            return service.committeeMemberGetId(id);
         }
      
      @PutMapping("/committeeMember/update/{id}")
      public String committeeMemberUpdate(@PathVariable int id , @Valid @RequestBody CommitteeMemberRequestDTO request){
         return service.committeeMemberUpdate(id,request);
      }
     
      @DeleteMapping("/committeeMember/deleteId/{id}")
      public String committeeMemberDeleteId(@PathVariable int id){
         return service.committeeMemberDeleteId(id);
      }
}
