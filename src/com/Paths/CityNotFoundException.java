package com.Paths;

/**
 * Created by maheshkk on 3/20/2015.
 */
public class CityNotFoundException extends Exception{
	String message ;
	CityNotFoundException(String city) {
		this.message = "No City names \""+city+"\" in Database";
	}
}
