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

	public List<Path> getAllPathsFrom(City city) {
		List<Path> paths = new ArrayList<Path>();
		for (Path path: allPaths) {
			if(path.from.equals(city)) paths.add(path);
			// if(path.to.equals(city)) paths.add(path);			
		}
		return paths;
	}

	public Boolean hasDirectOrLinkedPath(City from, City to) throws CityNotFoundException {
		if(hasDirectPath(from, to)) return true;
		List<Path> pathsFrom = getAllPathsFrom(from);
		for (Path path: pathsFrom) {
			return hasPath(path.to , to);
		}
		return false;
	}

	public Boolean hasPath(City from, City to) throws CityNotFoundException{
		return (hasDirectOrLinkedPath(from, to) || hasDirectOrLinkedPath(to, from));
	}

}

class CityNotFoundException extends Exception {
	String message ;
	CityNotFoundException(String city) {
		this.message = "No City names \""+city+"\" in Database";
	}
}