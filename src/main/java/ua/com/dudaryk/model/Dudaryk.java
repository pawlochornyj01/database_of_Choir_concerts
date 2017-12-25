package ua.com.dudaryk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dudaryk")
public class Dudaryk implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "DUDARYK_ID")
    private long dudarykId;

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

    @Column(name = "Voice")
    @Enumerated(EnumType.STRING)
    private Voice Voice;

    @Column(name = "IS_ACTION")
    private boolean isAction;


    @Column(name = "PHOTO")
    private String photo;


    public List<UserHistory> getUserHistories() {
        return userHistories;
    }

    public Dudaryk setUserHistories(List<UserHistory> userHistories) {
        this.userHistories = userHistories;
        return this;
    }

    public Dudaryk setVoice(Voice voice) {
        this.Voice = voice;
        return this;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public Dudaryk setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Dudaryk setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public long getDudarykId() {
        return dudarykId;
    }

    public Dudaryk setDudarykId(long dudarykId) {
        this.dudarykId = dudarykId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dudaryk setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Dudaryk setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Dudaryk setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Dudaryk setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Dudaryk setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getDateOfBirthday() {
        return dateOfBirthday;
    }

    public Dudaryk setDateOfBirthday(LocalDateTime dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
        return this;
    }

    public Voice getVoice() {
        return Voice;
    }


    public boolean isAction() {
        return isAction;
    }

    public Dudaryk setAction(boolean action) {
        isAction = action;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Dudaryk setPhoto(String photo) {
        this.photo = photo;
        return this;
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
                ", Voice=" + Voice +
                ", isAction=" + isAction +
                ", photo='" + photo + '\'' +
                '}';
    }
}
