package com.ironhack.DnDCharacterSheet.ClassesBonus;

import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class IfCleric {  // WIS, CHA - Light Armor, Medium Armor, Shields, Simple Weapons, 2 skills

    public Pair<String, String> getProficiencySavingThrows() {
        return new Pair<>("wisdom", "charisma");
    }

    public List<String> getProficienciesAndLanguages() {
        List<String> proficiencies = new ArrayList<>();
        proficiencies.add("Light Armor");
        proficiencies.add("Medium Armor");
        proficiencies.add("Shields");
        proficiencies.add("Simple Weapons");
        return proficiencies;
    }

    public List<String> selectSkills() {
        String[] skillOptions = {
                "History", "Insight", "Medicine", "Persuasion", "Religion"
        };

        // For simplicity, select the first two skills
        List<String> selectedSkills = new ArrayList<>();
        selectedSkills.add(skillOptions[0]);
        selectedSkills.add(skillOptions[1]);

        return selectedSkills;
    }
}