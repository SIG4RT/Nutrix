package io.everyonecodes.Nutrix.controller;

import io.everyonecodes.Nutrix.service.CategoryService;
import io.everyonecodes.Nutrix.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    private final MealService mealService;
    private final CategoryService categoryService;

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

    // ----- Meal Mappings -----

    @GetMapping("/allmeals")
    public ModelAndView getAllMeals() {
        ModelAndView mav = new ModelAndView("allmeals");
        mav.addObject("allMeals", mealService.getAll());
        return mav;
    }

    @GetMapping("/favoritemeals")
    public ModelAndView getFavoriteMeals() {
        ModelAndView mav = new ModelAndView("favoritemeals");
        mav.addObject("favoriteMeals", mealService.getFavorites());
        return mav;
    }

    @GetMapping("/recentmeals")
    public ModelAndView getRecentMeals() {
        ModelAndView mav = new ModelAndView("recentmeals");
        mav.addObject("recentMeals", mealService.getLast20Meals());
        return mav;
    }

    @GetMapping("/meal/{id}")
    public ModelAndView getMealById (@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("meal");
        mav.addObject("meal", mealService.getById(id).get());
        return mav;
    }

    // ----- Category Mappings -----

    @GetMapping("/categories")
    public ModelAndView getAllCategories() {
        ModelAndView mav = new ModelAndView("categories");
        mav.addObject("categories", categoryService.getAll());
        return mav;
    }

    @GetMapping("/category/{id}")
    public ModelAndView getCategoryById(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("category");
        mav.addObject("category", categoryService.getById(id).get());
        mav.addObject("mealsInCategory", mealService.getMealsByCategoryId(id));
        mav.addObject("totalCalories", mealService.getTotalCaloriesByCategoryId(id));
        mav.addObject("totalCarbs", mealService.getTotalCarbsByCategoryId(id));
        mav.addObject("totalProtein", mealService.getTotalProteinByCategoryId(id));
        mav.addObject("totalFat", mealService.getTotalFatByCategoryId(id));
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

    @GetMapping("/misc/test")
    public ModelAndView getTest() {
        ModelAndView mav = new ModelAndView("misc/test");
        return mav;
    }
}
