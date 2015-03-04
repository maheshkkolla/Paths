import java.util.*;
import java.lang.*;
import java.io.*;
public class Paths {
	public static void  main(String[] args) {
		Records records = new Records();
		City city1 = new City(args[0]);
		City city2 = new City(args[1]);
		records.addPath(new City("Banglore"), new City("Singapore"));
		System.out.println(records.hasDirectPath(city1, city2));
	}
}




// class City {
// 	List<String> directTo = new ArrayList<String>();
// 	String name;
// 	public City(String name){
// 		this.name = name;
// 	}
// 	public void addDirectPathTo(String to) {
// 		directTo.add(to);
// 	}
// }

// class CityNotFoundException extends Exception {
// 	String message ;
// 	CityNotFoundException(String city) {
// 		this.message = "No City names \""+city+"\" in Database";
// 		// super(this.message);
// 	}
// }

// class Paths  {
// 	Map<String, City> allCities = new Hashtable<String, City>();

// 	public Paths(String[] cities) {
// 		for (String city: cities) {
// 			allCities.put(city, new City(city));
// 		}
// 	}

// 	public void addDirectPath(String from, String to) {
// 		allCities.get(from).addDirectPathTo(to);
// 		allCities.get(to).addDirectPathTo(from);
// 	}

// 	public Boolean hasDirectPath(String from, String to){
// 		City fromCity = allCities.get(from);
// 		return fromCity.directTo.contains(to); 
// 	}

// 	public Boolean isCity(String city) {
// 		if(allCities.get(city) != null) return true;
// 		return false;
// 	}
// 	public void addDirectPaths(String[][] directPaths) {
// 		for (String[] directPath: directPaths ) {
// 			this.addDirectPath(directPath[0], directPath[1]);
// 		}
// 	}
// 	public Boolean areCities(String city1, String city2) {
// 		Boolean city1Present = isCity(city1);
// 		Boolean city2Present = isCity(city2);  
// 		// if(!city1Present) System.out.println("No City names \""+city1+"\" in Database");
// 		// if(!city2Present) System.out.println("No City names \""+city2+"\" in Database");
// 		return(city1Present && city2Present); 
// 	}

// 	public Boolean trackThePath(String from, String to, List<String> path) {
// 		path.add(from);
// 		if(this.hasDirectPath(from, to)) return true;
// 		for (String city: allCities.get(from).directTo) {
// 			if(!path.contains(city)) {
// 				if(trackThePath(city, to, path)) return true;
// 			}
// 		}
// 		return false;
// 	}

// 	public Boolean hasPath(String from, String to) {
// 		List<String> path = new ArrayList<String>();
// 		return this.trackThePath(from, to, path);
// 	}

// 	public String getPath(String from, String to) throws CityNotFoundException {
// 		if(!isCity(from)) throw new CityNotFoundException(from);
// 		if(!isCity(to)) throw new CityNotFoundException(to);
// 		List<String> path = new ArrayList<String>();
// 		if(! this.trackThePath(from, to, path)) return "false";
// 		String wholePath = new String();
// 		for (String city: path) {
// 			wholePath = wholePath + city + " -> ";
// 		}
// 		wholePath += to;
// 		return wholePath;
// 	}


	
// }


