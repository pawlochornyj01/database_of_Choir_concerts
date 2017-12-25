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

    public DudarykDTO setDudarykId(long dudarykId) {
        this.dudarykId = dudarykId;
        return this;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public DudarykDTO setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
        return this;
    }

    public List<UserHistory> getUserHistories() {
        return userHistories;
    }

    public DudarykDTO setUserHistories(List<UserHistory> userHistories) {
        this.userHistories = userHistories;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public DudarykDTO setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public String getName() {
        return name;
    }

    public DudarykDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public DudarykDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public DudarykDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public DudarykDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DudarykDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getDateOfBirthday() {
        return dateOfBirthday;
    }

    public DudarykDTO setDateOfBirthday(LocalDateTime dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
        return this;
    }

    public Voice getVoice() {
        return Voice;
    }

    public DudarykDTO setVoice(Voice voice) {
        this.Voice = voice;
        return this;
    }

    public boolean isAction() {
        return isAction;
    }

    public DudarykDTO setAction(boolean action) {
        isAction = action;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public DudarykDTO setPhoto(String photo) {
        this.photo = photo;
        return this;
    }
}
