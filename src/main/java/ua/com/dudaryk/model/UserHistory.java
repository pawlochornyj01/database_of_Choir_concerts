package ua.com.dudaryk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_history")
public class UserHistory implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "USER_HISTORY-ID")
    private long userHistoryId;

    @ManyToOne
    @JoinColumn(name = "DUDARYK_ID")
    private Dudaryk dudaryk;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "DESCRIPTION")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "WorkingStatus")
    private WorkingStatus action;

    public Dudaryk getDudaryk() {
        return dudaryk;
    }

    public void setDudaryk(Dudaryk dudaryk) {
        this.dudaryk = dudaryk;
    }


    public long getUserHistoryId() {
        return userHistoryId;
    }

    public void setUserHistoryId(long userHistoryId) {
        this.userHistoryId = userHistoryId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public WorkingStatus getAction() {
        return action;
    }

    public void setAction(WorkingStatus action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "userHistoryId=" + userHistoryId +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", description='" + description + '\'' +
                ", action=" + action +
                '}';
    }
}
