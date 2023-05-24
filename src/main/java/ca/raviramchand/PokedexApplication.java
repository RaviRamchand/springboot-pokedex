package ca.raviramchand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This program uses the PokeApi to search for a Pokemon entered in by the user.
 * The program will return an image, the ID, base experience, type, and ability
 * 
 * @author Ravi Ramchand
 *
 */
@SpringBootApplication
public class PokedexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}

}
