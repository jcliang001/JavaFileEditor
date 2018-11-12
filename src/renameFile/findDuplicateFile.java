package renameFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 * outputRoomList is the file that storing all the room pictures that I took; The realRoomList is the number list that I need to go to the building and mark down all the room number. 
 * missingRoomList is the room I need to retake.
 */
public class findDuplicateFile {


	private Set<String> realRoomList;
	private Set<String> experimentedRoomList;
	
	public findDuplicateFile() {
		realRoomList = new HashSet<String>();
		experimentedRoomList = new HashSet<String>();
	}
	
	public void readFile() throws IOException {
		File findDuplicate = new File("./files/hh/room");
		searchAllTheRoom(findDuplicate);
	}

	private void getMissingRoomNumber() throws FileNotFoundException {
		File experimentedList = new File("./realRoomList.txt");
		Scanner in = new Scanner(experimentedList);
		while(in.hasNextLine()){
			String nameOftheRoom = in.nextLine();
			experimentedRoomList.add(nameOftheRoom);
		}
		
		File realList = new File("./outputRoomList.txt");
		Scanner input = new Scanner(realList);
		while(input.hasNextLine()) {
			String nameOftheRoom = input.nextLine();
			realRoomList.add(nameOftheRoom);
		}
		for(String x : experimentedRoomList) {
			if(realRoomList.contains(x))
				realRoomList.remove(x);
		}

		
	}
	private void printMissRoomList() throws IOException {
		File missingRoomFile = new File("./missingRoomList.txt");
		FileWriter writer = new FileWriter(missingRoomFile);
		System.out.println(realRoomList.size());
		for(String x : realRoomList) {
			writer.write(x);
			writer.write("\n");
		}
		writer.close();
		
	}

	private static void searchAllTheRoom(File findDuplicate) throws IOException {
		FileWriter writer = null;
		writer = new FileWriter("outputRoomList.txt");
		File [] fileList = findDuplicate.listFiles();
				for(File f: fileList) {
					if(f.isDirectory())
						searchAllTheRoom(f);
					if(f.isFile()) {
						String name = f.getName();
						int index = name.lastIndexOf(Character.toString('h'));
						String fileName = name.substring(index+1,name.length()-4);
						writer.write(fileName);
						writer.write("\n");
					}
					
				}
		writer.close();
	}
	
	public static void main(String args[]) throws IOException {
		findDuplicateFile newFile = new findDuplicateFile();
		newFile.readFile();
		newFile.getMissingRoomNumber();
		newFile.printMissRoomList();
	}

}
