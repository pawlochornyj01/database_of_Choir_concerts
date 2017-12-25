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

    public ConcertDTO setConcertId(long concertId) {
        this.concertId = concertId;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public ConcertDTO setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public String getName() {
        return name;
    }

    public ConcertDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public ConcertDTO setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getPoster() {
        return poster;
    }

    public ConcertDTO setPoster(String poster) {
        this.poster = poster;
        return this;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public ConcertDTO setParticipants(List<Participant> participants) {
        this.participants = participants;
        return this;
    }

    public List<Communication> getCommunications() {
        return communications;
    }

    public ConcertDTO setCommunications(List<Communication> communications) {
        this.communications = communications;
        return this;
    }

    public List<Dudaryk> getDudaryks() {
        return dudaryks;
    }

    public ConcertDTO setDudaryks(List<Dudaryk> dudaryks) {
        this.dudaryks = dudaryks;
        return this;
    }
}
