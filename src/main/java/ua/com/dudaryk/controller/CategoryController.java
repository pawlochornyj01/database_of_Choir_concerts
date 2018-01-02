package ua.com.dudaryk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.service.interfaces.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/all")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Category update(@RequestBody Category category) {

        if (category.getCategoryId() > 0)
            category = categoryService.update(category);
        return category;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Category save(@RequestBody Category category) {

        return categoryService.save(category);
    }

    @GetMapping(value = "/byDudarykId")
    public Category findByDudarykId(Long id) {
        return categoryService.findByDudarykId(id);
    }


}
