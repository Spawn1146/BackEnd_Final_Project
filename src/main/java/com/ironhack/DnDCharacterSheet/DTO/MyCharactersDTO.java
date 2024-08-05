package com.ironhack.DnDCharacterSheet.DTO;

import com.ironhack.DnDCharacterSheet.DTO.*;
import com.ironhack.DnDCharacterSheet.Enum.*;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MyCharactersDTO {
    private Long id;
    private String name;
    private BasicRaces race;
    private String background;
    private Alignment alignment;
    private int level;
    private MainClasses mainClass;
    private String subClasses;
    private StatType statType;
    private int speed;
    private int initiative;
    private int armorClass;
    private int hitDice;
    private boolean inspiration;
    private int proficiencyBonus;
    private Pair<String, String> proficiencyST;
    private List<String> otherProficienciesAndLanguages;
    private List<Skills> skills; // Assuming you have Skills enum values in this list
    private List<Standard_Languages> extras; // Assuming you have Standard_Languages enum values in this list

    // Constructor
    public MyCharactersDTO(Long id, String name, BasicRaces race, String background, Alignment alignment, int level,
                           MainClasses mainClass, String subClasses, StatType statType, int speed, int initiative,
                           int armorClass, int hitDice, boolean inspiration, int proficiencyBonus,
                           Pair<String, String> proficiencyST, List<String> otherProficienciesAndLanguages,
                           List<Skills> skills, List<Standard_Languages> extras) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.background = background;
        this.alignment = alignment;
        this.level = level;
        this.mainClass = mainClass;
        this.subClasses = subClasses;
        this.statType = statType;
        this.speed = speed;
        this.initiative = initiative;
        this.armorClass = armorClass;
        this.hitDice = hitDice;
        this.inspiration = inspiration;
        this.proficiencyBonus = proficiencyBonus;
        this.proficiencyST = proficiencyST;
        this.otherProficienciesAndLanguages = otherProficienciesAndLanguages;
        this.skills = skills;
        this.extras = extras;
    }
}