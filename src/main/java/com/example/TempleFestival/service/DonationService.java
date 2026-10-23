package com.example.TempleFestival.service;

import com.example.TempleFestival.mapper.DonationMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.TempleFestival.model.*;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.repository.DonationRepository;
import com.example.TempleFestival.repository.MemberRepository;
import com.example.TempleFestival.repository.FestivalRepository;
import com.example.TempleFestival.repository.ItemRepository;
import com.example.TempleFestival.DTO.request.DonationRequestDTO;
import com.example.TempleFestival.DTO.response.DonationResponseDTO;
import com.example.TempleFestival.DTO.summary.DonationFestivalSummaryResponseDTO;
import com.example.TempleFestival.DTO.summary.DonationMemberSummaryResponseDTO;
import com.example.TempleFestival.DTO.summary.DonationTotalItemSummaryResponseDTO;
import com.example.TempleFestival.DTO.response.DonationItemTotalResponseDTO;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class DonationService {

      @Autowired
      private ItemRepository itemRepository;

      @Autowired
      private FestivalRepository festivalRepository;

      @Autowired
      private MemberRepository memberRepository;
    
      @Autowired
      private DonationRepository donationRepository;

      @Autowired
      private DonationMapper donationMapper;
     
      public String donationInsert(DonationRequestDTO request){

        Member member = memberRepository.findById(request.getMemberId()). 
           orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + request.getMemberId()));

        Festival festival = festivalRepository.findById(request.getFestivalId()). 
           orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + request.getFestivalId()));

        Item item = itemRepository.findById(request.getItemId()). 
           orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + request.getItemId() )); 

        Donation donation = donationMapper.toEntity(request,member,festival,item);

        donationRepository.save(donation);

        return "Donation Added successfully...";
      }

      public List<DonationFestivalSummaryResponseDTO> donationGet(){

        List<Donation> donations = donationRepository.findAll();

        Map<Integer,List<Donation>> festivalGroup= new LinkedHashMap<>();

        for(Donation donation : donations){

           int festivalId = donation.getFestival().getFestivalId();


          if(!festivalGroup.containsKey(festivalId)){

             festivalGroup.put(festivalId,new ArrayList<>());
          }

           festivalGroup.get(festivalId).add(donation);

        }

        List<DonationFestivalSummaryResponseDTO> response = new ArrayList<>();


           for(List<Donation> festivalDonation : festivalGroup.values()){

            Festival festival = festivalDonation.get(0).getFestival();

            Map<Integer,List<Donation>> memberGroup = new LinkedHashMap<>();

            for(Donation donation : festivalDonation){

               int memberId = donation.getMember().getMemberId();

               if(!memberGroup.containsKey(memberId)){

                  memberGroup.put(memberId,new ArrayList<>());

               }

               memberGroup.get(memberId).add(donation);

            }
            List<DonationMemberSummaryResponseDTO> memberResponse = new ArrayList<>();

            for(List<Donation> memberDonations : memberGroup.values()){

               Member member = memberDonations.get(0).getMember();

               List<DonationResponseDTO> donationList = new ArrayList<>();

               for(Donation donation : memberDonations){

                  DonationResponseDTO donationDto = donationMapper.toResponse(donation);

                  donationList.add(donationDto);
               }

               DonationMemberSummaryResponseDTO memberSummary = new DonationMemberSummaryResponseDTO();

               memberSummary.setMemberName(member.getMemberName());
               memberSummary.setPhone(member.getPhone());
               memberSummary.setDonation(donationList);

               memberResponse.add(memberSummary);
            }
             
             DonationFestivalSummaryResponseDTO festivalSummary = new DonationFestivalSummaryResponseDTO();

             festivalSummary.setFestivalName(festival.getFestivalName());
             festivalSummary.setYear(festival.getFestivalYear());
             festivalSummary.setMembers(memberResponse);

             response.add(festivalSummary);

           }

           return response;
      
       }
        
      public DonationFestivalSummaryResponseDTO donationGetId(int memberId,int festivalId){

          Member member = memberRepository.findById(memberId).
          orElseThrow(() -> new ResourceNotFoundException("Member not found with id: "+memberId));

          Festival festival = festivalRepository.findById(festivalId). 
           orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + festivalId));

           List<Donation> donations = donationRepository.findByMemberMemberIdAndFestivalFestivalId(memberId,festivalId);

 
           List<DonationResponseDTO> donationList = new ArrayList<>();

           for(Donation donation : donations){

           DonationResponseDTO donationDto = donationMapper.toResponse(donation);

           donationList.add(donationDto);

           }

           DonationMemberSummaryResponseDTO memberSummary = new DonationMemberSummaryResponseDTO();

           memberSummary.setMemberName(member.getMemberName());
           memberSummary.setPhone(member.getPhone());
           memberSummary.setDonation(donationList);

           List<DonationMemberSummaryResponseDTO> memberList = new ArrayList<>();

           memberList.add(memberSummary);

           DonationFestivalSummaryResponseDTO festivalSummary = new DonationFestivalSummaryResponseDTO();

           festivalSummary.setFestivalName(festival.getFestivalName());
           festivalSummary.setYear(festival.getFestivalYear());
           festivalSummary.setMembers(memberList);

          return festivalSummary;

      }

      public DonationTotalItemSummaryResponseDTO donationListGetFestivalId(int festivalId){

         Festival festival = festivalRepository.findById(festivalId). 
           orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + festivalId));

           List<Donation> donations = donationRepository.findByFestivalFestivalId(festivalId);

           Map<String , DonationItemTotalResponseDTO> itemMap = new LinkedHashMap<>();

           for(Donation donation : donations){

            String itemName = donation.getItem().getItemName();

            String unit  = donation.getItem().getUnit().getUnitName();

            double value = donation.getValue();

            if(itemMap.containsKey(itemName)){

               DonationItemTotalResponseDTO existing = itemMap.get(itemName);

               existing.setTotal(existing.getTotal() + value);


            }
            else{

               DonationItemTotalResponseDTO newItem = new DonationItemTotalResponseDTO();

               newItem.setItemName(itemName);
               newItem.setTotal(value);
               newItem.setUnit(unit);

               itemMap.put(itemName,newItem);

            }

           }
       
           List<DonationItemTotalResponseDTO> donationList = new  ArrayList<>(itemMap.values());

           DonationTotalItemSummaryResponseDTO response = new DonationTotalItemSummaryResponseDTO();

           response.setFestivalName(festival.getFestivalName());
           response.setYear(festival.getFestivalYear());
           response.setDonations(donationList);

           return response;

      }
      

      public String donationUpdate(int id,DonationRequestDTO request){

         Donation existingDonation = donationRepository.findById(id). 
           orElseThrow(() -> new ResourceNotFoundException("Donation not found with id: " + id ));

        Member member = memberRepository.findById(request.getMemberId()). 
           orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + request.getMemberId() ));

          Item item = itemRepository.findById(request.getItemId()). 
           orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + request.getItemId() ));

        Festival festival = festivalRepository.findById(request.getFestivalId()). 
           orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + request.getFestivalId()));

       Donation donation = donationMapper.toEntityUpdate(existingDonation,member,item,festival,request);

        donationRepository.save(donation);

        return "Donation Updated Successfully...";
      }

      public String donationDeleteId(int id){

        Donation existingDonation = donationRepository.findById(id). 
           orElseThrow(() -> new ResourceNotFoundException("Donation not found with id: " + id));

        donationRepository.deleteById(existingDonation.getDonationId());

        return "Donation Id : "+ id+" Deleted Successfully...";
      }


}
