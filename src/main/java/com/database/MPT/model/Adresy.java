package com.database.MPT.model;

import com.database.MPT.repository.AdresyRepository;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@ToString(callSuper = true, includeFieldNames = true)
public class Adresy {
    @Id
    @Getter @Setter
    private int id_adresu;
    @Getter @Setter
    private String miasto;
    @Getter @Setter
    private String ulica;
    @Getter @Setter
    private String nr_budynku;
    @Getter @Setter
    private int id_poczty;

    public Adresy(String miasto, String ulica, String nr_budynku, int id_poczty) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_budynku = nr_budynku;
        this.id_poczty = id_poczty;
    }
}
