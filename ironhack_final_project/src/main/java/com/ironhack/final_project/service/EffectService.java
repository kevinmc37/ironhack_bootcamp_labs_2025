package com.ironhack.final_project.service;

import com.ironhack.final_project.dto.EffectRequestDTO;
import com.ironhack.final_project.exception.BadRequestException;
import com.ironhack.final_project.exception.EffectNotFoundException;
import com.ironhack.final_project.model.Effect;
import com.ironhack.final_project.repository.EffectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EffectService {
    private final EffectRepository effectRepository;

    public EffectService(EffectRepository effectRepository) {
        this.effectRepository = effectRepository;
    }

    public Effect create (EffectRequestDTO effectRequestDTO) {
        validateName(effectRequestDTO.getName());
        Effect newEffect = new Effect();
        newEffect.setName(effectRequestDTO.getName());
        if (effectRequestDTO.getDescription() != null) {
            newEffect.setDescription(effectRequestDTO.getDescription());
        }
        if (effectRequestDTO.getTurns() != 0) {
            newEffect.setTurns(effectRequestDTO.getTurns());
        }
        return effectRepository.save(newEffect);
    }

    public Effect update(Long id, EffectRequestDTO effectRequestDTO) {
        Optional<Effect> optionalEffect = getEffect(id);
        Effect effectFromDb = optionalEffect.get();
        validateUpdatedName(effectFromDb, effectRequestDTO.getName());
        effectFromDb.setName(effectRequestDTO.getName());
        effectFromDb.setDescription(effectRequestDTO.getDescription());
        effectFromDb.setTurns(effectRequestDTO.getTurns());
        return effectRepository.save(effectFromDb);
    }

    public Effect updateName(Long id, EffectRequestDTO effectRequestDTO) {
        Optional<Effect> optionalEffect = getEffect(id);
        Effect effectFromDb = optionalEffect.get();
        validateUpdatedName(effectFromDb, effectRequestDTO.getName());
        effectFromDb.setName(effectRequestDTO.getName());
        return effectRepository.save(effectFromDb);
    }

    public void delete(Long id) {
        boolean existsById = effectRepository.existsById(id);
        if (!existsById) { throw new EffectNotFoundException(id.toString()); }
        else { effectRepository.deleteById(id); }
    }

    public List<Effect> getAll() { return effectRepository.findAll(); }

    public Effect getById(Long id) {
        Optional<Effect> optionalEffect = getEffect(id);
        return optionalEffect.get();
    }

    public Effect getByName(String name) {
        return effectRepository.findByName(name);
    }

    private Optional<Effect> getEffect(Long id) {
        Optional<Effect> optionalEffect = effectRepository.findById(id);
        if (optionalEffect.isEmpty()) {
            throw new EffectNotFoundException(id.toString());
        }
        return optionalEffect;
    }

    private void validateName(String name) {
        boolean exists = effectRepository.existsByName(name);
        if (exists) {
            throw new BadRequestException("Effect with name " + name + " already exists.");
        }
    }

    private void validateUpdatedName(Effect effectFromDb, String dto) {
        if (!effectFromDb.getName().equalsIgnoreCase(dto)) { validateName(dto); }
    }
}
