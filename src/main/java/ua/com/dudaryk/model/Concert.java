package ua.com.dudaryk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "concert")
public class Concert implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "CONCERT_ID")
    private long concertId;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "POSTER")
    private String poster;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "concert_participant", joinColumns = @JoinColumn(name = "CONCERT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PARTICIPANT_ID"))
    private List<Participant> participants;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
    private List<Communication> communications = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "concert_dudaryk", joinColumns = @JoinColumn(name = "CONCERT_ID"),
            inverseJoinColumns = @JoinColumn(name = "DUDARYK_ID"))
    private List<Dudaryk> dudaryks;

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

    @Override
    public String toString() {
        return "Concert{" +
                "concertId=" + concertId +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
