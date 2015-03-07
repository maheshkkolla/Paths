import java.lang.*;
import java.util.*;

class CityRecords {
	
	static List<City> cities = new ArrayList<City>();

	public static City getCityFromName(String cityName) throws CityNotFoundException{
		for (City city: cities) {
			if(city.name.equals(cityName)) return city;
		}
		throw new CityNotFoundException(cityName);
	}

	public static void addNewCity(City city) {
		cities.add(city);
	}
}