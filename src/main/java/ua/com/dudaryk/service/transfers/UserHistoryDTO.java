package ua.com.dudaryk.service.transfers;

import ua.com.dudaryk.model.Dudaryk;
import ua.com.dudaryk.model.WorkingStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserHistoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long userHistoryId;

    private Dudaryk dudaryk;

    private LocalDateTime date;

    private String comment;

    private String description;

    private WorkingStatus action;

    public Dudaryk getDudaryk() {
        return dudaryk;
    }

    public void setDudaryk(Dudaryk dudaryk) {
        this.dudaryk = dudaryk;
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

    public long getUserHistoryId() {
        return userHistoryId;
    }

    public void setUserHistoryId(long userHistoryId) {
        this.userHistoryId = userHistoryId;
    }
}
