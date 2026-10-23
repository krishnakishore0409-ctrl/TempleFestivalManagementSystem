package com.example.TempleFestival.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TempleFestival.DTO.request.UnitRequestDTO;
import com.example.TempleFestival.DTO.response.UnitResponseDTO;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.mapper.UnitMapper;
import com.example.TempleFestival.repository.UnitRepository;
import com.example.TempleFestival.model.Unit;


@Service 
public class UnitService {
    


     @Autowired
      private UnitRepository unitRepository;

      @Autowired
      private UnitMapper unitMapper;

      public String unitInsert(UnitRequestDTO request){

        Unit unit = unitMapper.toEntity(request);

        unitRepository.save(unit);

        return "Unit Added Successfully...";

      }

      public List<UnitResponseDTO> unitGet(){

        List<Unit> unit = unitRepository.findAll();

        List<UnitResponseDTO> response = new ArrayList<>();

        for(Unit u : unit){

          UnitResponseDTO dto = unitMapper.toResponse(u);

          response.add(dto);

        }

        return response;
      }

      public UnitResponseDTO unitGetId(int id){

        Unit unit =  unitRepository.findById(id). 
        orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + id));

        UnitResponseDTO response = unitMapper.toResponse(unit);

        return response;
      }

      public String unitUpdate(int id,UnitRequestDTO request){

         Unit existingUnit =  unitRepository.findById(id). 
        orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + id ));

        Unit unit = unitMapper.toEntityUpdate(existingUnit,request);

         unitRepository.save(unit);

         return "Unit Update Successfully...";

      }

       public String unitDeleteId(int id){

        Unit existingUnit =  unitRepository.findById(id). 
        orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + id ));

        unitRepository.deleteById(existingUnit.getUnitId());

        return "Unit Id :"+id+" Delete Successfully...";

       }
}
