package com.example.backend.controller;

import com.example.backend.model.AppUser;
import com.example.backend.repository.AppUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AppUserRepository userRepository;

    public AuthController(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String phone = body.getOrDefault("phone", "").replaceAll("[^0-9+]", "");
        String name = body.getOrDefault("name", "").trim();

        if (phone.length() < 6 || name.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Telefonnummer und Name erforderlich"));
        }

        Optional<AppUser> existing = userRepository.findByPhone(phone);
        if (existing.isPresent()) {
            AppUser user = existing.get();
            user.setName(name);
            return ResponseEntity.ok(userRepository.save(user));
        }

        return ResponseEntity.ok(userRepository.save(new AppUser(phone, name)));
    }
}
