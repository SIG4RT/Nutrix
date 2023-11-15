package io.everyonecodes.Nutrix.controller;

import io.everyonecodes.Nutrix.service.MealService;

public class WebController {

    MealService service;

    public WebController(MealService service) {
        this.service = service;
    }

    

}
