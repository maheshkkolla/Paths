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
		travesedPath.add(from);
		if(hasDirectPath(from, to)) return true;
		List<Path> pathsFrom = getPathsFrom(from);
		for (Path path: pathsFrom) {
			if(!travesedPath.contains(path.to)){
				if(hasDirectOrLinkedPath(path.to , to, travesedPath)) return true;
			}	
		}
		return false;
	}

	public static Boolean hasPath(City from, City to) {
		List<City> travesedPath = new ArrayList<City>();
		return hasDirectOrLinkedPath(from, to, travesedPath);
	}	

}