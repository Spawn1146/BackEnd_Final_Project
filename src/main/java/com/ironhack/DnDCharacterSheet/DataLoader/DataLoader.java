package com.ironhack.DnDCharacterSheet.DataLoader;

import com.ironhack.DnDCharacterSheet.ClassesBonus.*;
import com.ironhack.DnDCharacterSheet.DTO.MyCharactersDTO;
import com.ironhack.DnDCharacterSheet.Domain.MyCharacters;
import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Enum.*;
import com.ironhack.DnDCharacterSheet.Repository.MyCharactersRepository;
import com.ironhack.DnDCharacterSheet.Repository.OtherProficiencyOrLanguageRepository;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private MyCharactersRepository characterRepository;

    @Autowired
    private OtherProficiencyOrLanguageRepository otherProficiencyOrLanguageRepository;

    @Autowired
    private IfArtificer ifArtificer;
    @Autowired
    private IfBarbarian ifBarbarian;
    @Autowired
    private IfBard ifBard;
    @Autowired
    private IfCleric ifCleric;
    @Autowired
    private IfDruid ifDruid;
    @Autowired
    private IfFighter ifFighter;
    @Autowired
    private IfMonk ifMonk;
    @Autowired
    private IfPaladin ifPaladin;
    @Autowired
    private IfRanger ifRanger;
    @Autowired
    private IfRogue ifRogue;
    @Autowired
    private IfSorcerer ifSorcerer;
    @Autowired
    private IfWarlock ifWarlock;
    @Autowired
    private IfWizard ifWizard;

    @Override
    public void run(String... args) {
        createCharacters();
    }

    private MyCharacters createCharacterFromDTO(MyCharactersDTO characterDTO) {
        MyCharacters character = new MyCharacters(
                characterDTO.getName(), characterDTO.getRace(), characterDTO.getBackground(), characterDTO.getAlignment(),
                characterDTO.getLevel(), characterDTO.getMainClass(), characterDTO.getSubClasses(), characterDTO.getStatType(),
                characterDTO.getSpeed(), characterDTO.getInitiative(), characterDTO.getArmorClass(), characterDTO.getHitDice(),
                characterDTO.isInspiration(), characterDTO.getProficiencyBonus()
        );

        // Convert to Pair and set proficiency saving throws
        character.setProficiencyST(new Pair<>(characterDTO.getProficiencyST().getFirst(), characterDTO.getProficiencyST().getSecond()));

        return character;
    }

    private void createCharacters() {
        List<Skills> artificerSkills = ifArtificer.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> barbarianSkills = ifBarbarian.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> bardSkills = ifBard.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> clericSkills = ifCleric.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> druidSkills = ifDruid.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> fighterSkills = ifFighter.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> monkSkills = ifMonk.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> paladinSkills = ifPaladin.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> rangerSkills = ifRanger.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> rogueSkills = ifRogue.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> sorcererSkills = ifSorcerer.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> warlockSkills = ifWarlock.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());
        List<Skills> wizardSkills = ifWizard.selectSkills().stream().map(Skills::valueOf).collect(Collectors.toList());

        // Artificer Character
        MyCharactersDTO artificerDTO = new MyCharactersDTO(
                null, "Artificer Character", BasicRaces.HUMAN, "Artisan", Alignment.NEUTRAL_GOOD, 1,
                MainClasses.ARTIFICER, "None", StatType.INTELLIGENCE, 30, 2, 15, 10, false, 2,
                ifArtificer.getProficiencySavingThrows(), ifArtificer.getProficienciesAndLanguages(),
                artificerSkills, List.of(Standard_Languages.COMMON, Standard_Languages.DWARVISH)
        );
        saveCharacter(artificerDTO);

        // Barbarian Character
        MyCharactersDTO barbarianDTO = new MyCharactersDTO(
                null, "Barbarian Character", BasicRaces.HUMAN, "Outlander", Alignment.CHAOTIC_GOOD, 1,
                MainClasses.BARBARIAN, "None", StatType.STRENGTH, 30, 2, 15, 10, false, 2,
                ifBarbarian.getProficiencySavingThrows(), ifBarbarian.getProficienciesAndLanguages(),
                barbarianSkills, List.of(Standard_Languages.COMMON)
        );
        saveCharacter(barbarianDTO);

        // Bard Character
        MyCharactersDTO bardDTO = new MyCharactersDTO(
                null, "Bard Character", BasicRaces.ELF, "Entertainer", Alignment.CHAOTIC_NEUTRAL, 1,
                MainClasses.BARD, "None", StatType.CHARISMA, 30, 2, 15, 10, false, 2,
                ifBard.getProficiencySavingThrows(), ifBard.getProficienciesAndLanguages(),
                bardSkills, List.of(Standard_Languages.ELVISH)
        );
        saveCharacter(bardDTO);

        // Cleric Character
        MyCharactersDTO clericDTO = new MyCharactersDTO(
                null, "Cleric Character", BasicRaces.HALFLING, "Acolyte", Alignment.LAWFUL_GOOD, 1,
                MainClasses.CLERIC, "None", StatType.WISDOM, 30, 2, 15, 10, false, 2,
                ifCleric.getProficiencySavingThrows(), ifCleric.getProficienciesAndLanguages(),
                clericSkills, List.of(Standard_Languages.COMMON, Standard_Languages.HALFLING)
        );
        saveCharacter(clericDTO);

        // Druid Character
        MyCharactersDTO druidDTO = new MyCharactersDTO(
                null, "Druid Character", BasicRaces.GNOME, "Hermit", Alignment.NEUTRAL, 1,
                MainClasses.DRUID, "None", StatType.WISDOM, 30, 2, 15, 10, false, 2,
                ifDruid.getProficiencySavingThrows(), ifDruid.getProficienciesAndLanguages(),
                druidSkills, List.of(Standard_Languages.COMMON, Standard_Languages.GNOMISH)
        );
        saveCharacter(druidDTO);

        // Fighter Character
        MyCharactersDTO fighterDTO = new MyCharactersDTO(
                null, "Fighter Character", BasicRaces.HUMAN, "Soldier", Alignment.LAWFUL_NEUTRAL, 1,
                MainClasses.FIGHTER, "None", StatType.STRENGTH, 30, 2, 15, 10, false, 2,
                ifFighter.getProficiencySavingThrows(), ifFighter.getProficienciesAndLanguages(),
                fighterSkills, List.of(Standard_Languages.COMMON)
        );
        saveCharacter(fighterDTO);

        // Monk Character
        MyCharactersDTO monkDTO = new MyCharactersDTO(
                null, "Monk Character", BasicRaces.HUMAN, "Hermit", Alignment.LAWFUL_GOOD, 1,
                MainClasses.MONK, "None", StatType.DEXTERITY, 30, 2, 15, 10, false, 2,
                ifMonk.getProficiencySavingThrows(), ifMonk.getProficienciesAndLanguages(),
                monkSkills, List.of(Standard_Languages.COMMON)
        );
        saveCharacter(monkDTO);

        // Paladin Character
        MyCharactersDTO paladinDTO = new MyCharactersDTO(
                null, "Paladin Character", BasicRaces.HUMAN, "Knight", Alignment.LAWFUL_GOOD, 1,
                MainClasses.PALADIN, "None", StatType.CHARISMA, 30, 2, 15, 10, false, 2,
                ifPaladin.getProficiencySavingThrows(), ifPaladin.getProficienciesAndLanguages(),
                paladinSkills, List.of(Standard_Languages.COMMON, Standard_Languages.ELVISH)
        );
        saveCharacter(paladinDTO);

        // Ranger Character
        MyCharactersDTO rangerDTO = new MyCharactersDTO(
                null, "Ranger Character", BasicRaces.ELF, "Outlander", Alignment.NEUTRAL_GOOD, 1,
                MainClasses.RANGER, "None", StatType.DEXTERITY, 30, 2, 15, 10, false, 2,
                ifRanger.getProficiencySavingThrows(), ifRanger.getProficienciesAndLanguages(),
                rangerSkills, List.of(Standard_Languages.ELVISH, Standard_Languages.ORC)
        );
        saveCharacter(rangerDTO);

        // Rogue Character
        MyCharactersDTO rogueDTO = new MyCharactersDTO(
                null, "Rogue Character", BasicRaces.HALFLING, "Criminal", Alignment.CHAOTIC_NEUTRAL, 1,
                MainClasses.ROGUE, "None", StatType.DEXTERITY, 30, 2, 15, 10, false, 2,
                ifRogue.getProficiencySavingThrows(), ifRogue.getProficienciesAndLanguages(),
                rogueSkills, List.of(Standard_Languages.COMMON, Standard_Languages.DWARVISH)
        );
        saveCharacter(rogueDTO);

        // Sorcerer Character
        MyCharactersDTO sorcererDTO = new MyCharactersDTO(
                null, "Sorcerer Character", BasicRaces.TIEFLING, "Sage", Alignment.CHAOTIC_GOOD, 1,
                MainClasses.SORCERER, "None", StatType.CHARISMA, 30, 2, 15, 10, false, 2,
                ifSorcerer.getProficiencySavingThrows(), ifSorcerer.getProficienciesAndLanguages(),
                sorcererSkills, List.of(Standard_Languages.COMMON, Standard_Languages.INFERNAL)
        );
        saveCharacter(sorcererDTO);

        // Warlock Character
        MyCharactersDTO warlockDTO = new MyCharactersDTO(
                null, "Warlock Character", BasicRaces.HUMAN, "Charlatan", Alignment.NEUTRAL_EVIL, 1,
                MainClasses.WARLOCK, "None", StatType.CHARISMA, 30, 2, 15, 10, false, 2,
                ifWarlock.getProficiencySavingThrows(), ifWarlock.getProficienciesAndLanguages(),
                warlockSkills, List.of(Standard_Languages.COMMON, Standard_Languages.INFERNAL)
        );
        saveCharacter(warlockDTO);

        // Wizard Character
        MyCharactersDTO wizardDTO = new MyCharactersDTO(
                null, "Wizard Character", BasicRaces.GNOME, "Sage", Alignment.NEUTRAL_GOOD, 1,
                MainClasses.WIZARD, "None", StatType.INTELLIGENCE, 30, 2, 15, 10, false, 2,
                ifWizard.getProficiencySavingThrows(), ifWizard.getProficienciesAndLanguages(),
                wizardSkills, List.of(Standard_Languages.COMMON, Standard_Languages.GNOMISH)
        );
        saveCharacter(wizardDTO);
    }

    private void saveCharacter(MyCharactersDTO characterDTO) {
        MyCharacters character = createCharacterFromDTO(characterDTO);

        character.setProficiencyST(new Pair<>(characterDTO.getProficiencyST().getFirst(), characterDTO.getProficiencyST().getSecond()));

        // Handle other proficiencies and languages
        for (String proficiency : characterDTO.getOtherProficienciesAndLanguages()) {
            OtherProficiencyOrLanguage proficiencyEntity = new OtherProficiencyOrLanguage(proficiency);
            proficiencyEntity.setCharacter(character);
            character.addOtherProficiencyOrLanguage(proficiencyEntity);
            otherProficiencyOrLanguageRepository.save(proficiencyEntity);
        }

        // Handle skills
        for (Skills skill : characterDTO.getSkills()) {
            OtherProficiencyOrLanguage skillEntity = new OtherProficiencyOrLanguage(skill.name());
            skillEntity.setCharacter(character);
            character.addSkill(skillEntity);
            otherProficiencyOrLanguageRepository.save(skillEntity);
        }

        // Save the character
        MyCharacters savedCharacter = characterRepository.save(character);

        // Print the details for debugging
        System.out.println(savedCharacter);
        System.out.println("Proficiency Saving Throws: " + characterDTO.getProficiencyST().getFirst() + ", "
                + characterDTO.getProficiencyST().getSecond());
        System.out.println("Other Proficiencies and Languages: ");
        for (OtherProficiencyOrLanguage proficiency : savedCharacter.getOtherProficienciesAndLanguages()) {
            System.out.println(proficiency.getName());
        }
        System.out.println("Selected Skills: ");
        for (OtherProficiencyOrLanguage skill : savedCharacter.getSkills()) {
            System.out.println(skill.getName());
        }

        // Handling extras
        for (Standard_Languages extra : characterDTO.getExtras()) {
            System.out.println(extra.name());
        }
    }
}