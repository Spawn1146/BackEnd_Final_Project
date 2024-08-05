package com.ironhack.DnDCharacterSheet.Service;

import com.ironhack.DnDCharacterSheet.Enum.Skills;
import com.ironhack.DnDCharacterSheet.Domain.*;
import com.ironhack.DnDCharacterSheet.DTO.*;
import com.ironhack.DnDCharacterSheet.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyCharactersService {

    @Autowired
    private MyCharactersRepository myCharactersRepository;

    @Autowired
    private OtherProficiencyOrLanguageRepository otherProficiencyOrLanguageRepository;

    // Convert entity to DTO
    private MyCharactersDTO convertToDTO(MyCharacters character) {
        return new MyCharactersDTO(
                character.getId(), character.getName(), character.getRace(), character.getBackground(),
                character.getAlignment(), character.getLevel(), character.getMainClass(), character.getSubClasses(),
                character.getStatType(), character.getSpeed(), character.getInitiative(), character.getArmorClass(),
                character.getHitDice(), character.isInspiration(), character.getProficiencyBonus(),
                character.getProficiencyST(),
                character.getOtherProficienciesAndLanguages().stream()
                        .map(OtherProficiencyOrLanguage::getName).collect(Collectors.toList()),
                character.getSkills().stream()
                        .map(skill -> Skills.valueOf(skill.getName())).collect(Collectors.toList()),
                null // You can replace null with any other information
        );
    }

    // Convert DTO to entity
    private MyCharacters convertToEntity(MyCharactersDTO characterDTO) {
        List<OtherProficiencyOrLanguage> otherProficienciesAndLanguages = characterDTO.getOtherProficienciesAndLanguages().stream()
                .map(OtherProficiencyOrLanguage::new)
                .collect(Collectors.toList());

        List<OtherProficiencyOrLanguage> skills = characterDTO.getSkills().stream()
                .map(skill -> new OtherProficiencyOrLanguage(skill.name()))
                .collect(Collectors.toList());

        MyCharacters character = new MyCharacters(
                characterDTO.getName(), characterDTO.getRace(), characterDTO.getBackground(),
                characterDTO.getAlignment(), characterDTO.getLevel(), characterDTO.getMainClass(),
                characterDTO.getSubClasses(), characterDTO.getStatType(), characterDTO.getSpeed(),
                characterDTO.getInitiative(), characterDTO.getArmorClass(), characterDTO.getHitDice(),
                characterDTO.isInspiration(), characterDTO.getProficiencyBonus()
        );

        character.setProficiencyST(characterDTO.getProficiencyST());

        // Set proficiencies and languages to the Character entity
        character.getOtherProficienciesAndLanguages().addAll(otherProficienciesAndLanguages);
        character.getSkills().addAll(skills);

        return character;
    }

    public List<MyCharactersDTO> getAllCharacters() {
        List<MyCharacters> characters = myCharactersRepository.findAll();
        return characters.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public MyCharactersDTO getCharacterById(Long id) {
        Optional<MyCharacters> character = myCharactersRepository.findById(id);
        return character.map(this::convertToDTO).orElse(null);
    }

    public MyCharactersDTO createCharacter(MyCharactersDTO characterDTO) {
        MyCharacters character = convertToEntity(characterDTO);
        character = myCharactersRepository.save(character);
        return convertToDTO(character);
    }

    public MyCharactersDTO updateCharacter(MyCharactersDTO characterDTO) {
        MyCharacters character = convertToEntity(characterDTO);
        character = myCharactersRepository.save(character);
        return convertToDTO(character);
    }

    public void deleteCharacter(Long id) {
        myCharactersRepository.deleteById(id);
    }
}