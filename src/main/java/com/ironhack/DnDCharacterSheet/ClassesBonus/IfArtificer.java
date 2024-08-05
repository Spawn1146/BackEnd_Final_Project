package com.ironhack.DnDCharacterSheet.ClassesBonus;

import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class IfArtificer {  // CON, INT - Light Armor, Medium Armor, Shields, Simple weapons, light crossbows, Thieves’ tools, tinker’s tools, one type of artisan’s tools of your choice, 2 skill.

    public Pair<String, String> getProficiencySavingThrows() {
        return new Pair<>("constitution", "intelligence");
    }

    public List<String> getProficienciesAndLanguages() {
        List<String> proficiencies = new ArrayList<>();
        proficiencies.add("Light Armor");
        proficiencies.add("Medium Armor");
        proficiencies.add("Shields");
        proficiencies.add("Simple weapons");
        proficiencies.add("Light crossbows");
        proficiencies.add("Thieves’ tools");
        proficiencies.add("Tinker’s tools");

        // Add one type of artisan’s tools
        String selectedTool = selectArtisansTools();
        proficiencies.add(selectedTool);

        return proficiencies;
    }

    public String selectArtisansTools() {
        String[] artisansTools = {
                "Alchemist’s supplies", "Brewer’s supplies", "Calligrapher's supplies", "Carpenter’s tools",
                "Cartographer’s tools", "Cobbler’s tools", "Cook’s utensils", "Glassblower’s tools",
                "Jeweler’s tools", "Leatherworker’s tools", "Mason’s tools", "Painter’s supplies",
                "Potter’s tools", "Smith’s tools", "Tinker’s tools", "Weaver’s tools", "Woodcarver’s tools"
        };

        // Display the list of tools for the user to choose from
        System.out.println("Choose one type of artisan’s tools from the list below:");
        for (int i = 0; i < artisansTools.length; i++) {
            System.out.println((i + 1) + ". " + artisansTools[i]);
        }

        // Use Scanner to get the user's choice
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 1 || choice > artisansTools.length) {
            System.out.print("Enter the number of your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > artisansTools.length) {
                    System.out.println("Invalid choice. Please choose a number between 1 and " + artisansTools.length);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Return the selected tool
        return artisansTools[choice - 1];
    }

    public List<String> selectSkills() {
        String[] skillOptions = {
                "Arcana", "History", "Investigation", "Medicine", "Nature", "Perception"
        };

        List<String> selectedSkills = new ArrayList<>();

        // Choose 2 skills out of the predefined list
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose two skills from the list below:");
        for (int i = 0; i < skillOptions.length; i++) {
            System.out.println((i + 1) + ". " + skillOptions[i]);
        }

        while (selectedSkills.size() < 2) {
            System.out.print("Enter the number of your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice < 1 || choice > skillOptions.length) {
                    System.out.println("Invalid choice. Please choose a number between 1 and " + skillOptions.length);
                } else if (selectedSkills.contains(skillOptions[choice - 1])) {
                    System.out.println("You have already selected this skill. Please choose a different skill.");
                } else {
                    selectedSkills.add(skillOptions[choice - 1]);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }

        return selectedSkills;
    }
}