package com.ironhack.DnDCharacterSheet.ClassesBonus;

import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IfSorcerer {  // CON, CHA - Daggers, darts, slings, quarterstaffs, light crossbows, 2 skills

    public Pair<String, String> getProficiencySavingThrows() {
        return new Pair<>("constitution", "charisma");
    }

    public List<String> getProficienciesAndLanguages() {
        List<String> proficiencies = new ArrayList<>();
        proficiencies.add("Daggers");
        proficiencies.add("Darts");
        proficiencies.add("Slings");
        proficiencies.add("Quarterstaffs");
        proficiencies.add("Light Crossbows");
        return proficiencies;
    }

    public List<String> selectSkills() {
        String[] skillOptions = {
                "Arcana", "Deception", "Insight", "Intimidation", "Persuasion", "Religion"
        };

        // For simplicity, select the first two skills
        List<String> selectedSkills = new ArrayList<>();
        selectedSkills.add(skillOptions[0]);
        selectedSkills.add(skillOptions[1]);

        return selectedSkills;
    }
}