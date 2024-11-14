package com.gdgline.mulmung.domain.pokedex.dto;

import com.gdgline.mulmung.domain.pokedex.entity.Pokedex;
import lombok.Getter;

@Getter
public class PokedexResponseDto {
    private final Boolean gardenEel;
    private final Boolean napoleonWrasse;
    private final Boolean arowana;
    private final Boolean blacktipReefShark;
    private final Boolean africanManatee;
    private final Boolean giantGrouper;
    private final Boolean smallClawedOtter;
    private final Boolean piranha;
    private final Boolean zebraShark;
    private final Boolean californiaSeaLion;
    private final Boolean clownfish;
    private final Boolean blackStingray;
    private final Boolean leatherbackSeaTurtle;
    private final Boolean humboldtPenguin;

    public PokedexResponseDto(Pokedex pokedex) {
        this.gardenEel = pokedex.getGardenEel();
        this.napoleonWrasse = pokedex.getNapoleonWrasse();
        this.arowana = pokedex.getArowana();
        this.blacktipReefShark = pokedex.getBlacktipReefShark();
        this.africanManatee = pokedex.getAfricanManatee();
        this.giantGrouper = pokedex.getGiantGrouper();
        this.smallClawedOtter = pokedex.getSmallClawedOtter();
        this.piranha = pokedex.getPiranha();
        this.zebraShark = pokedex.getZebraShark();
        this.californiaSeaLion = pokedex.getCaliforniaSeaLion();
        this.clownfish = pokedex.getClownfish();
        this.blackStingray = pokedex.getBlackStingray();
        this.leatherbackSeaTurtle = pokedex.getLeatherbackSeaTurtle();
        this.humboldtPenguin = pokedex.getHumboldtPenguin();
    }
}
