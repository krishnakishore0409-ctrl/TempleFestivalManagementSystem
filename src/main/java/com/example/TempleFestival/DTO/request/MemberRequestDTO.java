package com.example.TempleFestival.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class MemberRequestDTO {
    
   
    @Positive (message = "Member number must be greater than zero")
    private int memberNo;

    @NotBlank (message = "Member name is required")
    private String memberName;

    @NotBlank (message = "Member Address is required")
    @Size(max = 200,message = "Address must not exceed 200 characters")
    private String address;

    @NotBlank (message = "Phone number is required")
    @Pattern (
             regexp = "^[0-9]{10}$",
             message = "Phone number must contain exactly 10 digits"
    )
    private String phone;
    
    public int getMemberNo(){
        return memberNo;
    }
    
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    

}
