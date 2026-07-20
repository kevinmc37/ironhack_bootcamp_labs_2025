package com.ironhack.final_project.service;

import com.ironhack.final_project.dto.PlayerRequestDTO;
import com.ironhack.final_project.exception.BadRequestException;
import com.ironhack.final_project.exception.PlayerNotFoundException;
import com.ironhack.final_project.model.Effect;
import com.ironhack.final_project.model.Player;
import com.ironhack.final_project.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player create (PlayerRequestDTO playerRequestDTO) {
        validateName(playerRequestDTO.getName());
        Player newPlayer = new Player();
        newPlayer.setName(playerRequestDTO.getName());
        if (playerRequestDTO.getHealth() != 0) {
            newPlayer.setHealth(playerRequestDTO.getHealth());
        }
        if (playerRequestDTO.getAttack() != 0) {
            newPlayer.setAttack(playerRequestDTO.getAttack());
        }
        if (playerRequestDTO.getDefense() != 0) {
            newPlayer.setDefense(playerRequestDTO.getDefense());
        }
        if (playerRequestDTO.getSpeed() != 0) {
            newPlayer.setSpeed(playerRequestDTO.getSpeed());
        }
        if (playerRequestDTO.getInventory() != null) {
            newPlayer.setInventory(playerRequestDTO.getInventory());
        }
        if (playerRequestDTO.getGold() != 0) {
            newPlayer.setGold(playerRequestDTO.getGold());
        }
        if (playerRequestDTO.getWeight() != 0) {
            newPlayer.setWeight(playerRequestDTO.getWeight());
        }
        if (playerRequestDTO.getStatus() != null) {
            newPlayer.setStatus(playerRequestDTO.getStatus());
        }
        return playerRepository.save(newPlayer);
    }

    public Player update(Long id, PlayerRequestDTO playerRequestDTO) {
        Optional<Player> optionalPlayer = getPlayer(id);
        Player playerFromDb = optionalPlayer.get();
        validateUpdatedName(playerFromDb, playerRequestDTO.getName());
        playerFromDb.setName(playerRequestDTO.getName());
        playerFromDb.setHealth(playerRequestDTO.getHealth());
        playerFromDb.setAttack(playerRequestDTO.getAttack());
        playerFromDb.setDefense(playerRequestDTO.getDefense());
        playerFromDb.setSpeed(playerRequestDTO.getSpeed());
        playerFromDb.setInventory(playerRequestDTO.getInventory());
        playerFromDb.setGold(playerRequestDTO.getGold());
        playerFromDb.setWeight(playerRequestDTO.getWeight());
        playerFromDb.setStatus(playerRequestDTO.getStatus());
        return playerRepository.save(playerFromDb);
    }

    public Player updateName(Long id, PlayerRequestDTO playerRequestDTO) {
        Optional<Player> optionalPlayer = getPlayer(id);
        Player playerFromDb = optionalPlayer.get();
        validateUpdatedName(playerFromDb, playerRequestDTO.getName());
        playerFromDb.setName(playerRequestDTO.getName());
        return playerRepository.save(playerFromDb);
    }

    public void delete(Long id) {
        boolean existsById = playerRepository.existsById(id);
        if (!existsById) { throw new PlayerNotFoundException(id.toString()); }
        else { playerRepository.deleteById(id); }
    }

    public List<Player> getAll() { return playerRepository.findAll(); }

    public Player getById(Long id) {
        Optional<Player> optionalPlayer = getPlayer(id);
        return optionalPlayer.get();
    }

    public Player getByNameIgnoreCase(String name) {
        return playerRepository.findByNameIgnoreCase(name);
    }

    public List<Player> getByNameContainingIgnoreCase(String name) {
        return playerRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Player> getByGold(long gold) {
        return playerRepository.findByGold(gold);
    }

    public List<Player> getByStatus(List<Effect> status) {
        return  playerRepository.findByStatus(status);
    }

    private Optional<Player> getPlayer(Long id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isEmpty()) {
            throw new PlayerNotFoundException(id.toString());
        }
        return optionalPlayer;
    }

    private void validateName(String name) {
        boolean exists = playerRepository.existsByName(name);
        if (exists) {
            throw new BadRequestException("Player with name " + name + " already exists.");
        }
    }

    private void validateUpdatedName(Player playerFromDb, String dto) {
        if (!playerFromDb.getName().equalsIgnoreCase(dto)) { validateName(dto); }
    }
}
