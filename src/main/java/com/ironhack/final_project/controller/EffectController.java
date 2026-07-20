package com.ironhack.final_project.controller;

import com.ironhack.final_project.dto.EffectRequestDTO;
import com.ironhack.final_project.model.Effect;
import com.ironhack.final_project.service.EffectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/effects")
public class EffectController {
    private final EffectService effectService;

    public EffectController(EffectService effectService) {
        this.effectService = effectService;
    }

    @GetMapping
    public ResponseEntity<List<Effect>> getAll() {
        return ResponseEntity.ok(effectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Effect> getById(@PathVariable Long id) {
        return ResponseEntity.ok(effectService.getById(id));
    }

    @GetMapping("/name")
    public ResponseEntity<Effect> getByName(@RequestParam String name) {
        return ResponseEntity.ok(effectService.getByName(name));
    }

    @PostMapping
    public ResponseEntity<Effect> create(@Valid @RequestBody EffectRequestDTO dto) {
        Effect effect = effectService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(effect);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Effect> update(@PathVariable Long id, @Valid @RequestBody EffectRequestDTO dto) {
        Effect effect = effectService.update(id, dto);
        return ResponseEntity.ok(effect);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Effect> updateName(@PathVariable Long id, @Valid @RequestBody EffectRequestDTO dto) {
        return ResponseEntity.ok(effectService.updateName(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        effectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
