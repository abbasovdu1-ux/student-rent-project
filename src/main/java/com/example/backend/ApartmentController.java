package com.example.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apartments")
@CrossOrigin(origins = "*")
public class ApartmentController {

    @Autowired
    private ApartmentRepository repository;

    @GetMapping
    public List<Apartment> getAllApartments() {
        return repository.findAll();
    }

    @PostMapping
    public Apartment createApartment(@RequestBody Apartment apartment) {
        return repository.save(apartment);
    }

    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable Long id) {
        repository.deleteById(id);
    }
}