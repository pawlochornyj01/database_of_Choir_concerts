package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.repository.interfaces.CategoryDAO;
import ua.com.dudaryk.service.interfaces.CategoryService;
import ua.com.dudaryk.service.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public Category save(Category category) {
        return categoryDAO.saveCategory(category);
    }

    public Category update(Category category) {
        return categoryDAO.updateCategory(category);
    }

    public List<Category> findAll() {

        List<Category> list = categoryDAO.findAllCategory();
        list.sort(Comparator.comparing(Category::getCategoryId));
        return list;
    }

    @Override
    public void delete(Category category) {
        categoryDAO.deleteCategory(category);
    }

    @Transactional(readOnly = true)
    public Category findByDudarykId(int id) {
        return categoryDAO.findByDudarykId(id);


    }

}
