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
        ModelAndView modelAndView = new ModelAndView("category/all");
        modelAndView.addObject("categoryList", categoryService.findAll());
        return modelAndView;
    }


    @RequestMapping(value = "add/", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/all";
        }
        categoryService.save(category);
        return "redirect:/category/all/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int id) {
        categoryService.delete(new Category().setCategoryId(id));
        return "redirect:/category/all/";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.POST)
    public String updateCategory(@PathVariable("id") int id, @ModelAttribute("category") Category category) {

        categoryService.update(category.setCategoryId(id));
        return "redirect:/category/all/";
    }

//    @PostMapping(value = "update/")
//    public String updateCategory(@RequestBody Category category,@RequestParam(value = "name") String name) {
////        categoryService.update(category);
//        categoryService.update(category.setName(name));
//        return "redirect:/category/all/";
//    }

//    @RequestMapping(value = "update/", method = RequestMethod.POST)
//    public String updateCategory(@ModelAttribute("category") @Valid Category category, BindingResult result) {
//        if (result.hasErrors()) {
//            return "category_list";
//        }
//        categoryService.update(category);
//        return "redirect:/category/all/";
//    }
//
//    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
//
//    public ModelAndView update(@PathVariable int id, @RequestBody Category category) {
//        ModelAndView modelAndView = new ModelAndView("update_category");
//
//
//        categoryService.update(new Category().setCategoryId(id));
//        modelAndView.addObject("category", category);
//        modelAndView.addObject("categoryList", categoryService.findAll());
//        return modelAndView;
//
//    }

}
