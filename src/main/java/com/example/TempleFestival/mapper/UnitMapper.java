package com.example.TempleFestival.mapper;

import com.example.TempleFestival.DTO.request.UnitRequestDTO;
import com.example.TempleFestival.DTO.response.UnitResponseDTO;
import com.example.TempleFestival.model.*;
import org.springframework.stereotype.Component;

@Component
public class UnitMapper {
    
    public Unit toEntity(UnitRequestDTO request){

        Unit unit = new Unit();

        unit.setUnitName(request.getUnitName());

        return unit;

    }

    public UnitResponseDTO toResponse(Unit unit){

        UnitResponseDTO response = new UnitResponseDTO();

        response.setUnitId(unit.getUnitId());
        response.setUnitName(unit.getUnitName());

        return response;

    }

    public Unit toEntityUpdate(Unit existingUnit, UnitRequestDTO request){

       existingUnit.setUnitName(request.getUnitName());

       return existingUnit;
       
    }
}
