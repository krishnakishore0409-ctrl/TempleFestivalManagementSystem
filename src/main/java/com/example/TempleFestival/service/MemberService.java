package com.example.TempleFestival.service;


import com.example.TempleFestival.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import  com.example.TempleFestival.model.Member;
import com.example.TempleFestival.exception.DuplicateResourceException;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.repository.MemberRepository;
import com.example.TempleFestival.DTO.request.MemberRequestDTO;
import com.example.TempleFestival.DTO.response.MemberResponseDTO;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMapper memberMapper;

    public String memberInsert(MemberRequestDTO request){

      boolean exists = memberRepository.existsByMemberNo(request.getMemberNo());

    if(exists){

        throw new DuplicateResourceException("Member number already exists: "+request.getMemberNo());
                                                                                                 
      }

      Member member = memberMapper.toEntity(request);

      memberRepository.save(member);

        return "Member added Successfully...";
    }

    public List<MemberResponseDTO> memberGet(){

      List<Member> members = memberRepository.findAll();

      List<MemberResponseDTO> response = new ArrayList<>();

      for(Member m : members){

       MemberResponseDTO dto = memberMapper.toResponse(m);

       response.add(dto);

      }

        return response;

    }

     public MemberResponseDTO memberGetId(int id){
      
           Member member =  memberRepository.findById(id). 
           orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));



           MemberResponseDTO response = memberMapper.toResponse(member);

           return response;
     }

     public String memberUpdate(int id ,MemberRequestDTO request){

           Member existingMember = memberRepository.findById(id). 
           orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));

           boolean exists = memberRepository.existsByMemberNoAndMemberIdNot(request.getMemberNo(),id);

           if(exists){

             throw new DuplicateResourceException(
                "Member number already exists: "
                        + request.getMemberNo());
           }

            Member member = memberMapper.toEntityUpdate(existingMember,request);

            memberRepository.save(member);

            return "Member Update Successfully...";
     }

     public String memberDeleteId(int id){
      
      Member existingMember = memberRepository.findById(id). 
           orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));

        memberRepository.deleteById(existingMember.getMemberId());

        return "Memeber Id :"+id+" Deleted Successfully...";
     }
}
