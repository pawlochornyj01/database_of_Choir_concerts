package ua.com.dudaryk.service.transfers;

import ua.com.dudaryk.model.Dudaryk;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long categoryId;

    private String name;

    private Dudaryk dudaryk;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dudaryk getDudaryk() {
        return dudaryk;
    }

    public void setDudaryk(Dudaryk dudaryk) {
        this.dudaryk = dudaryk;
    }
}
