package com.ironhack.DnDCharacterSheet.ClassesBonus;

import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class IfDruid {  // INT, WIS - Light Armor, Medium Armor, Shields (no metal shields/armor), Clubs, daggers, darts, javelins, maces, quarterstaffs, scimitars, sickles, slings, spears, Herbalism Kit, 2 skills

    public Pair<String, String> getProficiencySavingThrows() {
        return new Pair<>("intelligence", "wisdom");
    }

    public List<String> getProficienciesAndLanguages() {
        List<String> proficiencies = new ArrayList<>();
        proficiencies.add("Light Armor (non-metal)");
        proficiencies.add("Medium Armor (non-metal)");
        proficiencies.add("Shields (non-metal)");
        proficiencies.add("Clubs");
        proficiencies.add("Daggers");
        proficiencies.add("Darts");
        proficiencies.add("Javelins");
        proficiencies.add("Maces");
        proficiencies.add("Quarterstaffs");
        proficiencies.add("Scimitars");
        proficiencies.add("Sickles");
        proficiencies.add("Slings");
        proficiencies.add("Spears");
        proficiencies.add("Herbalism Kit");
        return proficiencies;
    }

    public List<String> selectSkills() {
        String[] skillOptions = {
                "Arcana", "Animal Handling", "Insight", "Medicine", "Nature", "Perception", "Religion", "Survival"
        };

        // For simplicity, select the first two skills
        List<String> selectedSkills = new ArrayList<>();
        selectedSkills.add(skillOptions[0]);
        selectedSkills.add(skillOptions[1]);

        return selectedSkills;
    }
}