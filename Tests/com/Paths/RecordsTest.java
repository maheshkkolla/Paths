//package com.Paths;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
//import java.util.*;
//
//public class RecordsTest {
//	@Test
//	public void isCityPresent_returns_true_if_the_city_is_present_in_the_records() {
//		Records records = new Records();
//		records.addCityToRecords("Banglore");
//		assertTrue(records.isCityPresent("Banglore"));
//	}
//	@Test
//	public void isCityPresent_returns_false_if_the_city_is_not_present_in_the_records() {
//		Records records = new Records();
//		assertFalse(records.isCityPresent("Banglore"));
//	}
//	@Test
//	public void hasDirectPath_returns_true_if_two_cities_has_direct_path() {
//		Records records = new Records();
//		records.addPath("Banglore", "Singapore");
//		try{
//			assertTrue(records.hasDirectPath(records.getCityFromName("Banglore"),records.getCityFromName("Singapore")));
//		} catch(Exception e){
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void hasDirectPath_returns_false_if_two_cities_doesnt_have_the_direct_path() {
//		Records records = new Records();
//		records.addCityToRecords("Banglore");
//		records.addCityToRecords("Singapore");
//		try{
//			assertFalse(records.hasDirectPath(records.getCityFromName("Banglore"),records.getCityFromName("Banglore")));
//		} catch(Exception e) {
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void hasDirectPath_gives_exception_if_the_city_not_present_in_records() {
//		Records records = new Records();
//		try{
//			records.hasDirectPath(records.getCityFromName("Banglore"), records.getCityFromName("Singapore"));
//		} catch(CityNotFoundException e) {
//			assertEquals(e.message, "No City names \"Banglore\" in Database");
//		}
//	}
//	@Test
//	public void hasDirectPath_returns_true_even_if_records_contains_reverse_path() {
//		Records records = new Records();
//		records.addPath("Banglore", "Singapore");
//		try {
//			assertTrue(records.hasDirectPath(records.getCityFromName("Singapore"), records.getCityFromName("Banglore")));
//		} catch(CityNotFoundException e) {
//			assertFalse(true);
//		}
//	}
//	@Test
//	public void hasPath_returns_true_if_the_two_cities_contains_direct_or_linked_paths() {
//		Records records = new Records();
// 		records.addPath("Banglore", "Singapore");
//		records.addPath("Singapore", "Seoul");
//		try{
//			assertTrue(records.hasPath(records.getCityFromName("Banglore"),records.getCityFromName("Seoul")));
//		}catch(CityNotFoundException e){
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void hasPath_returns_false_if_the_two_cities_doesnt_contains_direct_or_linked_paths() {
//		Records records = new Records();
//		records.addCityToRecords("Seoul");
// 		records.addPath("Banglore", "Singapore");
//		try{
//			assertFalse(records.hasPath(records.getCityFromName("Banglore"),records.getCityFromName("Seoul")));
//		}catch(CityNotFoundException e){
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void hasPath_returns_true_if_the_two_cities_contains_direct_or_linked_paths_in_reverse_also() {
//		Records records = new Records();
// 		records.addPath("Banglore", "Singapore");
//		records.addPath("Singapore", "Seoul");
//		try{
//			assertTrue(records.hasPath(records.getCityFromName("Seoul"),records.getCityFromName("Banglore")));
//		}catch(CityNotFoundException e){
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void getPath_returns_directPath_between_two_cities() {
//		Records records = new Records();
//		records.addPath("Banglore", "Singapore");
//		try{
//			String path = records.getPath(records.getCityFromName("Banglore"),records.getCityFromName("Singapore"));
//			assertEquals(path, "Banglore -> Singapore");
//		} catch(CityNotFoundException e) {
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void getPath_returns_directPath_between_two_cities_in_even_input_in_reverse_order() {
//		Records records = new Records();
//		records.addPath("Banglore", "Singapore");
//		try{
//			String path = records.getPath(records.getCityFromName("Singapore"),records.getCityFromName("Banglore"));
//			assertEquals(path, "Singapore -> Banglore");
//		} catch(CityNotFoundException e) {
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void getPath_returns_Path_between_two_cities() {
//		Records records = new Records();
//		records.addPath("Banglore", "Singapore");
//		records.addPath("Singapore","Seoul");
//		try{
//			String path = records.getPath(records.getCityFromName("Banglore"),records.getCityFromName("Seoul"));
//			assertEquals(path, "Banglore -> Singapore -> Seoul");
//		} catch(CityNotFoundException e) {
//			assertTrue(false);
//		}
//	}
//	@Test
//	public void getPath_returns_path_between_two_cities_in_even_input_in_reverse_order() {
//		Records records = new Records();
//		records.addPath("Banglore", "Singapore");
//		records.addPath("Singapore","Seoul");
//		try{
//			String path = records.getPath(records.getCityFromName("Seoul"),records.getCityFromName("Banglore"));
//			assertEquals(path, "Seoul -> Singapore -> Banglore");
//		} catch(CityNotFoundException e) {
//			assertTrue(false);
//		}
//	}
//
//
//}