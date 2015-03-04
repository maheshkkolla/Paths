import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class RecordsTest {
	@Test
	public void isCityPresent_returns_true_if_the_city_is_present_in_the_records() {
		Records records = new Records();
		records.addCityToRecords(new City("Banglore"));
		assertTrue(records.isCityPresent(new City("Banglore")));
	}
	@Test
	public void isCityPresent_returns_false_if_the_city_is_not_present_in_the_records() {
		Records records = new Records();
		assertFalse(records.isCityPresent(new City("Banglore")));
	}
	@Test
	public void hasDirectPath_returns_true_if_two_cities_has_direct_path() {
		Records records = new Records();
		records.addPath(new City("Banglore"), new City("Singapore"));
		try{
			assertTrue(records.hasDirectPath(new City("Banglore"), new City("Singapore")));	
		} catch(Exception e){
			assertTrue(false);
		}
	}
	@Test
	public void hasDirectPath_returns_false_if_two_cities_doesnt_have_the_direct_path() {
		Records records = new Records();
		records.addCityToRecords(new City("Banglore"));
		records.addCityToRecords(new City("Singapore"));
		try{
			assertFalse(records.hasDirectPath(new City("Banglore"), new City("Banglore")));
		} catch(Exception e) {
			assertTrue(false);
		}
	} 
	@Test
	public void hasDirectPath_gives_exception_if_the_city_not_present_in_records() {
		Records records = new Records();
		try{
			records.hasDirectPath(new City("Banglore"), new City("Singapore"));
		} catch(CityNotFoundException e) {
			assertEquals(e.message, "No City names \"Banglore\" in Database");
		}
	}
	@Test
	public void hasDirectPath_returns_true_even_if_records_contains_reverse_path() {
		Records records = new Records();
		records.addPath(new City("Banglore"), new City("Singapore"));
		try {
			assertTrue(records.hasDirectPath(new City("Singapore"), new City("Banglore")));
		} catch(CityNotFoundException e) {
			assertFalse(true);
		}
	}
	@Test
	public void hasPath_returns_true_if_the_two_cities_contains_direct_or_linked_paths() {
		Records records = new Records();
		City banglore = new City("Banglore");
		City singapore = new City("Singapore");
		City seoul = new City("Seoul");
 		records.addPath(banglore, singapore);
		records.addPath(singapore, seoul);
		try{
			assertTrue(records.hasPath(banglore, seoul));
		}catch(CityNotFoundException e){
			assertTrue(false);
		}
	}
	@Test
	public void hasPath_returns_false_if_the_two_cities_doesnt_contains_direct_or_linked_paths() {
		Records records = new Records();
		City banglore = new City("Banglore");
		City singapore = new City("Singapore");
		City seoul = new City("Seoul");
		records.addCityToRecords(seoul);
 		records.addPath(banglore, singapore);
		try{
			assertFalse(records.hasPath(banglore, seoul));
		}catch(CityNotFoundException e){
			assertTrue(false);
		}
	}
	@Test
	public void hasPath_returns_true_if_the_two_cities_contains_direct_or_linked_paths_in_reverse_also() {
		Records records = new Records();
		City banglore = new City("Banglore");
		City singapore = new City("Singapore");
		City seoul = new City("Seoul");
 		records.addPath(banglore, singapore);
		records.addPath(singapore, seoul);
		try{
			assertTrue(records.hasPath(seoul, banglore));
		}catch(CityNotFoundException e){
			assertTrue(false);
		}
	}


}