package com.example.TempleFestival.mapper;

import com.example.TempleFestival.DTO.request.ItemRequestDTO;
import com.example.TempleFestival.DTO.response.ItemResponseDTO;
import com.example.TempleFestival.model.*;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
 
    public Item toEntity(DonationType donationType,Unit unit, ItemRequestDTO request){

      Item item = new Item();

      item.setItemName(request.getItemName());
      item.setUnit(unit);
      item.setDonationType(donationType);

      return item;
    }

    public ItemResponseDTO toResponse(Item item){

        ItemResponseDTO response = new ItemResponseDTO();

        response.setItemId(item.getItemId());
        response.setItemName(item.getItemName());
        response.setUnitName(item.getUnit().getUnitName());
        response.setDonationTypeName(item.getDonationType().getDonationTypeName());

        return response;
    }

public Item toEntityUpdate(Item existingItem,Unit unit,DonationType donationType,ItemRequestDTO request){

    existingItem.setItemName(request.getItemName());
    existingItem.setUnit(unit);
    existingItem.setDonationType(donationType);

    return existingItem;

}

}
