import java.lang.*;
import java.util.*;

public class Records {
	List<Path> allPaths = new ArrayList<Path>();
	List<City> allCities = new ArrayList<City>();

	public Boolean hasDirectPath(City from, City to) throws CityNotFoundException{
		if(!isCityPresent(from)) throw new CityNotFoundException(from.name);
		if(!isCityPresent(to)) throw new CityNotFoundException(to.name); 
		return (allPaths.contains(new Path(from, to)) || allPaths.contains(new Path(to, from)));
	}

	public void addCityToRecords(City city) {
		allCities.add(city);
	}

	public void addPath(City from, City to) {
		if(!isCityPresent(from)) addCityToRecords(from);
		if(!isCityPresent(to)) addCityToRecords(to);
		allPaths.add(new Path(from, to));
	}

	public Boolean isCityPresent(City city) {
		return allCities.contains(city);
	}


}

class CityNotFoundException extends Exception {
	String message ;
	CityNotFoundException(String city) {
		this.message = "No City names \""+city+"\" in Database";
	}
}