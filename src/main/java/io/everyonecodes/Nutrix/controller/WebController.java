package io.everyonecodes.Nutrix.controller;

import io.everyonecodes.Nutrix.entity.Meal;
import io.everyonecodes.Nutrix.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    private MealService service;

    public WebController(MealService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView index() {

        ModelAndView mav = new ModelAndView("index");
        List<Meal> allMeals = service.getAll();

        mav.addObject("allMeals", allMeals);

        return mav;


    }

    @GetMapping("/allmeals")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("allmeals");
        mav.addObject("allMeals", service.getAll());
        return mav;
    }


    @GetMapping("/meal/{id}")
    public ModelAndView getById (@PathVariable Long id) {
        Optional<Meal> oMeal = service.getById(id);
        Meal meal = null;

        ModelAndView mav = new ModelAndView("meal");

        if (oMeal.isPresent()) {
            meal = oMeal.get();
        }

        mav.addObject("meal", meal);

        return mav;
    }

}
