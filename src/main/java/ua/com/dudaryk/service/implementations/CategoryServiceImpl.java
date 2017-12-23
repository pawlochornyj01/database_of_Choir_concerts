package ua.com.dudaryk.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.repository.implementations.CategoryDAOImpl;
import ua.com.dudaryk.service.AbstractServiceImpl;
import ua.com.dudaryk.service.interfaces.AbstractService;
import ua.com.dudaryk.service.interfaces.CategoryService;
import ua.com.dudaryk.service.transfers.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl extends AbstractServiceImpl<CategoryDTO> implements CategoryService,AbstractService<CategoryDTO> {

    @Autowired
    private CategoryDAOImpl categoryDAO;

    @Override
    public void setClazz(Class<CategoryDTO> clazzToSet) {
        super.setClazz(clazzToSet);
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDudaryk(categoryDTO.getDudaryk());
        category = categoryDAO.save(category);
        categoryDTO.setCategoryId(category.getCategoryId());
        return categoryDTO;
    }

    public CategoryDTO update(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDudaryk(categoryDTO.getDudaryk());
        category = categoryDAO.update(category);
        categoryDTO.setCategoryId(category.getCategoryId());
        return categoryDTO;
    }

    public void delete(Long id) {
        Category category = categoryDAO.findById(id);
        categoryDAO.delete(category);
    }

    public CategoryDTO findById(Long id) {
        Category category = categoryDAO.findById(id);
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setDudaryk(category.getDudaryk());
        categoryDTO.setName(category.getName());
        categoryDTO.setCategoryId(category.getCategoryId());
        return categoryDTO;
    }

    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryDAO.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryId(category.getCategoryId());
            categoryDTO.setName(category.getName());
            categoryDTO.setDudaryk(category.getDudaryk());
            categoryDTOList.add(categoryDTO);
        }

        return categoryDTOList;
    }


    public CategoryDTO findByDudarykId(Long id) {
        Category category = categoryDAO.findByDudarykId(id);
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setDudaryk(category.getDudaryk());
        categoryDTO.setName(category.getName());
        categoryDTO.setCategoryId(category.getCategoryId());
        return categoryDTO;
    }


}
