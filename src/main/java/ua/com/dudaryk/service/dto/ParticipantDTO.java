package ua.com.dudaryk.service.dto;

import ua.com.dudaryk.model.Concert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDTO implements Serializable {

    private long participantId;

    private List<Concert> concerts = new ArrayList<>();

    private String name;

    private String email;

    private String phone;

    private String comment;

    private String description;

    public long getParticipantId() {
        return participantId;
    }

    public ParticipantDTO setParticipantId(long participantId) {
        this.participantId = participantId;
        return this;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public ParticipantDTO setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParticipantDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ParticipantDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ParticipantDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ParticipantDTO setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ParticipantDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
