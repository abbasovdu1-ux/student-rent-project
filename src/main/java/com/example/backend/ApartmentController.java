package com.example.backend;

// Spring-Boot-Imports fuer REST und Abhaengigkeiten
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// Kennzeichnet die Klasse als REST-Controller (Daten werden als JSON gesendet)
@RestController

// Basis-URL fuer die Apartment-Routen
@RequestMapping("/api/apartments")

// Erlaubt dem Vue-Frontend auf Render den Zugriff auf diese Endpunkte
@CrossOrigin(origins = "*")
public class ApartmentController {

    // Bindet unser Datenbank-Repository automatisch ein
    @Autowired
    private ApartmentRepository repository;

    // Reagiert auf GET-Anfragen und holt alle Eintraege direkt aus der Datenbank
    @GetMapping
    public List<Apartment> getAllApartments() {
        // Holt alle gespeicherten Zeilen aus PostgreSQL
        return repository.findAll();
    }

    // Reagiert auf POST-Anfragen, um eine neue Wohnung zu speichern
    @PostMapping
    public Apartment createApartment(@RequestBody Apartment apartment) {
        // Speichert das neue Objekt direkt in der PostgreSQL-Datenbank ab
        return repository.save(apartment);
    }
}