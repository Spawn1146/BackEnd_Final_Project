package com.ironhack.DnDCharacterSheet.Domain;

import com.ironhack.DnDCharacterSheet.Enum.*;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "MyCharacters")
public class MyCharacters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BasicRaces race;

    private String background;

    @Enumerated(EnumType.STRING)
    private Alignment alignment;

    private int level;

    @Enumerated(EnumType.STRING)
    private MainClasses mainClass;

    private String subClasses;

    @Enumerated(EnumType.STRING)
    private StatType statType;

    private int speed;
    private int initiative;
    private int armorClass;
    private int hitDice;
    private boolean inspiration;
    private int proficiencyBonus;

    @Transient
    private Pair<String, String> proficiencyST;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OtherProficiencyOrLanguage> otherProficienciesAndLanguages;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OtherProficiencyOrLanguage> skills;

    @ElementCollection
    @CollectionTable(name = "character_stats", joinColumns = @JoinColumn(name = "character_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "stat_value")
    private Map<StatType, Integer> stats = new HashMap<>();

    // Constructor
    public MyCharacters(String name, BasicRaces race, String background, Alignment alignment, int level,
                        MainClasses mainClass, String subClasses, StatType statType, int speed,
                        int initiative, int armorClass, int hitDice, boolean inspiration, int proficiencyBonus) {
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
        setSpeedBasedOnRace();
    }

    // Method to set speed based on the race
    private void setSpeedBasedOnRace() {
        if (race == BasicRaces.DWARF || race == BasicRaces.GNOME || race == BasicRaces.HALFLING) {
            this.speed = 25;
        } else {
            this.speed = 30;
        }
    }

    // Convenience methods
    public void addOtherProficiencyOrLanguage(OtherProficiencyOrLanguage proficiency) {
        otherProficienciesAndLanguages.add(proficiency);
        proficiency.setCharacter(this);
    }

    public void addSkill(OtherProficiencyOrLanguage skill) {
        skills.add(skill);
        skill.setCharacter(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyCharacters)) return false;
        MyCharacters character = (MyCharacters) o;
        return Objects.equals(getId(), character.getId()) && Objects.equals(getName(), character.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}