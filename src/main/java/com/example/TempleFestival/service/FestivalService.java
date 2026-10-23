package com.example.TempleFestival.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TempleFestival.DTO.request.FestivalRequestDTO;
import com.example.TempleFestival.DTO.response.FestivalResponseDTO;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.mapper.FestivalMapper;
import com.example.TempleFestival.model.Festival;
import com.example.TempleFestival.repository.FestivalRepository;

@Service 
public class FestivalService {

    @Autowired
      private FestivalRepository festivalRepository;

      @Autowired
      private FestivalMapper festivalMapper;

      public String festivalInsert(FestivalRequestDTO request){

         Festival festival = festivalMapper.toEntity(request);

        festivalRepository.save(festival);

        return "Festival Added Successfully...";
      }

      public List<FestivalResponseDTO> festivalGet(){
           
         List<Festival> festival = festivalRepository.findAll();

          List<FestivalResponseDTO> response = new ArrayList<>();

          for(Festival f : festival){

            FestivalResponseDTO dto = festivalMapper.toResponse(f);

            response.add(dto);
          }

          return response;
      }

        public FestivalResponseDTO festivalGetId(int id){

         Festival festival =  festivalRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + id ));
         FestivalResponseDTO response = festivalMapper.toResponse(festival);

         return response;
      }

      public String festivalUpdate(int id,FestivalRequestDTO request){

        Festival existingFestival =  festivalRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + id ));

       Festival festival = festivalMapper.toEntityUpdate(existingFestival,request);

        festivalRepository.save(festival);

        return "Festival Update Successfully...";

      }

      public String festivalDeleteId(int id){

        Festival existingFestival = festivalRepository.findById(id). 
           orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + id));

        festivalRepository.deleteById(existingFestival.getFestivalId());

        return "Festival Id : "+id+" Deleted Successfully...";
        
      }

}
