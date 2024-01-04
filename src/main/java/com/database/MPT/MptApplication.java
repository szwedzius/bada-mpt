package com.database.MPT;
import com.database.MPT.model.Poczty;
import com.database.MPT.repository.PocztyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MptApplication /*implements CommandLineRunner*/ {
	/*@Autowired
	private PocztyRepository a;*/

	public static void main(String[] args) {
		SpringApplication.run(MptApplication.class, args);
	}


	/*@Override
	public void run(String... args) throws Exception {
		Poczty pczt = new Poczty("00-009");
		a.save(pczt);
	}*/

}
