package com.example.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Stellt automatisch Datenbank-Befehle wie findAll() und save() bereit
@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}