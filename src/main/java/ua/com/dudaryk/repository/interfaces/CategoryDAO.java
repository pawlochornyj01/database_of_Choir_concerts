package ua.com.dudaryk.repository.interfaces;
import ua.com.dudaryk.model.Category;

public interface CategoryDAO {

    Category findByDudarykId(Long id);

}
