package com.ironhack.DnDCharacterSheet.ClassesBonus;

import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IfRanger {   // STR, DEX - Light Armor, Medium Armor, Shields, Simple Weapons, Martial Weapons, 3 skills

    public Pair<String, String> getProficiencySavingThrows() {
        return new Pair<>("strength", "dexterity");
    }

    public List<String> getProficienciesAndLanguages() {
        List<String> proficiencies = new ArrayList<>();
        proficiencies.add("Light Armor");
        proficiencies.add("Medium Armor");
        proficiencies.add("Shields");
        proficiencies.add("Simple Weapons");
        proficiencies.add("Martial Weapons");
        return proficiencies;
    }

    public List<String> selectSkills() {
        String[] skillOptions = {
                "Animal Handling", "Athletics", "Insight", "Investigation", "Nature", "Perception", "Stealth", "Survival"
        };

        // For simplicity, select the first three skills
        List<String> selectedSkills = new ArrayList<>();
        selectedSkills.add(skillOptions[0]);
        selectedSkills.add(skillOptions[1]);
        selectedSkills.add(skillOptions[2]);

        return selectedSkills;
    }
}