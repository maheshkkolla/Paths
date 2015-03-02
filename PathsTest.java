import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


public class PathsTest {
	@Test
	public void isCity_returns_true_if_Banglore_present_in_the_database(){
		String[] cities = {"Banglore","Singapore"};
		Paths paths = new Paths(cities);
		Boolean cityPresent = paths.isCity("Banglore");
		assertEquals(cityPresent, true);
	}
	@Test
	public void isCity_returns_false_if_Chennai_present_in_the_database(){
		String[] cities = {"Banglore","Singapore"};
		Paths paths = new Paths(cities);
		Boolean cityPresent = paths.isCity("Chennai");
		assertEquals(cityPresent, false);
	}
	@Test
	public void addDirectPath_adds_direct_path_between_Banglore_and_Singapore() {
		String[] cities = {"Banglore","Singapore"};
		Paths paths = new Paths(cities);
		paths.addDirectPath("Banglore","Singapore");
		Boolean has = paths.hasDirectPath("Banglore","Singapore");
		assertEquals(has, true);
	}
	@Test
	public void hasDirectPath_returns_true_for_Banglore_and_Singapore() {
		String[] cities = {"Banglore","Singapore"};
		Paths paths = new Paths(cities);
		paths.addDirectPath("Banglore","Singapore");
		Boolean has = paths.hasDirectPath("Banglore","Singapore");
		assertEquals(has, true);
	}
	@Test
	public void hasDirectPath_returns_false_for_Banglore_and_Tokyo() {
		String[] cities = {"Banglore","Singapore","Tokyo"};
		Paths paths = new Paths(cities);
		paths.addDirectPath("Banglore","Singapore");
		Boolean has = paths.hasDirectPath("Banglore","Tokyo");
		assertEquals(has, false);
	}
	@Test
	public void hasDirectPath_returns_true_for_Singapore_and_Banglore_reverese_also() {
		String[] cities = {"Banglore","Singapore"};
		Paths paths = new Paths(cities);
		paths.addDirectPath("Banglore","Singapore");
		Boolean has = paths.hasDirectPath("Singapore","Banglore");
		assertEquals(has, true);
	}
	@Test
	public void hasPath_returns_true_for_Banglore_and_Tokyo() {
		String[] cities = {"Banglore","Singapore","Tokyo"};
		Paths paths = new Paths(cities);
		paths.addDirectPath("Banglore","Singapore");
		paths.addDirectPath("Singapore","Tokyo");
		Boolean has = paths.hasPath("Banglore","Tokyo");
		assertEquals(has,true);
	}
	@Test
	public void hasPath_returns_false_for_Banglore_and_Beijing() {
		String[] cities = {"Banglore","Singapore","Tokyo","Beijing"};
		Paths paths = new Paths(cities);
		paths.addDirectPath("Banglore","Singapore");
		paths.addDirectPath("Singapore","Tokyo");
		Boolean has = paths.hasPath("Banglore","Beijing");
		assertEquals(has,false);
	}
	@Test
	public void hasPath_returns_true_for_Banglore_and_Chennai() {
		String[] cities = {"Banglore","Singapore","Tokyo","Chennai"};
		Paths paths = new Paths(cities);
		paths.addDirectPath("Banglore","Singapore");
		paths.addDirectPath("Singapore","Tokyo");
		paths.addDirectPath("Tokyo","Chennai");
		Boolean has = paths.hasPath("Banglore","Chennai");
		assertEquals(has,true);
	}
}