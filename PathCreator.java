public class PathCreator  {

	public static Path createPath(String from, String to){
		City city1 = getCityFromCityRecords(from);
		City city2 = getCityFromCityRecords(to);
		Path path = new Path(city1, city2);
		PathRecords.addNewPath(path);
		PathRecords.addNewPath(new Path(city2, city1));
		return path;
	}

	private static City getCityFromCityRecords(String cityName) {
		City resultCity;
		try{
			resultCity = CityRecords.getCityFromName(cityName);
		} catch(CityNotFoundException e) {
			resultCity = CityCreator.createCity(cityName);
		}
		return resultCity;
	}
}