package ua.com.dudaryk.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ua.com.dudaryk.model.Category;
import ua.com.dudaryk.service.interfaces.CategoryService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController implements Controller {

    private CategoryService categoryService;
//    private List<Category> categoryList;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
//        this.categoryList = categoryService.findAll();
    }


//    @GetMapping(value = "/all")
//    public List<Category> findAll() {
//        return categoryService.findAll();
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public Category update(@RequestBody Category category) {
//
//        if (category.getCategoryId() > 0)
//            category = categoryService.update(category);
//        return category;
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public Category save(@RequestBody Category category) {
//
//        return categoryService.save(category);
//    }
//
//    @GetMapping(value = "/byDudarykId")
//    public Category findByDudarykId(Long id) {
//        return categoryService.findByDudarykId(id);
//    }



    public ModelAndView handleRequest(HttpServletRequest arg0,
                                      HttpServletResponse arg1) throws Exception {

        ModelAndView modelAndView = new ModelAndView("categoryList");
        modelAndView.addObject("categoryList", categoryService.findAll());

        return modelAndView;
    }
}
