package com.gdgline.mulmung.domain.pokedex.repository;

import com.gdgline.mulmung.domain.pokedex.entity.Pokedex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokedexRepository extends JpaRepository<Pokedex, Long> {
}
