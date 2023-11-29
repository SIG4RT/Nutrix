package io.everyonecodes.Nutrix.controller;

import io.everyonecodes.Nutrix.entity.Meal;
import io.everyonecodes.Nutrix.service.CategoryService;
import io.everyonecodes.Nutrix.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class WebController {

    private MealService mealService;
    private CategoryService categoryService;

    public WebController(MealService mealService, CategoryService categoryService) {
        this.mealService = mealService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("allCategories", categoryService.getAll());
        return mav;
    }

    @GetMapping("/allmeals")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("allmeals");
        mav.addObject("allMeals", mealService.getAll());
        return mav;
    }

    @GetMapping("/favoritemeals")
    public ModelAndView getFavorites() {
        ModelAndView mav = new ModelAndView("favoritemeals");
        mav.addObject("favoriteMeals", mealService.getFavorites());
        return mav;
    }

    @GetMapping("/recentmeals")
    public ModelAndView getRecent() {
        ModelAndView mav = new ModelAndView("recentmeals");
        mav.addObject("recentMeals", mealService.getLast20Meals());
        return mav;
    }

    @GetMapping("/meal/{id}")
    public ModelAndView getById (@PathVariable Long id) {
        Optional<Meal> oMeal = mealService.getById(id);
        ModelAndView mav = new ModelAndView("meal");
        mav.addObject("meal", oMeal.get());
        return mav;
    }

    // ----- Misc Mappings -----

    @GetMapping("/misc/tos")
    public ModelAndView getTos() {
        ModelAndView mav = new ModelAndView("misc/tos");
        return mav;
    }

    @GetMapping("/misc/privacypolicy")
    public ModelAndView getPrivacyPolicy() {
        ModelAndView mav = new ModelAndView("misc/privacypolicy");
        return mav;
    }

}
