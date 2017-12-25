package ua.com.dudaryk.service.transfers;

import ua.com.dudaryk.model.Concert;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommunicationDTO implements Serializable {

    private long communicationId;

    private String name;

    private String email;

    private String phone;

    private String comment;

    private String description;

    private LocalDateTime membershipDate;

    private Concert concert;

    public long getCommunicationId() {
        return communicationId;
    }

    public CommunicationDTO setCommunicationId(long communicationId) {
        this.communicationId = communicationId;
        return this;
    }

    public String getName() {
        return name;
    }

    public CommunicationDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CommunicationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CommunicationDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public CommunicationDTO setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CommunicationDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getMembershipDate() {
        return membershipDate;
    }

    public CommunicationDTO setMembershipDate(LocalDateTime membershipDate) {
        this.membershipDate = membershipDate;
        return this;
    }

    public Concert getConcert() {
        return concert;
    }

    public CommunicationDTO setConcert(Concert concert) {
        this.concert = concert;
        return this;
    }
}
