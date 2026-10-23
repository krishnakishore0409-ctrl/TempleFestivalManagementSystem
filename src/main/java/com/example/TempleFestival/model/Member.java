package com.example.TempleFestival.model;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
 import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Member{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    private int memberNo;
    private String memberName;
    private String address;
    private String phone;


    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Donation> donation;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Payment> payment;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<CommitteeMember> committeeMembers;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getMemberNo() {
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
  
    public Member(){
       
    }

}