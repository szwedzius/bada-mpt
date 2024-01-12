package com.database.MPT.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter @Setter
public class PracownicyDto {
    private int id_pracownika;
    private Date koniec_umowy;
    private int id_biura;
    private int id_zajezdni;
    private int id_stanowiska;

    public PracownicyDto(int id_pracownika, Date koniec_umowy) {
        this.id_pracownika = id_pracownika;
        this.koniec_umowy = koniec_umowy;
    }
}
