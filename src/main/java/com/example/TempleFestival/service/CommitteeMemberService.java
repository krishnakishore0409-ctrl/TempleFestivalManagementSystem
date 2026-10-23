package com.example.TempleFestival.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TempleFestival.DTO.request.CommitteeMemberRequestDTO;
import com.example.TempleFestival.DTO.response.CommitteeMemberResponseDTO;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.mapper.CommitteeMemberMapper;
import com.example.TempleFestival.model.CommitteeMember;
import com.example.TempleFestival.model.Festival;
import com.example.TempleFestival.model.Member;
import com.example.TempleFestival.model.Role;
import com.example.TempleFestival.repository.CommitteeMemberRepository;
import com.example.TempleFestival.repository.FestivalRepository;
import com.example.TempleFestival.repository.MemberRepository;
import com.example.TempleFestival.repository.RoleRepository;

@Service 
public class CommitteeMemberService {
      
     @Autowired
      private FestivalRepository festivalRepository;

      @Autowired
      private MemberRepository memberRepository;

      @Autowired 
      private RoleRepository roleRepository;

      @Autowired
      private CommitteeMemberRepository committeeMemberRepository;

      @Autowired
      private CommitteeMemberMapper committeeMemberMapper;



      public String committeeMemberInsert(CommitteeMemberRequestDTO request){
      
        Member member = memberRepository.findById(request.getMemberId()). 
        orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + request.getMemberId() ));

        Festival festival = festivalRepository.findById(request.getFestivalId()). 
        orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + request.getFestivalId() ));

       Role role = roleRepository.findById(request.getRoleId()). 
        orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + request.getRoleId() ));

        CommitteeMember committeeMember = committeeMemberMapper.toEntity(member,festival,role,request);

        committeeMemberRepository.save(committeeMember);

        return "CommitteeMember Added Successfully...";
      }

      public List<CommitteeMemberResponseDTO> committeeMemberGet(){
        List<CommitteeMember> committeeMember = committeeMemberRepository.findAll();

        List<CommitteeMemberResponseDTO> response = new ArrayList<>();
        
        for(CommitteeMember c : committeeMember){

         CommitteeMemberResponseDTO dto = committeeMemberMapper.toResponse(c);

         response.add(dto);

        }
           return response;
      }

      public CommitteeMemberResponseDTO committeeMemberGetId(int id){

         CommitteeMember committeeMember = committeeMemberRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("CommitteeMember not found with id: " + id));

        CommitteeMemberResponseDTO response = committeeMemberMapper.toResponse(committeeMember);

        return response;
      }

      public String committeeMemberUpdate(int id,CommitteeMemberRequestDTO request){

        CommitteeMember existingCommitteeMember =  committeeMemberRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("CommitteeMember not found with id: " + id ));

      Festival festival = festivalRepository.findById(request.getFestivalId()).
       orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + request.getFestivalId() ));

       Member member = memberRepository.findById(request.getMemberId()).
         orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + request.getMemberId() ));

        Role role = roleRepository.findById(request.getRoleId()).
         orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + request.getRoleId() ));

         CommitteeMember committeeMember = committeeMemberMapper.toEntityUpdate(existingCommitteeMember,festival,member,role,request);

         committeeMemberRepository.save(committeeMember);

         return "CommitteeMember Update Successfully...";

      }

      public String committeeMemberDeleteId(int id){

        CommitteeMember existingCommitteeMember =  committeeMemberRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("CommitteeMember not found with id: " + id ));

        committeeMemberRepository.deleteById(existingCommitteeMember.getCommitteeMemberId());

        return "CommitteeMember Id :"+id+" Deleted Successfully...";
      }
}
