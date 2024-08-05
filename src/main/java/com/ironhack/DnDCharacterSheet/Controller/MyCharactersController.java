package com.ironhack.DnDCharacterSheet.Controller;

import com.ironhack.DnDCharacterSheet.Service.MyCharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class MyCharactersController {

    @Autowired
    private MyCharactersService myCharactersService;

    // Get all characters
    @GetMapping
    public List<com.ironhack.DnDCharacterSheet.DTO.MyCharactersDTO> getAllCharacters() {
        return myCharactersService.getAllCharacters();
    }

    // Get a character by ID
    @GetMapping("/{id}")
    public com.ironhack.DnDCharacterSheet.DTO.MyCharactersDTO getCharacterById(@PathVariable Long id) {
        return myCharactersService.getCharacterById(id);
    }

    // Create a new character
    @PostMapping
    public com.ironhack.DnDCharacterSheet.DTO.MyCharactersDTO createCharacter(@RequestBody com.ironhack.DnDCharacterSheet.DTO.MyCharactersDTO myCharactersDTO) {
        return myCharactersService.createCharacter(myCharactersDTO);
    }

    // Update an existing character
    @PutMapping("/{id}")
    public com.ironhack.DnDCharacterSheet.DTO.MyCharactersDTO updateCharacter(@PathVariable Long id, @RequestBody com.ironhack.DnDCharacterSheet.DTO.MyCharactersDTO myCharactersDTO) {
        myCharactersDTO.setId(id);
        return myCharactersService.updateCharacter(myCharactersDTO);
    }

    // Delete a character by ID
    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        myCharactersService.deleteCharacter(id);
    }
}