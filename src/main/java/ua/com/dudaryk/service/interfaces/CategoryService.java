package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.service.dto.CategoryDTO;

public interface CategoryService {

    Category findByDudarykId(Long id);
}
