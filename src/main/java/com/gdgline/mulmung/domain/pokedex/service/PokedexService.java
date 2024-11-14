package com.gdgline.mulmung.domain.pokedex.service;

import com.gdgline.mulmung.domain.pokedex.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface PokedexService {
    ResponseEntity<PokedexResponseDto> getPokedex(Authentication authentication);
    ResponseEntity<?> updatePokedex(PokedexUpdateRequestDto requestDto, Authentication authentication);
}
