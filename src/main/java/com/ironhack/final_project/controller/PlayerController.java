package com.ironhack.final_project.controller;

import com.ironhack.final_project.dto.PlayerRequestDTO;
import com.ironhack.final_project.model.Effect;
import com.ironhack.final_project.model.Player;
import com.ironhack.final_project.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAll() {
        return ResponseEntity.ok(playerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getById(id));
    }

    @GetMapping("/name")
    public ResponseEntity<Player> getByNameIgnoreCase(@RequestParam String name) {
        return ResponseEntity.ok(playerService.getByNameIgnoreCase(name));
    }

    @GetMapping("/name-containing")
    public ResponseEntity<List<Player>> getByNameContainingIgnoreCase(@RequestParam String name) {
        return ResponseEntity.ok(playerService.getByNameContainingIgnoreCase(name));
    }

    @GetMapping("/gold")
    public ResponseEntity<List<Player>> getByGold(@RequestParam long gold) {
        return ResponseEntity.ok(playerService.getByGold(gold));
    }

    @GetMapping("/status")
    public ResponseEntity<List<Player>> getByStatus(@RequestParam List<Effect> status) {
        return ResponseEntity.ok(playerService.getByStatus(status));
    }

    @PostMapping
    public ResponseEntity<Player> create(@Valid @RequestBody PlayerRequestDTO dto) {
        Player player = playerService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@PathVariable Long id, @Valid @RequestBody PlayerRequestDTO dto) {
        Player player = playerService.update(id, dto);
        return ResponseEntity.ok(player);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Player> updateName(@PathVariable Long id, @Valid @RequestBody PlayerRequestDTO dto) {
        return ResponseEntity.ok(playerService.updateName(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
