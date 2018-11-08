package renameFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
public class writeCsv {
	
	
	private String location;
	
	public String getLocation() {
		return location;
	}


	public static FileWriter writer;
	
	public writeCsv(String location) throws IOException {
		super();
		this.location = location;
		writer = new FileWriter(location);
	
	}

	
public void generateCsvFile( String fileName) throws IOException {



     writer.append(fileName);
     writer.append(',');
     writer.append('\n');
     

}


public void colseF() throws IOException {
	writer.close();
}



}