package com.example.TempleFestival.mapper;

import com.example.TempleFestival.DTO.request.MemberRequestDTO;
import com.example.TempleFestival.DTO.response.MemberResponseDTO;
import com.example.TempleFestival.model.Member;

import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    
    public Member toEntity(MemberRequestDTO request){

        Member member = new Member();

        member.setMemberName(request.getMemberName());
        member.setAddress(request.getAddress());
        member.setMemberNo(request.getMemberNo());
        member.setPhone(request.getPhone());

        return member;

    }


    public MemberResponseDTO toResponse(Member member){

        MemberResponseDTO response = new MemberResponseDTO();

        response.setMemberId(member.getMemberId());
        response.setMemberName(member.getMemberName());
        response.setAddress(member.getAddress());
        response.setMemberNo(member.getMemberNo());
        response.setPhone(member.getPhone());

        return response;

    }

    public Member toEntityUpdate(Member existingMember, MemberRequestDTO request){

        existingMember.setMemberName(request.getMemberName());
        existingMember.setAddress(request.getAddress());
        existingMember.setMemberNo(request.getMemberNo());
        existingMember.setPhone(request.getPhone());

        return existingMember;
    }
    
}