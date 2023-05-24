package ca.raviramchand.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import ca.raviramchand.beans.PokeBeans;
import ca.raviramchand.beans.Types;

/**
 * This program uses the PokeApi to search for a Pokemon entered in by the user.
 * The program will return an image, the ID, base experience, type, and ability
 * 
 * @author Ravi Ramchand
 *
 */

@Controller
public class PokeController {

	// Pokeapi URL
	private String url = "https://pokeapi.co/api/v2/pokemon/";

	/**
	 * This method executes when the user navigates to the root of this webpage and
	 * has a input box for a Pokemon
	 * 
	 * @param model used to send an instance of the PokeBeans class to the index
	 *              page
	 * @return index page to the user
	 */
	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("pokeBeans", new PokeBeans());
		return "index.html";
	}

	/**
	 * This method is executed after the user inputs a Pokemon name and hits the
	 * "Find Pokemon Button". It will query the PokeAPI for that Pokemon name and
	 * return the needed information
	 * 
	 * @param restTemplate is used to query the PokeAPI with the user inputed
	 *                     Pokemon
	 * @param pokeBeans    an object that is sent to this method with the user input
	 *                     from index.html
	 * @param model        send index.html a blank object for use again later on
	 * @return pokemonStats.html page with the information about the queried Pokemon
	 */
	@PostMapping("/getPokemon")
	public String getPokemon(RestTemplate restTemplate, @ModelAttribute PokeBeans pokeBeans, Model model) {
		model.addAttribute("pokeBeans", new PokeBeans());

		// Save user input Pokemon into queryName
		String queryName = pokeBeans.getQueryName();
		// Make queryName lowercase as all Pokemon in PokemonAPI is lowercase
		queryName = queryName.toLowerCase();

		// API call
		ResponseEntity<PokeBeans> resp = restTemplate.getForEntity(url + queryName, PokeBeans.class);

		System.out.println(resp.getBody());

		// Send in API information to pokemonStats.html
		model.addAttribute("pokemon", resp.getBody());
		// Send in image from API to pokemonStats.html
		model.addAttribute("pokemonImage", resp.getBody().getSprites().getFront_default());

		for (Types p : resp.getBody().getTypes()) {
			System.out.println(p);
		}

		return "pokemonStats.html";
	}

}
