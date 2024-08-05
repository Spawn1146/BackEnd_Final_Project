package com.ironhack.DnDCharacterSheet.Domain;

import jakarta.persistence.*;
import com.ironhack.DnDCharacterSheet.Service.Pair;

@Entity
@Table(name = "otherProficienciesAndLanguages")
public class OtherProficiencyOrLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private MyCharacters character;

    // No-args constructor
    public OtherProficiencyOrLanguage() {}

    // Constructor with name only
    public OtherProficiencyOrLanguage(String name) {
        this.name = name;
    }

    // Constructor with all fields
    public OtherProficiencyOrLanguage(String name, MyCharacters character) {
        this.name = name;
        this.character = character;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public MyCharacters getCharacter() {
        return character;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCharacter(MyCharacters character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "OtherProficiencyOrLanguage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", character=" + (character != null ? character.getName() : "null") +
                '}';
    }
}