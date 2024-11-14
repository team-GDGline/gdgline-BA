package com.gdgline.mulmung.domain.pokedex.service;

import com.gdgline.mulmung.domain.pokedex.dto.*;
import com.gdgline.mulmung.domain.pokedex.entity.Pokedex;
import com.gdgline.mulmung.domain.pokedex.repository.PokedexRepository;
import com.gdgline.mulmung.domain.user.entity.User;
import com.gdgline.mulmung.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PokedexServiceImpl implements PokedexService {

    private final PokedexRepository pokedexRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<PokedexResponseDto> getPokedex(Authentication authentication) {
        String email = authentication.getName();
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            Pokedex pokedex = user.get().getPokedex();
            PokedexResponseDto responseDto = new PokedexResponseDto(pokedex);
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @Override
    public ResponseEntity<?> updatePokedex(PokedexUpdateRequestDto requestDto, Authentication authentication) {
        String email = authentication.getName();
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        Pokedex pokedex = user.get().getPokedex();
        Map<String, String> pokemonStatus = new HashMap<>();

        for (String pokemon : requestDto.getCaughtPokemons()) {
            switch (pokemon) {
                case "gardenEel" -> {
                    pokemonStatus.put(pokemon, pokedex.getGardenEel() ? "old" : "new");
                    pokedex.setGardenEel(true);
                }
                case "napoleonWrasse" -> {
                    pokemonStatus.put(pokemon, pokedex.getNapoleonWrasse() ? "old" : "new");
                    pokedex.setNapoleonWrasse(true);
                }
                case "arowana" -> {
                    pokemonStatus.put(pokemon, pokedex.getArowana() ? "old" : "new");
                    pokedex.setArowana(true);
                }
                case "blacktipReefShark" -> {
                    pokemonStatus.put(pokemon, pokedex.getBlacktipReefShark() ? "old" : "new");
                    pokedex.setBlacktipReefShark(true);
                }
                case "africanManatee" -> {
                    pokemonStatus.put(pokemon, pokedex.getAfricanManatee() ? "old" : "new");
                    pokedex.setAfricanManatee(true);
                }
                case "giantGrouper" -> {
                    pokemonStatus.put(pokemon, pokedex.getGiantGrouper() ? "old" : "new");
                    pokedex.setGiantGrouper(true);
                }
                case "smallClawedOtter" -> {
                    pokemonStatus.put(pokemon, pokedex.getSmallClawedOtter() ? "old" : "new");
                    pokedex.setSmallClawedOtter(true);
                }
                case "piranha" -> {
                    pokemonStatus.put(pokemon, pokedex.getPiranha() ? "old" : "new");
                    pokedex.setPiranha(true);
                }
                case "zebraShark" -> {
                    pokemonStatus.put(pokemon, pokedex.getZebraShark() ? "old" : "new");
                    pokedex.setZebraShark(true);
                }
                case "californiaSeaLion" -> {
                    pokemonStatus.put(pokemon, pokedex.getCaliforniaSeaLion() ? "old" : "new");
                    pokedex.setCaliforniaSeaLion(true);
                }
                case "clownfish" -> {
                    pokemonStatus.put(pokemon, pokedex.getClownfish() ? "old" : "new");
                    pokedex.setClownfish(true);
                }
                case "blackStingray" -> {
                    pokemonStatus.put(pokemon, pokedex.getBlackStingray() ? "old" : "new");
                    pokedex.setBlackStingray(true);
                }
                case "leatherbackSeaTurtle" -> {
                    pokemonStatus.put(pokemon, pokedex.getLeatherbackSeaTurtle() ? "old" : "new");
                    pokedex.setLeatherbackSeaTurtle(true);
                }
                case "humboldtPenguin" -> {
                    pokemonStatus.put(pokemon, pokedex.getHumboldtPenguin() ? "old" : "new");
                    pokedex.setHumboldtPenguin(true);
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid pokemon name: " + pokemon);
                }
            }
        }


        pokedexRepository.save(pokedex);
        PokedexUpdateResponseDto responseDto = new PokedexUpdateResponseDto();
        responseDto.setPokemonStatus(pokemonStatus);

        return ResponseEntity.ok(responseDto);
    }
}
