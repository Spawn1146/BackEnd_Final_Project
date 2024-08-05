package com.ironhack.DnDCharacterSheet.Service;

import com.ironhack.DnDCharacterSheet.DTO.OtherProficiencyOrLanguageDTO;
import com.ironhack.DnDCharacterSheet.Domain.MyCharacters;
import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Repository.OtherProficiencyOrLanguageRepository;
import com.ironhack.DnDCharacterSheet.Repository.MyCharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OtherProficiencyOrLanguageService {

    @Autowired
    private OtherProficiencyOrLanguageRepository repository;

    @Autowired
    private MyCharactersRepository myCharactersRepository;

    // Convert entity to DTO
    private OtherProficiencyOrLanguageDTO convertToDTO(OtherProficiencyOrLanguage entity) {
        return new OtherProficiencyOrLanguageDTO(
                entity.getId(),
                entity.getName(),
                entity.getCharacter() != null ? entity.getCharacter().getId() : null
        );
    }

    // Convert DTO to entity
    private OtherProficiencyOrLanguage convertToEntity(OtherProficiencyOrLanguageDTO dto) {
        Optional<MyCharacters> character = myCharactersRepository.findById(dto.getCharacterId());
        return new OtherProficiencyOrLanguage(dto.getName(), character.orElse(null));
    }

    // Get all proficiencies
    public List<OtherProficiencyOrLanguageDTO> getAllProficiencies() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Get a proficiency by ID
    public OtherProficiencyOrLanguageDTO getProficiencyById(Long id) {
        Optional<OtherProficiencyOrLanguage> proficiency = repository.findById(id);
        return proficiency.map(this::convertToDTO).orElse(null);
    }

    // Create or update a proficiency
    public OtherProficiencyOrLanguageDTO saveProficiency(OtherProficiencyOrLanguageDTO dto) {
        OtherProficiencyOrLanguage entity = convertToEntity(dto);
        repository.save(entity);
        return convertToDTO(entity);
    }

    // Delete a proficiency by ID
    public void deleteProficiency(Long id) {
        repository.deleteById(id);
    }
}