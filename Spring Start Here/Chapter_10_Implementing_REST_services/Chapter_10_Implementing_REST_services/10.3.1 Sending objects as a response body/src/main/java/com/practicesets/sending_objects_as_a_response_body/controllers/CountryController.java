package com.practicesets.sending_objects_as_a_response_body.controllers;

import com.practicesets.sending_objects_as_a_response_body.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public Country france() {
        return Country.of("France", 67);
    }

    @GetMapping("/all")
    public List<Country> countries(){
        return List.of(
            Country.of("France", 67),
            Country.of("Spain", 47),
            Country.of("Italy", 60)
        );
    }
}
