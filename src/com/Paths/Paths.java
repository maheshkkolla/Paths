package com.Paths;

import java.util.*;
import java.lang.*;
import java.io.*;
public class Paths {
	public static void main(String[] args) {
		if(args.length == 4) {
			handleOnlyFileOption(args); return;
		}
		if(args.length == 6) {
			handleCitiesAndPathFileOptions(args); return;
		}
		System.out.println("More Arguments required");		
	}

	public static void handleCitiesAndPathFileOptions(String[] args) {
		if(args[2].equals("-c")){
			createCitiesDataBase(args[3]);
		} else System.out.println("invalid Option "+args[2]);
		if(args[0].equals("-f")){
			createPathsDataBase(args[1]);
			printThePath(args[4], args[5]);
		} else System.out.println("invalid Option "+args[0]);
	}

	public static void handleOnlyFileOption(String[] args) {
		if(args[0].equals("-f")){
			createPathsDataBase(args[1]);
			printThePath(args[2], args[3]);
			return;
		}
		System.out.println("Invalid Option " + args[0]);
	}

	public static void createCitiesDataBase(String fileName) {
		String fileContent = new String("");
		try{
			fileContent = getFileContent(fileName);
		} catch(IOException e) {
			System.out.println("Invalid DataBase File "+fileName);
			return;
		}
		String[] cities = fileContent.split("\r\n");
		for (String city: cities) {
			String[] nameAndCountry = city.split(",");
			CityCreator.createCity(nameAndCountry[0], nameAndCountry[1]);		
		}
	}

	public static void printThePath(String pathFrom, String pathTo) {
		try{
			List<String> allPaths = PathRecords.findAllPaths(
				CityRecords.getCityFromName(pathFrom), CityRecords.getCityFromName(pathTo)
			);
            for (String path: allPaths){
                System.out.println(path);
            }
		} catch(CityNotFoundException e) {
			System.out.println(e.message);
		}
	}

	public static void createPathsDataBase(String fileName) {
		String fileContent = new String("");
		try{
			fileContent = Paths.getFileContent(fileName);
		}catch(IOException e){
			System.out.println("Invalid DataBase File " + fileName);
			return;
		}
		String[] paths = fileContent.split("\r\n");
		for(String path: paths) {
			String[] cities = path.split(",");
            int cost = Integer.parseInt(cities[2]);
			PathCreator.createPath(cities[0], cities[1], cost);
		}
	}

	public static String getFileContent(String fileName) throws IOException {
		File file = new File(fileName);
		int fileLength = (int)file.length();
		char[] fileData = new char[fileLength];		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		br.read(fileData, 0, fileLength);
		return new String(fileData);
	}
}


