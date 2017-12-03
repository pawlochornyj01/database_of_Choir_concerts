package ua.com.dudaryk.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dudaryk")
class Dudaryk {

    @Id
    @GeneratedValue
    @Column(name = "DUDARYK_ID")
    private int dudarykId;

    @ManyToMany(mappedBy = "dudaryks")
    private List<Concert> concerts;

    @OneToMany(mappedBy = "dudaryk", cascade = CascadeType.ALL)
    private List<UserHistory> userHistories = new ArrayList<>();

    @OneToMany(mappedBy = "dudaryk", cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();

    @Column(name = "NAME")
    private String name;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE_OF_BIRTHDAY")
    private LocalDateTime dateOfBirthday;

    @Column(name = "VOICE")
    private Voice voice;

    @Column(name = "IS_ACTION")
    private boolean isAction;

    @Column(name = "PHOTO")
    private String photo;

    public List<UserHistory> getUserHistories() {
        return userHistories;
    }

    public void setUserHistories(List<UserHistory> userHistories) {
        this.userHistories = userHistories;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getDudarykId() {
        return dudarykId;
    }

    public void setDudarykId(int dudarykId) {
        this.dudarykId = dudarykId;
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

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = Voice.valueOf(voice);
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

    @Override
    public String toString() {
        return "Dudaryk{" +
                "dudarykId=" + dudarykId +
                ", userHistories=" + userHistories +
                ", categories=" + categories +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", voice=" + voice +
                ", isAction=" + isAction +
                ", photo='" + photo + '\'' +
                '}';
    }
}
