package com.database.MPT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@ToString(callSuper = true,includeFieldNames = true)
@Getter @Setter
public class Pracownicy {
    @Id
    private int id_pracownika;
    private String imie;
    private String nazwisko;
    private Date data_urodzenia;
    private String pesel;
    private char plec;
    private String nr_konta;
    private Date koniec_umowy;
    private int id_biura;
    private int id_zajezdni;
    private int id_adresu;
    private int id_stanowiska;

    public Pracownicy(String imie, String nazwisko, Date data_urodzenia, String pesel,
                      char plec, String nr_konta, Date koniec_umowy, int id_biura, int id_zajezdni,
                      int id_adresu, int id_stanowiska) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.plec = plec;
        this.nr_konta = nr_konta;
        this.koniec_umowy = koniec_umowy;
        this.id_biura = id_biura;
        this.id_zajezdni = id_zajezdni;
        this.id_adresu = id_adresu;
        this.id_stanowiska = id_stanowiska;
    }
}
