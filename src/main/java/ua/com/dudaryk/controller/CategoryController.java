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

//    @RequestMapping("all/")
//    public void add() {
//
//    }

    @RequestMapping(value = "all/", method = RequestMethod.POST)
    public String categoryAddSubmit(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category_list";
        }
        categoryService.save(category);
        return "redirect:/category/all/";
    }
    @RequestMapping(value = "all/", method = RequestMethod.DELETE)
    public String categoryDelete(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category_list";
        }
        categoryService.save(category);
        return "redirect:/category/all/";
    }

    @RequestMapping("byDudarykId/")
    public void findByDudarykId() {

    }
    @RequestMapping(value = "byDudarykId/", method = RequestMethod.POST)
    public String categoryFind(@ModelAttribute("category") @Valid Category category, BindingResult result,long id) {
        if (result.hasErrors()) {
            return "category/byDudarykId/";
        }
        categoryService.findByDudarykId(id);
        return "redirect:category/byDudarykId/";
    }

//    @GetMapping(value = "byDudarykId/")
//    public ModelAndView findByDudarykId(long id) {
//        ModelAndView modelAndView = new ModelAndView("category_list");
//        modelAndView.addObject("categoryList", categoryService.findByDudarykId(id));
//        return modelAndView;
//    }
    @RequestMapping(value = "update/", method = RequestMethod.PUT)
    public Category update(@RequestBody Category category) {

        if (category.getCategoryId() > 0)
            category = categoryService.update(category);
        return category;
    }
//
//    @RequestMapping(value = "save/", method = RequestMethod.POST)
//    public Category save(@RequestBody Category category) {
//
//        return categoryService.save(category);
//    }
//
//    @GetMapping(value = "byDudarykId/")
//    public Category findByDudarykId(Long id) {
//        return categoryService.findByDudarykId(id);
//    }
}
