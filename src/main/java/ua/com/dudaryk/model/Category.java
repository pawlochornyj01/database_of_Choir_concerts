package ua.com.dudaryk.model;


import org.hibernate.validator.constraints.NotEmpty;
import ua.com.dudaryk.service.dto.CategoryDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private long categoryId;

    @Column(name = "NAME", unique = true)
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Dudaryk> dudaryks = new ArrayList<>();

    public static Category toEntity(CategoryDTO categoryDTO) {
        Category category = new Category()
                .setName(categoryDTO.getName())
                .setDudaryks(categoryDTO.getDudaryks());
        if (categoryDTO.getCategoryId() != 0) {
            category.setCategoryId(categoryDTO.getCategoryId());
        }
        return category;
    }

    public List<Dudaryk> getDudaryks() {
        return dudaryks;
    }

    public Category setDudaryks(List<Dudaryk> dudaryks) {
        this.dudaryks = dudaryks;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public Category setCategoryId(long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
