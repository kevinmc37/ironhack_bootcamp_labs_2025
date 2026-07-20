package com.ironhack.final_project.repository;

import com.ironhack.final_project.model.Effect;
import com.ironhack.final_project.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByNameIgnoreCase(String name);
    List<Player> findByNameContainingIgnoreCase(String name);
    List<Player> findByGold(long gold);
    List<Player> findByStatus(List<Effect> status);
    boolean existsByName(String name);
}
