package com.database.MPT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
