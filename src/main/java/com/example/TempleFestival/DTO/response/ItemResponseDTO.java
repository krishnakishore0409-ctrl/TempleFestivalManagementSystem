package com.example.TempleFestival.DTO.response;

public class ItemResponseDTO {
    
    private int itemId;
    private String itemName;
    private String unitName;
    private String donationTypeName;
    
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    public String getDonationTypeName() {
        return donationTypeName;
    }
    public void setDonationTypeName(String donationTypeName) {
        this.donationTypeName = donationTypeName;
    }

    
}
