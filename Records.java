import java.lang.*;
import java.util.*;

public class Records {
	List<Path> allPaths = new ArrayList<Path>();
	List<City> allCities = new ArrayList<City>();

	public Boolean hasDirectPath(City from, City to) {
		return (allPaths.contains(new Path(from, to)) || allPaths.contains(new Path(to, from)));
	}

	public void addCityToRecords(String city) {
		allCities.add(new City(city));
	}

	public void addPath(String from, String to) {
		if(!isCityPresent(from)) addCityToRecords(from);
		if(!isCityPresent(to)) addCityToRecords(to);
		try {
			allPaths.add(new Path(getCityFromName(from), getCityFromName(to)));
		} catch(CityNotFoundException e) {

		}
	}

	public Boolean isCityPresent(String city) {
		return allCities.contains(new City(city));
	}

	public List<Path> getAllPathsFrom(City city) {
		List<Path> paths = new ArrayList<Path>();
		for (Path path: allPaths) {
			if(path.from.equals(city)) paths.add(path);
			// if(path.to.equals(city)) paths.add(path);			
		}
		return paths;
	}

	public Boolean hasDirectOrLinkedPath(City from, City to) {
		if(hasDirectPath(from, to)) return true;
		List<Path> pathsFrom = getAllPathsFrom(from);
		for (Path path: pathsFrom) {
			return hasDirectOrLinkedPath(path.to , to);
		}
		return false;
	}

	public Boolean hasPath(City from, City to) throws CityNotFoundException{
		return (hasDirectOrLinkedPath(from, to) || hasDirectOrLinkedPath(to, from));
	}

	public List<String> getDirectOrLinkedPath(City from, City to, List<String> wholePath) {
		if(hasDirectPath(from, to))	{
			wholePath.add(from.name);
			return wholePath;
		}
		List<Path> pathsFrom = getAllPathsFrom(from);
		for (Path path: pathsFrom) {
			wholePath.add(path.from.name);
			return getDirectOrLinkedPath(path.to , to, wholePath);
		}
		return null;
	}

	public List<String> getNormalPath(City from, City to) {
		List<String> pathListInStrings = new ArrayList<String>();
		pathListInStrings = getDirectOrLinkedPath(from, to, pathListInStrings);
		pathListInStrings.add(to.name);
		return pathListInStrings;
	}

	public List<String> getReversePath(City from, City to) {
		List<String> pathListInStrings = new ArrayList<String>();
		pathListInStrings = getDirectOrLinkedPath(to,from, pathListInStrings);
		pathListInStrings.add(from.name);
		List<String> resultList = new ArrayList<String>();
		for (int i = pathListInStrings.size()-1; i>=0 ;i--) {
			resultList.add(pathListInStrings.get(i));
		}
		return resultList;
	}

	public String getPathAsString(List<String> pathList) {
		String path = new String("");
		for (String cityInPath: pathList) {
			if(path.equals("")) path += cityInPath;
			else path = path + " -> " + cityInPath;
		}
		return path;
	}

	public String getPath(City from, City to) {
		if(from.equals(to)) return(from.name + " -> " + to.name);
		if(hasDirectOrLinkedPath(from, to))
			return getPathAsString(getNormalPath(from, to));
		return getPathAsString(getReversePath(from, to));
	}

	public City getCityFromName(String name) throws CityNotFoundException{
		for (City city: allCities) {
			if(city.name.equals(name)) return city;
		}
		throw new CityNotFoundException(name);
	}

}

class CityNotFoundException extends Exception {
	String message ;
	CityNotFoundException(String city) {
		this.message = "No City names \""+city+"\" in Database";
	}
}