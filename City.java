public class City {
	String name;
	String country;
	City(String name) {
		this.name = name;
	}

	City(String name, String country) {
		this.name = name;
		this.country = country;
	}

	public boolean equals(Object cityArgs) {
		City city = (City)cityArgs;
		return this.name.equals(city.name);
	}
	public String toString(){
		if(country == null) return name;
		return name + "[" + country + "]";	
	}
}