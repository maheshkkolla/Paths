import java.util.*;

class City {
	List<String> directTo = new ArrayList<String>();
	String name;
	public City(String name){
		this.name = name;
	}
	public void addDirectPathTo(String to) {
		directTo.add(to);
	}
}

public class Paths  {
	Map<String, City> allCities = new Hashtable<String, City>();

	public Paths(String[] cities) {
		for (String city: cities) {
			allCities.put(city, new City(city));
		}
	}

	public void addDirectPath(String from, String to) {
		allCities.get(from).addDirectPathTo(to);
		allCities.get(to).addDirectPathTo(from);
	}

	public Boolean hasDirectPath(String from, String to){
		City fromCity = allCities.get(from);
		return fromCity.directTo.contains(to); 
	}

	public Boolean isCity(String city) {
		if(allCities.get(city) != null) return true;
		return false;
	}
	public void addDirectPaths(String[][] directPaths) {
		for (String[] directPath: directPaths ) {
			this.addDirectPath(directPath[0], directPath[1]);
		}
	}
	public Boolean areCities(String city1, String city2) {
		Boolean city1Present = isCity(city1);
		Boolean city2Present = isCity(city2);  
		if(!city1Present) System.out.println("No City names \""+city1+"\" in Database");
		if(!city2Present) System.out.println("No City names \""+city2+"\" in Database");
		return(city1Present && city2Present); 
	}

	public Boolean trackThePath(String from, String to, List<String> path) {
		Boolean result = false;
		if(!path.contains(from)) {
			if(this.hasDirectPath(from, to)) return true;
			path.add(from);
			for (String city: allCities.get(from).directTo) {
				result = trackThePath(city, to, path);		
			}
		}
		return result;
	}

	public Boolean hasPath(String from, String to) {
		List<String> path = new ArrayList<String>();
		return this.trackThePath(from, to, path);
	}


	public static void  main(String[] args) {
		String[] cities = {"Banglore","Singapore","Seoul","Beijing","Tokyo","Dubai"};
		Paths paths = new Paths(cities);
		String[][] directPaths = new String[][] { {"Banglore", "Singapore"}, {"Singapore","Seoul"},
			{"Singapore","Dubai"}, {"Seoul","Beijing"}, {"Beijing","Tokyo"}
		};
		paths.addDirectPaths(directPaths);
		if(paths.areCities(args[0], args[1])) {
			Boolean a = paths.hasDirectPath(args[0], args[1]);
			System.out.println(a);
		}	
	}	
}

