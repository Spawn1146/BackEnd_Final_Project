package com.ironhack.DnDCharacterSheet.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OtherProficiencyOrLanguageDTO {
    private Long id;
    private String name;
    private Long characterId;  // To avoid circular reference

    // Constructor
    public OtherProficiencyOrLanguageDTO(Long id, String name, Long characterId) {
        this.id = id;
        this.name = name;
        this.characterId = characterId;
    }
}