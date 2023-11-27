package io.everyonecodes.Nutrix.controller;

import io.everyonecodes.Nutrix.entity.Overview;
import io.everyonecodes.Nutrix.service.OverviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OverviewController {

    private OverviewService service;

    public OverviewController(OverviewService service) {
        this.service = service;
    }

    @GetMapping("alloverviews")
    public List<Overview> getAll() {
        return service.getAll();
    }

}
