package com.example.TempleFestival.DTO.response;

public class CommitteeMemberResponseDTO {

 private int committeeMemberId;
    private String memberName;
     private String phone;
    private String  festivalName;
    private int year;
    private String  roleName;
    
    public int getCommitteeMemberId() {
        return committeeMemberId;
    }
    public void setCommitteeMemberId(int committeeMemberId) {
        this.committeeMemberId = committeeMemberId;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFestivalName() {
        return festivalName;
    }
    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }
    public int getFestivalYear() {
        return year;
    }
    public void setFestivalYear(int year) {
        this.year = year;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    

}
