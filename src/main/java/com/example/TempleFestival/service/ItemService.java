package com.example.TempleFestival.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TempleFestival.repository.UnitRepository;
import com.example.TempleFestival.DTO.request.ItemRequestDTO;
import com.example.TempleFestival.DTO.response.ItemResponseDTO;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.mapper.ItemMapper;
import com.example.TempleFestival.model.DonationType;
import com.example.TempleFestival.model.Unit;
import com.example.TempleFestival.model.Item;
import com.example.TempleFestival.repository.DonationTypeRepository;
import com.example.TempleFestival.repository.ItemRepository;


@Service 
public class ItemService {

      @Autowired 
      private DonationTypeRepository donationTypeRepository;
      
      @Autowired 
      private UnitRepository unitRepository;

      @Autowired 
      private ItemRepository itemRepository;

      @Autowired
      private ItemMapper itemMapper;

      public String itemInsert(ItemRequestDTO request){

        Unit unit = unitRepository.findById(request.getUnitId()).
         orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + request.getUnitId() ));

          DonationType donationType = donationTypeRepository.findById(request.getDonationTypeId()).
         orElseThrow(() -> new ResourceNotFoundException("DonationType not found with id: " + request.getDonationTypeId() ));

         Item item = itemMapper.toEntity(donationType,unit,request);

        itemRepository.save(item);

        return "Item added Successully...";

      }

      public List<ItemResponseDTO> itemGet(){
         List<Item> item =  itemRepository.findAll();

         List<ItemResponseDTO> response = new ArrayList<>();

         for(Item i : item){
         
         ItemResponseDTO dto = itemMapper.toResponse(i);

         response.add(dto);
          
         }
  
         return response;
      }

      public ItemResponseDTO itemGetId(int id){

        Item item = itemRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id ));

           ItemResponseDTO response = itemMapper.toResponse(item);

         return response;
      }

      public String itemUpdate(int id,ItemRequestDTO request){

        Item existingItem = itemRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id ));

         Unit unit = unitRepository.findById(request.getUnitId()).
         orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + request.getUnitId() ));

         DonationType donationType = donationTypeRepository.findById(request.getDonationTypeId()).
         orElseThrow(() -> new ResourceNotFoundException("DonationType not found with id: " + request.getDonationTypeId() ));

         Item item = itemMapper.toEntityUpdate(existingItem,unit,donationType,request);

        itemRepository.save(item);

        return "Item Update Successfully...";

      }

      public String itemDeleteId(int id){

        Item existingItem = itemRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));

        itemRepository.deleteById(existingItem.getItemId());

        return "Item Id :"+id+" Deleted Successfully...";

      }
}
