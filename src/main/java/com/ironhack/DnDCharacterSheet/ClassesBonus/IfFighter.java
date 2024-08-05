package com.ironhack.DnDCharacterSheet.ClassesBonus;

import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class IfFighter {   // STR, CON - All Armor, Shields, Simple Weapons, Martial Weapons, 2 skills

    public Pair<String, String> getProficiencySavingThrows() {
        return new Pair<>("strength", "constitution");
    }

    public List<String> getProficienciesAndLanguages() {
        List<String> proficiencies = new ArrayList<>();
        proficiencies.add("All Armor");
        proficiencies.add("Shields");
        proficiencies.add("Simple Weapons");
        proficiencies.add("Martial Weapons");
        return proficiencies;
    }

    public List<String> selectSkills() {
        String[] skillOptions = {
                "Acrobatics", "Animal Handling", "Athletics", "History", "Insight", "Intimidation", "Perception", "Survival"
        };

        // For simplicity, select the first two skills
        List<String> selectedSkills = new ArrayList<>();
        selectedSkills.add(skillOptions[0]);
        selectedSkills.add(skillOptions[1]);

        return selectedSkills;
    }
}