package ua.com.dudaryk.service.transfers;

import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.model.Concert;
import ua.com.dudaryk.model.UserHistory;
import ua.com.dudaryk.model.Voice;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DudarykDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long dudarykId;

    private List<Concert> concerts;

    private List<UserHistory> userHistories = new ArrayList<>();

    private List<Category> categories = new ArrayList<>();

    private String name;

    private String lastName;

    private String email;

    private String phone;

    private String description;

    private LocalDateTime dateOfBirthday;

    private Voice Voice;

    private boolean isAction;

    private String photo;


    public long getDudarykId() {
        return dudarykId;
    }

    public void setDudarykId(long dudarykId) {
        this.dudarykId = dudarykId;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

    public List<UserHistory> getUserHistories() {
        return userHistories;
    }

    public void setUserHistories(List<UserHistory> userHistories) {
        this.userHistories = userHistories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDateTime dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public ua.com.dudaryk.model.Voice getVoice() {
        return Voice;
    }

    public void setVoice(ua.com.dudaryk.model.Voice voice) {
        Voice = voice;
    }

    public boolean isAction() {
        return isAction;
    }

    public void setAction(boolean action) {
        isAction = action;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
