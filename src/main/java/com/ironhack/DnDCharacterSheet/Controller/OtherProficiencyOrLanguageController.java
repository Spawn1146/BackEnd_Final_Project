package com.ironhack.DnDCharacterSheet.Controller;

import com.ironhack.DnDCharacterSheet.DTO.OtherProficiencyOrLanguageDTO;
import com.ironhack.DnDCharacterSheet.Service.OtherProficiencyOrLanguageService;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proficiencies")
public class OtherProficiencyOrLanguageController {

    @Autowired
    private OtherProficiencyOrLanguageService service;

    // Get all proficiencies
    @GetMapping
    public List<OtherProficiencyOrLanguageDTO> getAllProficiencies() {
        return service.getAllProficiencies();
    }

    // Get a proficiency by ID
    @GetMapping("/{id}")
    public OtherProficiencyOrLanguageDTO getProficiencyById(@PathVariable Long id) {
        return service.getProficiencyById(id);
    }

    // Create a new proficiency
    @PostMapping
    public OtherProficiencyOrLanguageDTO createProficiency(@RequestBody OtherProficiencyOrLanguageDTO proficiencyDTO) {
        return service.saveProficiency(proficiencyDTO);
    }

    // Update an existing proficiency
    @PutMapping("/{id}")
    public OtherProficiencyOrLanguageDTO updateProficiency(@PathVariable Long id, @RequestBody OtherProficiencyOrLanguageDTO proficiencyDTO) {
        proficiencyDTO.setId(id);
        return service.saveProficiency(proficiencyDTO);
    }

    // Delete a proficiency by ID
    @DeleteMapping("/{id}")
    public void deleteProficiency(@PathVariable Long id) {
        service.deleteProficiency(id);
    }
}