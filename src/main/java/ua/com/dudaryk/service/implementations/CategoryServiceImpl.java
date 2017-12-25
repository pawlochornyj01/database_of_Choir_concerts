package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.repository.interfaces.CategoryDAO;
import ua.com.dudaryk.service.interfaces.CategoryService;
import ua.com.dudaryk.service.transfers.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = new Category()
                .setName(categoryDTO.getName())
                .setDudaryk(categoryDTO.getDudaryk());
        category = categoryDAO.saveCategory(category);
//        categoryDTO.setCategoryId(category.getCategoryId());
        return categoryDTO;
    }

    public CategoryDTO update(CategoryDTO categoryDTO) {
        Category category = new Category()
                .setName(categoryDTO.getName())
                .setDudaryk(categoryDTO.getDudaryk());
        category = categoryDAO.updateCategory(category);
        categoryDTO.setCategoryId(category.getCategoryId());
        return categoryDTO;
    }

    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryDAO.findAllCategory();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO categoryDTO = new CategoryDTO()
                    .setCategoryId(category.getCategoryId())
                    .setName(category.getName())
                    .setDudaryk(category.getDudaryk());
            categoryDTOList.add(categoryDTO);
        }

        return categoryDTOList;
    }

    public CategoryDTO findByDudarykId(Long id) {
        Category category = categoryDAO.findByDudarykId(id);
        return new CategoryDTO()
                .setDudaryk(category.getDudaryk())
                .setName(category.getName())
                .setCategoryId(category.getCategoryId());

    }


}
