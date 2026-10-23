package  com.example.TempleFestival.DTO.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CommitteeMemberRequestDTO {
    
    @NotNull(message = "Member ID is required")
    @Positive(message = "Member Id must be greater than zero")
    private int memberId;

    @NotNull (message = "Festival ID is required")
    @Positive(message = "Festival Id must be greater than zero")
    private int festivalId;

    @NotNull(message = "Role ID is required")
    @Positive(message ="Role Id must be greater than zero") 
    private int roleId;

    
     public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public int getFestivalId() {
        return festivalId;
    }
    public void setFestivalId(int festivalId) {
        this.festivalId = festivalId;
    }
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    

    
}
