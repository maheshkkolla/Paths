import java.lang.*;
import java.util.*;

public class Records {
	List<Path> allPaths = new ArrayList<Path>();

	public Boolean hasDirectPath(City from, City to) {
		return allPaths.contains(new Path(from, to));
	}

	public void addPath(City from, City to) {
		allPaths.add(new Path(from, to));
	}


}