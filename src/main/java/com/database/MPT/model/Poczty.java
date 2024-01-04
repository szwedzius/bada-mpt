package com.database.MPT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@ToString(callSuper=true, includeFieldNames=true)
public class Poczty {
    @Id
    @Getter @Setter
    private int id_poczty;
    @Getter @Setter
    private String kod_pocztowy;
    public Poczty(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }
}
