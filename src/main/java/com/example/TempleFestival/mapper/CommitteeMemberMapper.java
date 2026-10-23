package com.example.TempleFestival.mapper;

import com.example.TempleFestival.model.*;

import org.springframework.stereotype.Component;

import com.example.TempleFestival.DTO.request.CommitteeMemberRequestDTO;
import com.example.TempleFestival.DTO.response.CommitteeMemberResponseDTO;;


@Component
public class CommitteeMemberMapper {
    
    public CommitteeMember toEntity(Member member,Festival festival,Role role,CommitteeMemberRequestDTO request){

        CommitteeMember committeeMember = new CommitteeMember();

        committeeMember.setMember(member);
        committeeMember.setFestival(festival);
        committeeMember.setRole(role);

        return committeeMember;

    }

     public CommitteeMemberResponseDTO toResponse(CommitteeMember committeeMember){
       
     CommitteeMemberResponseDTO response  = new CommitteeMemberResponseDTO();

     response.setCommitteeMemberId(committeeMember.getCommitteeMemberId());
     response.setFestivalName(committeeMember.getFestival().getFestivalName());
     response.setFestivalYear(committeeMember.getFestival().getFestivalYear());
     response.setMemberName(committeeMember.getMember().getMemberName());
     response.setPhone(committeeMember.getMember().getPhone());
     response.setRoleName(committeeMember.getRole().getRoleName());

     return response;

     }

     public CommitteeMember toEntityUpdate(CommitteeMember existingCommitteeMember,Festival festival,Member member,Role role,CommitteeMemberRequestDTO request){

        existingCommitteeMember.setFestival(festival);
        existingCommitteeMember.setMember(member);
        existingCommitteeMember.setRole(role);

        return existingCommitteeMember;
        
     }

}
