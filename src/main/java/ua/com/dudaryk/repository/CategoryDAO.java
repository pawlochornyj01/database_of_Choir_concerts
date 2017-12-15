package ua.com.dudaryk.repository;
import ua.com.dudaryk.model.Category;

public interface CategoryDAO<Category> {

    Category findByDudaryk(Long id);

}
