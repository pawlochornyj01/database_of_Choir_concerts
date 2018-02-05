package ua.com.dudaryk.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.service.interfaces.CategoryService;

import javax.validation.Valid;

//@RestController
@Controller
@RequestMapping("category/")
public class CategoryController {

    private CategoryService categoryService;


    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "all/")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("category_list");
        modelAndView.addObject("categoryList", categoryService.findAll());
        return modelAndView;
    }


    @RequestMapping(value = "all/", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category_list";
        }
        categoryService.save(category);
        return "redirect:/category/all/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable long id) {
        categoryService.delete(new Category().setCategoryId(id));
        return "redirect:/category/all/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public String updateCategory(@PathVariable long id, @ModelAttribute("category") @Valid Category category,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "category_list";
        }
        categoryService.update(category);
//        if (category.getCategoryId() > 0)
//            categoryService.update(new Category().setCategoryId(id).setName(name));
        return "redirect:/category/all/";
    }


}
