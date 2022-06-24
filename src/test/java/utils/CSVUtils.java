package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVUtils {
	
	@DataProvider(name="csvdata")
	public static String[][] readCsvFile() throws IOException, CsvValidationException {
				   
		   CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/Users.csv"));
		   String[] line;
		 	   
		   List<String[]> userList = new ArrayList<>();
		    csvReader.skip(1);
		    
		   while ((line = csvReader.readNext()) != null) {
		       userList.add(line);
		   }
		   
		   int rows = userList.size();
		   int cols = userList.get(0).length;
		   
		   String[][] dataFromCSV = new String[rows][cols];
		   
		   for (int i = 0; i < rows; i++) {
		       String[] eachRow = userList.get(i);
		       for (int j = 0; j < cols; j++) {
		           dataFromCSV[i][j] = eachRow[j];
		       }
		   }
		   return dataFromCSV;
		}

}
