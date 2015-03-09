import java.util.*;
import java.lang.*;
import java.io.*;
public class Paths {
	public static void  main(String[] args) {
		PathCreator.createPath("Bangalore", "Singapore");
		PathCreator.createPath("Singapore", "Seoul");
		PathCreator.createPath("Singapore", "Dubai");
		PathCreator.createPath("Seoul", "Beijing");
		PathCreator.createPath("Beijing", "Tokyo");

		try{
			System.out.println( PathRecords.hasPath(
				CityRecords.getCityFromName(args[0]), CityRecords.getCityFromName(args[1])
			));
		} catch(CityNotFoundException e) {
			System.out.println(e.message);
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


// version 4


// String option = args[0];
		// String fileName = args[1];
		// String pathFrom = args[2];
		// String pathTo = args[3];
		// String fileContent;
		// if(option.equals("-f"))
		// try{
		// 	fileContent = Paths.getFileContent(fileName);
		// }catch(IOException e){
		// 	System.out.println("Invalid DataBase File");
		// 	return;
		// }
		// else {System.out.println("Invalid Option"); return;}

		// String[] paths = fileContent.split("\r\n");
		// for(String path: paths) {
			
		// }






