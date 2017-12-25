package ua.com.dudaryk.service.transfers;

import ua.com.dudaryk.model.Dudaryk;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private long categoryId;

    private String name;

    private Dudaryk dudaryk;

    public long getCategoryId() {
        return categoryId;
    }

    public CategoryDTO setCategoryId(long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Dudaryk getDudaryk() {
        return dudaryk;
    }

    public CategoryDTO setDudaryk(Dudaryk dudaryk) {
        this.dudaryk = dudaryk;
        return this;
    }
}
