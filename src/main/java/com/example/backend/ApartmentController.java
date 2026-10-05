package com.example.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/apartments")
@CrossOrigin(origins = "*")
public class ApartmentController {

    @GetMapping
    public List<Apartment> getAllApartments() {
        return List.of(
            new Apartment(1L, "Helles WG-Zimmer am Alex", 380.0, "Berlin", "Mitte"),
            new Apartment(2L, "Ruhiges Zimmer fuer Studenten", 420.0, "Berlin", "Karlshorst")
        );
    }
}