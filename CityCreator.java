class CityCreator {
	public static City createCity(String cityName) {
		City city = new City(cityName);
		CityRecords.addNewCity(city);
		return city;
	}
}