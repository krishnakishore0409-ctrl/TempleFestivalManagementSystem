package com.example.TempleFestival.DTO.request;

import jakarta.validation.constraints.NotBlank;

public class UnitRequestDTO {
    
    @NotBlank (message = "Unit name is required")
    private String unitName;
    
    
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
}
