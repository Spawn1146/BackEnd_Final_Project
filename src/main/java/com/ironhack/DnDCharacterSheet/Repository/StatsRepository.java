package com.ironhack.DnDCharacterSheet.Repository;

import com.ironhack.DnDCharacterSheet.Domain.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ironhack.DnDCharacterSheet.Service.Pair;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
    // Custom query methods (if needed) can be added here
}