public class City {
	String name;
	City(String name) {
		this.name = name;
	}

	public boolean equals(Object cityArgs) {
		City city = (City)cityArgs;
		return this.name.equals(city.name);
	}
	public String toString(){
		return name;	
	}
}