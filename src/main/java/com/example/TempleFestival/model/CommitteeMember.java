package com.example.TempleFestival.model;

 
  import jakarta.persistence.Id;
  import jakarta.persistence.Entity;
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.JoinColumn;
  import jakarta.persistence.ManyToOne;
  
  
@Entity
public class CommitteeMember{ 
           
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int committeeMemberId;
     

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    
    @ManyToOne
    @JoinColumn(name = "festival_id")
    private Festival festival;

    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    public int getCommitteeMemberId() {
      return committeeMemberId;
    }


    public void setCommitteeMemberId(int committeeMemberId) {
      this.committeeMemberId = committeeMemberId;
    }


    public Member getMember() {
      return member;
    }


    public void setMember(Member member) {
      this.member = member;
    }


    public Festival getFestival() {
      return festival;
    }


    public void setFestival(Festival festival) {
      this.festival = festival;
    }


    public Role getRole() {
      return role;
    }


    public void setRole(Role role) {
      this.role = role;
    }


    
}