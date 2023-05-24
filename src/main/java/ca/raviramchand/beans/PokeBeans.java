package ca.raviramchand.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class contains variables that will hold information returned back from
 * the API call
 * 
 * queryName variable holds the user input from the form in input.html
 * 
 * @author Ravi Ramchand
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokeBeans {
	private Long ID;
	private String queryName;
	private String name;
	private int base_experience;
	// abilities has a Type of Abilities because the PokeAPI has the ability name
	// within an ability JSON Array
	private List<Abilities> abilities;
	private Sprites sprites;
	// types has a Type of Types because the PokeAPI has the type name within an
	// type JSON Array
	private List<Types> types;

	@Override
	public String toString() {
		return "ID: " + ID + ", name: " + name + " base_exp: " + base_experience + " ability: " + abilities
				+ " sprites: " + sprites + " type: " + types;
	}
}
