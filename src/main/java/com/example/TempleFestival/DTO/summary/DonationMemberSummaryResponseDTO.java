package com.example.TempleFestival.DTO.summary;
import com.example.TempleFestival.DTO.response.DonationResponseDTO;
import java.util.List;

public class DonationMemberSummaryResponseDTO {
    
    private String memberName;
    private String phone;
    private List<DonationResponseDTO> donation;
    
    public String getMemberName() {
        return memberName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
   
    public List<DonationResponseDTO> getDonation() {
        return donation;
    }
    public void setDonation(List<DonationResponseDTO> donation) {
        this.donation = donation;
    }

    
}
