package com.Paths;

import java.lang.*;
import java.util.*;

class PathRecords {
	
	static List<Path> paths = new ArrayList<Path>();

	public static void addNewPath(Path path) {
		paths.add(path);
	}


	public static Boolean hasDirectPath(City from, City to) {
		return (paths.contains(new Path(from, to, null,0))) || (paths.contains(new Path(to, from, null,0)));
	}

	public static List<Path> getPathsFrom(City city) {
		List<Path> pathsFrom = new ArrayList<Path>();
		for (Path path: paths) {
			if(path.from.equals(city)) pathsFrom.add(path);

		}
		return pathsFrom;
	}


    public static List<String> findAllPaths(City from, City to){
        if(from.equals(to) || hasDirectPath(from, to))
            return getDirectPath(from, to);
//        makeLinkedPaths();
        List<Path> allPossiblePaths = getSortedPathList(getAllPaths(from, to));
        List<String> pathsInStrings = getPathsAsString(allPossiblePaths);
        if(pathsInStrings.size() == 0) {
            allPossiblePaths = getSortedPathList(getAllPaths(to,from));
            pathsInStrings = getReversePathsAsString(allPossiblePaths);
        }
        return pathsInStrings;
    }

    private static List<Path> getSortedPathList(List<Path> allPaths) {
        for (int i=0;i<allPaths.size();i++){
            for(int j=0; j<allPaths.size()-1;j++){
                if(allPaths.get(j).cost > allPaths.get(j+1).cost){
                    Path temp = allPaths.get(j);
                    allPaths.remove(j);
                    allPaths.add(j+1,temp);
                }
            }
        }
        return allPaths;
    }

    public static void makeLinkedPaths() {
        List<Path> directPaths = new ArrayList<Path>();
        directPaths.addAll(paths);
        for (Path eachDirectPath:directPaths){
            createLinkedPaths(eachDirectPath.from, eachDirectPath.to, eachDirectPath.connectors, eachDirectPath.cost);
        }
    }

    private static List<String> getReversePathsAsString(List<Path> resultPaths) {
        List<String> pathsInStrings = new ArrayList<String>();
        for (Path path: resultPaths) {
            String stringPath = path.to.toString() + " -> "
                    + getConnectorsAsReverseString(path.connectors) + " -> " + path.from.toString();
            stringPath += "\n Total Cost: " + path.cost;
            pathsInStrings.add(stringPath);
        }
        return pathsInStrings;
    }

    private static String getConnectorsAsReverseString(List<City> connectors) {
        String result = "";
        for (int i=connectors.size()-1; i>=0;i--){
            if(result.equals("")) result = connectors.get(i).toString();
            else result += " -> " + connectors.get(i);
        }
        return result;
    }

    private static List<String> getPathsAsString(List<Path> resultPaths) {
        List<String> pathsInStrings = new ArrayList<String>();
        for(Path path: resultPaths) {
            String stringPath = path.from.toString() + " -> "
                    + getConnectorsAsString(path.connectors) + " -> " + path.to.toString();
            stringPath += "\n Total Cost: " + path.cost;
            pathsInStrings.add(stringPath);
        }
        return pathsInStrings;
    }

    private static String getConnectorsAsString(List<City> connectors) {
        String result = "";
        for (City city: connectors){
            if(result.equals("")) result = city.toString();
            else result += " -> " + city.toString();
        }
        return result;
    }

    private static List<Path> getAllPaths(City from, City to) {
        List<Path> resultPaths = new ArrayList<Path>();
        for(Path path: paths) {
            if(path.from.equals(from) && path.to.equals(to)) resultPaths.add(path);
        }
        return resultPaths;
    }

    private static List<Path> getAllDirectPaths() {
        List<Path> directPaths = new ArrayList<Path>();
        for(Path eachPath: paths) {
            if(eachPath.connectors == null) {
                directPaths.add(eachPath);
            }
        }
        return directPaths;
    }

    private static List<String> getDirectPath(City from, City to) {
        List<String> result = new ArrayList<String>();
        result.add(from.toString()+" -> "+to.toString());
        return result;
    }


    public static List<Path> getLinkedPathsTo(City to) {
        List<Path> pathsTo = new ArrayList<Path>();
        for(Path path: paths){
            if(path.to.equals(to)) pathsTo.add(path);
        }
        return pathsTo;
    }

    public static List<Path> getPathsTo(City to) {
        List<Path> pathsTo = new ArrayList<Path>();
        for(Path path:paths) {
            if(path.to.equals(to)) pathsTo.add(path);
        }
        return pathsTo;
    }

    public static void createLinkedPathsFrom(City from, City to, List<City> preConnectors, int cost) {
        List<Path> fromPaths = getPathsFrom(to);
        for (Path path: fromPaths){
            List<City> connectors = new ArrayList<City>();
            if(preConnectors != null) connectors.addAll(preConnectors);
            connectors.add(path.from);
            if(path.connectors != null) connectors.addAll(path.connectors);
            Path newLinkedPath = new Path(from, path.to, connectors, cost+path.cost);
            if(!paths.contains(newLinkedPath))
                addNewPath(newLinkedPath);
        }
    }

    public static void createLinkedPaths(City from, City to, List<City> preConnectors, int cost) {
        createLinkedPathsTo(from, to, preConnectors,cost);
        createLinkedPathsFrom(from,to,preConnectors, cost);
    }

    private static void createLinkedPathsTo(City from, City to, List<City> preConnectors, int cost) {
        List<Path> linkedPaths = getLinkedPathsTo(from);
        for (Path linkedPath: linkedPaths){
            List<City> connectors = new ArrayList<City>();
            if(linkedPath.connectors != null)connectors.addAll(linkedPath.connectors);
            connectors.add(linkedPath.to);
            if(preConnectors != null) connectors.addAll(preConnectors);
            Path newLinkedPath = new Path(linkedPath.from, to, connectors, cost+linkedPath.cost);
            if(!paths.contains(newLinkedPath))
                addNewPath(newLinkedPath);
        }
    }

    //	public static Boolean hasDirectOrLinkedPath(City from, City to, List<City> travesedPath) {
//		if(hasDirectPath(from, to)){
//			travesedPath.add(to);
//			return true;
//		}
//		List<Path> pathsFrom = getPathsFrom(from);
//		for (Path path: pathsFrom) {
//			if(!travesedPath.contains(path.to)){
//				travesedPath.add(path.to);
//				if(hasDirectOrLinkedPath(path.to , to, travesedPath)){
//					return true;
//				} else {
//					travesedPath.remove(travesedPath.size() -1);
//				}
//			}
//		}
//		return false;
//	}

//	public static Boolean hasPath(City from, City to) {
//		List<City> traversedPath = new ArrayList<City>();
//		return hasDirectOrLinkedPath(from, to, traversedPath);
//	}

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

//	public static String findPath(City from, City to) {
//		if(from.equals(to)) return from.toString() + " -> " + to.toString();
//		List<City> pathBetweenCities = new ArrayList<City>();
//		pathBetweenCities.add(from);
//		hasDirectOrLinkedPath(from,to,pathBetweenCities);
//		String resultPath = new String();
//		for (City city: pathBetweenCities ) {
//			if(!resultPath.equals("")) resultPath += " -> ";
//			resultPath += city.toString();
//		}
//		return resultPath;
//	}
}