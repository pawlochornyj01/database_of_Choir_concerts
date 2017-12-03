package ua.com.dudaryk.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "communication")
class Communication {

    @Id
    @GeneratedValue
    @Column(name = "COMMUNICATION_ID")
    private int communicationId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE_OF_MEMBERSHIP")
    private LocalDateTime membershipDate;

    @ManyToOne
    @JoinColumn(name = "CONCERT_ID")
    private Concert concert;

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public int getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(int communicationId) {
        this.communicationId = communicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDateTime membershipDate) {
        this.membershipDate = membershipDate;
    }

    @Override
    public String toString() {
        return "Communication{" +
                "communicationId=" + communicationId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", comment='" + comment + '\'' +
                ", description='" + description + '\'' +
                ", membershipDate=" + membershipDate +
                '}';
    }
}
