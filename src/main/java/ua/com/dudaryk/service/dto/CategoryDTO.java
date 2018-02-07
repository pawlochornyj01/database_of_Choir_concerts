package ua.com.dudaryk.service.dto;

import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.model.Dudaryk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryDTO implements Serializable {

    private int categoryId;

    private String name;

    private List<Dudaryk> dudaryks;

    private static CategoryDTO toDto(Category category) {
        return new CategoryDTO()
                .setCategoryId(category.getCategoryId())
                .setName(category.getName())
                .setDudaryks(category.getDudaryks());
    }

    public static List<CategoryDTO> toDto(List<Category> categories) {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categories) {
            categoryDTOList.add(toDto(category));
        }
        return categoryDTOList;
    }


    public int getCategoryId() {
        return categoryId;
    }

    private CategoryDTO setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    private CategoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<Dudaryk> getDudaryks() {
        return dudaryks;
    }

    public CategoryDTO setDudaryks(List<Dudaryk> dudaryks) {
        this.dudaryks = dudaryks;
        return this;
    }
}
