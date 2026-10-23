package com.example.TempleFestival.mapper;

import com.example.TempleFestival.DTO.request.DonationRequestDTO;
import com.example.TempleFestival.DTO.response.DonationResponseDTO;
import com.example.TempleFestival.model.*;
import org.springframework.stereotype.Component;

@Component
public class DonationMapper {
    
    public Donation toEntity(DonationRequestDTO request, Member member, Festival festival, Item item){

        Donation donation = new Donation();

        donation.setDonationDate(request.getDonationDate());
        donation.setValue(request.getValue());
        donation.setFestival(festival);
        donation.setMember(member);
        donation.setItem(item);

        return donation;

    }

    public DonationResponseDTO toResponse(Donation donation){

        DonationResponseDTO response = new DonationResponseDTO();

        response.setDonationId(donation.getDonationId());
        response.setDonationDate(donation.getDonationDate());
        response.setValue(donation.getValue());
        response.setItemName(donation.getItem().getItemName());

        return response;
    }

    // public DonationResponseDTO toResponseGetId(Donation donation){

    //     DonationResponseDTO response = new DonationResponseDTO();

    //     response.setDonationId(donation.getDonationId());
    //     response.setDonationDate(donation.getDonationDate());
    //     response.setValue(donation.getValue());
    //     response.setFestivalName(donation.getFestival().getFestivalName());
    //     response.setFestivalYear(donation.getFestival().getFestivalYear());
    //     response.setItemName(donation.getItem().getItemName());
    //     response.setMemberName(donation.getMember().getMemberName());
    //     response.setMemberPhone(donation.getMember().getPhone());

    //     return response;

    // }

    public Donation toEntityUpdate(Donation existingDonation,Member member,Item item,Festival festival,DonationRequestDTO request){

        existingDonation.setDonationDate(request.getDonationDate());
        existingDonation.setValue(request.getValue());
        existingDonation.setMember(member);
        existingDonation.setFestival(festival);
        existingDonation.setItem(item);

        return existingDonation;
    }
}
