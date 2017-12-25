package ua.com.dudaryk.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "participant")
public class Participant implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "PARTICIPANT_ID")
    private long participantId;

    @ManyToMany(mappedBy = "participants")
    private List<Concert> concerts = new ArrayList<>();

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

    public List<Concert> getConcerts() {
        return concerts;
    }

    public Participant setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
        return this;
    }

    public long getParticipantId() {
        return participantId;
    }

    public Participant setParticipantId(long participantId) {
        this.participantId = participantId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Participant setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Participant setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Participant setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Participant setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Participant setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "participantId=" + participantId +
                ", concerts=" + concerts +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", comment='" + comment + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
