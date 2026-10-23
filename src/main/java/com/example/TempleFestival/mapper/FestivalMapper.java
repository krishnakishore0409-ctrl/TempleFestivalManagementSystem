package com.example.TempleFestival.mapper;

import com.example.TempleFestival.DTO.request.FestivalRequestDTO;
import com.example.TempleFestival.DTO.response.FestivalResponseDTO;
import com.example.TempleFestival.model.Festival;
import org.springframework.stereotype.Component;

@Component
public class FestivalMapper {
    
    public Festival toEntity(FestivalRequestDTO  request){
   
          Festival festival = new Festival();

          festival.setFestivalName(request.getFestivalName());
          festival.setFestivalYear(request.getFestivalYear());
          festival.setFestivalStart_Date(request.getFestivalEnd_Date());
          festival.setFestivalEnd_Date(request.getFestivalEnd_Date());

         return festival;
    }

    public FestivalResponseDTO toResponse(Festival festival){

        FestivalResponseDTO response = new FestivalResponseDTO();

        response.setFestivalId(festival.getFestivalId());
        response.setFestivalName(festival.getFestivalName());
        response.setFestivalYear(festival.getFestivalYear());
        response.setFestivalStart_Date(festival.getFestivalStart_Date());
        response.setFestivalEnd_Date(festival.getFestivalEnd_Date());

        return response;
    }

    
    // public FestivalResponseDTO toResponseGetId(Festival festival){

    //     FestivalResponseDTO response = new FestivalResponseDTO();

    //     response.setFestivalId(festival.getFestivalId());
    //     response.setFestivalName(festival.getFestivalName());
    //     response.setFestivalYear(festival.getFestivalYear());
    //     response.setFestivalStart_Date(festival.getFestivalStart_Date());
    //     response.setFestivalEnd_Date(festival.getFestivalEnd_Date());

    //     return response;
    // }

       public Festival toEntityUpdate(Festival existingFestival, FestivalRequestDTO request){

         existingFestival.setFestivalName(request.getFestivalName());
         existingFestival.setFestivalStart_Date(request.getFestivalStart_Date());
         existingFestival.setFestivalEnd_Date(request.getFestivalEnd_Date());
         existingFestival.setFestivalYear(request.getFestivalYear());

         return existingFestival;
       }
}
