package renameFile;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class example {
	public static void main(String args[]) throws IOException {
		
			writeCsv example = null;
			try {
				example = new writeCsv("C:\\Users\\travi\\eclipse-workspace\\renameFile\\example.csv");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			example.generateCsvFile("fdfdsfd");
			example.generateCsvFile("fileName");
			
			example.colseF();
	}
}
