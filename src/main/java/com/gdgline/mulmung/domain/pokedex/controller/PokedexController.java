package com.gdgline.mulmung.domain.pokedex.controller;

import com.gdgline.mulmung.domain.pokedex.dto.*;
import com.gdgline.mulmung.domain.pokedex.service.PokedexService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pokedex")
public class PokedexController {
    private final PokedexService pokedexService;

    @Operation(
            summary = "도감 조회",
            description = "유저의 포켓몬 도감을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "도감 조회 성공"),
                    @ApiResponse(responseCode = "404", description = "도감을 찾을 수 없습니다.")
            }
    )
    @GetMapping
    public ResponseEntity<PokedexResponseDto> getPokedex(Authentication authentication) {
        return pokedexService.getPokedex(authentication);
    }


    @Operation(
            summary = "도감 업데이트",
            description = "새로 잡은 생물 리스트를 전달하여 도감에 업데이트합니다. 리스트에는 다음 생물중에서 선택: gardenEel, napoleonWrasse, arowana, blacktipReefShark, africanManatee, giantGrouper, smallClawedOtter, piranha, zebraShark, californiaSeaLion, clownfish, blackStingray, leatherbackSeaTurtle, humboldtPenguin",
            responses = {
                    @ApiResponse(responseCode = "200", description = "도감 업데이트 성공 \"pokemonStatus\": {\"gardenEel\": \"new\", \"clownfish\": \"old\"}", content = @Content(schema = @Schema(implementation = PokedexUpdateResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "생물 이름을 잘못 표기하신듯. \"ex)Invalid pokemon name: gardeneel\"", content = @Content(mediaType = "text/plain")),
                    @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음", content = @Content(mediaType = "text/plain"))
            }
    )
    @PostMapping("/update")
    public ResponseEntity<?> updatePokedex(@RequestBody PokedexUpdateRequestDto requestDto, Authentication authentication) {
        return pokedexService.updatePokedex(requestDto, authentication);
    }
}
