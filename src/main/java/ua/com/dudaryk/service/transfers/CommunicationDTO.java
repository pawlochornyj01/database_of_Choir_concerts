package ua.com.dudaryk.transfers;

import ua.com.dudaryk.model.Concert;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommunicationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public void setCommunicationId(long communicationId) {
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

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}
