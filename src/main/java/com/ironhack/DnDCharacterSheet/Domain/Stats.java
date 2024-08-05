package com.ironhack.DnDCharacterSheet.Domain;

import com.ironhack.DnDCharacterSheet.Enum.StatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stats")
@Proxy(lazy = false)
public class Stats {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long statsId;

    @ElementCollection
    @CollectionTable(name = "stat_values", joinColumns = @JoinColumn(name = "stats_id"))
    @MapKeyColumn(name = "stat_type")
    @Column(name = "stat_value")
    private Map<StatType, Integer> values = new HashMap<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "stats")
    private Set<MyCharacters> characters;

    // Default constructor
    public Stats() {
    }

    // Constructor with Map values
    public Stats(Map<StatType, Integer> values) {
        this.values = values;
    }

    // Getters
    public Long getStatsId() {
        return statsId;
    }
    public Map<StatType, Integer> getValues() {
        return values;
    }
    public Set<MyCharacters> getCharacters() {
        return characters;
    }

    // Setters
    public void setStatsId(Long statsId) {
        this.statsId = statsId;
    }
    public void setValues(Map<StatType, Integer> values) {
        this.values = values;
    }
    public void setCharacters(Set<MyCharacters> characters) {
        this.characters = characters;
    }

    // Convenience methods for individual stats
    public Integer getStatValue(StatType statType) {
        return values.get(statType);
    }
    public void setStatValue(StatType statType, Integer value) {
        values.put(statType, value);
    }

    // Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stats)) return false;
        Stats stats = (Stats) o;
        return Objects.equals(getStatsId(), stats.getStatsId()) &&
                Objects.equals(getValues(), stats.getValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatsId(), getValues());
    }

    // toString
    @Override
    public String toString() {
        return "Stats{" +
                "statsId=" + statsId +
                ", values=" + values +
                ", characters=" + characters +
                '}';
    }
}