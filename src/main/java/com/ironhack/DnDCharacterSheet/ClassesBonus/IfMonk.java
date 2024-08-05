package com.ironhack.DnDCharacterSheet.ClassesBonus;

import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IfMonk {    // STR, DEX - Simple Weapons, Shortswords, Artisan or Musical Instrument, 2 skills

    public Pair<String, String> getProficiencySavingThrows() {
        return new Pair<>("strength", "dexterity");
    }

    public List<String> getProficienciesAndLanguages() {
        List<String> proficiencies = new ArrayList<>();
        proficiencies.add("Simple Weapons");
        proficiencies.add("Shortswords");

        // Adding an example artisan or musical instrument
        String selectedTool = selectTool();
        proficiencies.add(selectedTool);

        return proficiencies;
    }

    private String selectTool() {
        String[] toolOptions = {
                "Bagpipes", "Drum", "Flute", "Lute", "Lyre",
                "Mason's Tools", "Carpenter's Tools", "Smith's Tools"
        };

        // For simplicity, selecting the first tool
        return toolOptions[0];
    }

    public List<String> selectSkills() {
        String[] skillOptions = {
                "Acrobatics", "Athletics", "History", "Insight", "Religion", "Stealth"
        };

        // For simplicity, selecting the first two skills
        List<String> selectedSkills = new ArrayList<>();
        selectedSkills.add(skillOptions[0]);
        selectedSkills.add(skillOptions[1]);

        return selectedSkills;
    }
}