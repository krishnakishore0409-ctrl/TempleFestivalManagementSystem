package com.example.TempleFestival.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TempleFestival.DTO.summary.FestivalFinancialSummaryResponseDTO;
import com.example.TempleFestival.service.FestivalFinancialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping ("/festival-financial")
public class FestivalFinancialController {
    

    private final FestivalFinancialService festivalFinancialService;

     public FestivalFinancialController(FestivalFinancialService festivalFinancialService){
        this.festivalFinancialService = festivalFinancialService;
     }


    @GetMapping("/{festivalId}")
    public FestivalFinancialSummaryResponseDTO getSummary(@PathVariable int festivalId){
        return festivalFinancialService.getFestivalFinancialSummary(festivalId);
    }
    
}
