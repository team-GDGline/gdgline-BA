package com.gdgline.mulmung.domain.pokedex.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokedexUpdateRequestDto {
    private List<String> caughtPokemons;
}