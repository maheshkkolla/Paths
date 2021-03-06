import java.lang.*;
import java.util.*;

class PathRecords {
	
	static List<Path> paths = new ArrayList<Path>(); 

	public static void addNewPath(Path path) {
		paths.add(path);
	}	
	public static Boolean hasDirectPath(City from, City to) {
		return (paths.contains(new Path(from, to)));
	}

	public static List<Path> getPathsFrom(City city) {
		List<Path> pathsFrom = new ArrayList<Path>();
		for (Path path: paths) {
			if(path.from.equals(city)) pathsFrom.add(path);

		}
		return pathsFrom;
	}

	public static Boolean hasDirectOrLinkedPath(City from, City to, List<City> travesedPath) {
		if(hasDirectPath(from, to)){
			travesedPath.add(to);
			return true;
		} 
		List<Path> pathsFrom = getPathsFrom(from);
		for (Path path: pathsFrom) {
			if(!travesedPath.contains(path.to)){
				travesedPath.add(path.to);	
				if(hasDirectOrLinkedPath(path.to , to, travesedPath)){
					return true;
				} else {
					travesedPath.remove(travesedPath.size() -1);
				}
			}	
		}
		return false;
	}

	public static Boolean hasPath(City from, City to) {
		List<City> travesedPath = new ArrayList<City>();
		return hasDirectOrLinkedPath(from, to, travesedPath);
	}	

	// public static List<City> findDirectOrLinkedPath(City from, City to, List<City> travesedPath) {
	// 	if(hasDirectPath(from, to)) {
	// 		travesedPath.add(to);
	// 		return travesedPath;
	// 	}
	// 	List<Path> pathsFrom = getPathsFrom(from);
	// 	for (Path path: pathsFrom) {
	// 		if(!travesedPath.contains(path.to)){
	// 			travesedPath.add(path.to);
	// 			if(findDirectOrLinkedPath(path.to , to, travesedPath) != null) return travesedPath;
	// 		}	
	// 	}
	// 	return null;
	// }

	public static String findPath(City from, City to) {
		if(from.equals(to)) return from.toString() + " -> " + to.toString();
		List<City> pathBetweenCities = new ArrayList<City>();
		pathBetweenCities.add(	from);
		hasDirectOrLinkedPath(from,to,pathBetweenCities);
		String resultPath = new String();
		for (City city: pathBetweenCities ) {
			if(!resultPath.equals("")) resultPath += " -> ";
			resultPath += city.toString();
		}
		return resultPath;
	}

}