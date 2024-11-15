package com.gdgline.mulmung.domain.pokedex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "POKEDEX")
public class Pokedex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "garden_eel")
    @Builder.Default
    private Boolean gardenEel = false;

    @Column(name = "napoleon_wrasse")
    @Builder.Default
    private Boolean napoleonWrasse = false;

    @Column(name = "arowana")
    @Builder.Default
    private Boolean arowana = false;

    @Column(name = "blacktip_reef_shark")
    @Builder.Default
    private Boolean blacktipReefShark = false;

    @Column(name = "african_manatee")
    @Builder.Default
    private Boolean africanManatee = false;

    @Column(name = "giant_grouper")
    @Builder.Default
    private Boolean giantGrouper = false;

    @Column(name = "small_clawed_otter")
    @Builder.Default
    private Boolean smallClawedOtter = false;

    @Column(name = "piranha")
    @Builder.Default
    private Boolean piranha = false;

    @Column(name = "zebra_shark")
    @Builder.Default
    private Boolean zebraShark = false;

    @Column(name = "california_sea_lion")
    @Builder.Default
    private Boolean californiaSeaLion = false;

    @Column(name = "clownfish")
    @Builder.Default
    private Boolean clownfish = false;

    @Column(name = "black_stingray")
    @Builder.Default
    private Boolean blackStingray = false;

    @Column(name = "leatherback_sea_turtle")
    @Builder.Default
    private Boolean leatherbackSeaTurtle = false;

    @Column(name = "humboldt_penguin")
    @Builder.Default
    private Boolean humboldtPenguin = false;
}
