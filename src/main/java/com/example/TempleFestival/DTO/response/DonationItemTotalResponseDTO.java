package com.example.TempleFestival.DTO.response;

public class DonationItemTotalResponseDTO {
    
    private String itemName;
    private double total;
    private String unit;

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    
}
