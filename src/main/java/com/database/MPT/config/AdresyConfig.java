package com.database.MPT.config;

import com.database.MPT.model.Adresy;
import com.database.MPT.repository.AdresyRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdresyConfig {

   /* @Bean
    CommandLineRunner commandLineRunner(AdresyRepository adresyRepository) {
        return args -> {
            Adresy nr1 = new Adresy(
                    "Czarna"
            );

            Adresy nr2 = new Adresy(
                    "Biala"
            );

            Adresy nr3 = new Adresy(
                    "Zielona"
            );

            Adresy nr4 = new Adresy(
                    "Brazowa"
            );

            Adresy nr5 = new Adresy(
                    "Gowniana"
            );

            adresyRepository.saveAll(
                    List.of(nr1, nr2, nr3, nr4, nr5)
            );
        };
    }*/
}
