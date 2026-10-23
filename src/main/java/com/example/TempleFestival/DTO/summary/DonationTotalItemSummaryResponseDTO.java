package com.example.TempleFestival.DTO.summary;
import java.util.List;
import com.example.TempleFestival.DTO.response.DonationItemTotalResponseDTO;

public class DonationTotalItemSummaryResponseDTO {
    
        private String festivalName;
        private int year;
        private List<DonationItemTotalResponseDTO> donations;

        public String getFestivalName() {
            return festivalName;
        }
        public void setFestivalName(String festivalName) {
            this.festivalName = festivalName;
        }
        public int getYear() {
            return year;
        }
        public void setYear(int year) {
            this.year = year;
        }
        public List<DonationItemTotalResponseDTO> getDonations() {
            return donations;
        }
        public void setDonations(List<DonationItemTotalResponseDTO> donations) {
            this.donations = donations;
        }

        
}
