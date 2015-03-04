import java.util.*;
import java.lang.*;
import java.io.*;
public class Paths {
	public static void  main(String[] args) {
		Records records = new Records();
		records.addPath(new City("Banglore"), new City("Singapore"));
		records.addPath(new City("Singapore"), new City("Seoul"));
		records.addPath(new City("Singapore"), new City("Dubai"));
		records.addPath(new City("Seoul"), new City("Beijing"));
		records.addPath(new City("Beijing"), new City("Tokyo"));
		try{
			System.out.println(records.getPath(records.getCityFromName(args[0]),  records.getCityFromName(args[1])));	
		} catch(CityNotFoundException exc){
			System.out.println(exc.message);
		} catch(NullPointerException e){
			System.out.println(false);
		}
	}
}






