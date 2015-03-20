package com.Paths;

class CityCreator {
	public static City createCity(String cityName) {
		City city = new City(cityName);
		CityRecords.addNewCity(city);
		return city;
	}

	public static City createCity(String cityName, String country) {
		City city = new City(cityName, country);
		CityRecords.addNewCity(city);
		return city;
	}
}