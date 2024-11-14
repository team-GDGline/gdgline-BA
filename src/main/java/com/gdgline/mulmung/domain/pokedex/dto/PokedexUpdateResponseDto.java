package com.gdgline.mulmung.domain.pokedex.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class PokedexUpdateResponseDto {
    private Map<String, String> pokemonStatus; // {"gardenEel": "new", "clownfish": "old"}
}