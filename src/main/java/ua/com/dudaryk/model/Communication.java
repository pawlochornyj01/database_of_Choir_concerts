package ua.com.dudaryk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "communication")
public class Communication implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "COMMUNICATION_ID")
    private long communicationId;

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

    public Communication setConcert(Concert concert) {
        this.concert = concert;
        return this;
    }

    public long getCommunicationId() {
        return communicationId;
    }

    public Communication setCommunicationId(long communicationId) {
        this.communicationId = communicationId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Communication setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Communication setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Communication setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Communication setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Communication setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getMembershipDate() {
        return membershipDate;
    }

    public Communication setMembershipDate(LocalDateTime membershipDate) {
        this.membershipDate = membershipDate;
        return this;
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
