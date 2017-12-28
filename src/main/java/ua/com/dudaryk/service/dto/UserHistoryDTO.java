package ua.com.dudaryk.service.dto;

import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.WorkingStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserHistoryDTO implements Serializable {

    private long userHistoryId;

    private Dudaryk dudaryk;

    private LocalDateTime date;

    private String comment;

    private String description;

    private WorkingStatus action;

    public Dudaryk getDudaryk() {
        return dudaryk;
    }

    public UserHistoryDTO setDudaryk(Dudaryk dudaryk) {
        this.dudaryk = dudaryk;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public UserHistoryDTO setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public UserHistoryDTO setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserHistoryDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public WorkingStatus getAction() {
        return action;
    }

    public UserHistoryDTO setAction(WorkingStatus action) {
        this.action = action;
        return this;
    }

    public long getUserHistoryId() {
        return userHistoryId;
    }

    public UserHistoryDTO setUserHistoryId(long userHistoryId) {
        this.userHistoryId = userHistoryId;
        return this;
    }
}
