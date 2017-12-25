package ua.com.dudaryk.service.transfers;

import ua.com.dudaryk.model.Communication;
import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.Participant;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConcertDTO implements Serializable {


    private long concertId;

    private LocalDateTime date;

    private String name;

    private String genre;

    private String poster;

    private List<Participant> participants;

    private List<Communication> communications = new ArrayList<>();

    private List<Dudaryk> dudaryks;

    public long getConcertId() {
        return concertId;
    }

    public void setConcertId(long concertId) {
        this.concertId = concertId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Communication> getCommunications() {
        return communications;
    }

    public void setCommunications(List<Communication> communications) {
        this.communications = communications;
    }

    public List<Dudaryk> getDudaryks() {
        return dudaryks;
    }

    public void setDudaryks(List<Dudaryk> dudaryks) {
        this.dudaryks = dudaryks;
    }
}
