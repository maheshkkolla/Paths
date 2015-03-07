import java.lang.*;
import java.util.*;

class PathRecords {
	
	static List<Path> paths = new ArrayList<Path>(); 

	public static void addNewPath(Path path) {
		paths.add(path);
	}	
	public static Boolean hasDirectPath(City from, City to) {
		return (paths.contains(new Path(from, to)) || paths.contains(new Path(to, from)));
	}
}