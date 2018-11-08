package renameFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class renameFile {
	
	
	public static void main(String[]args) throws IOException
    {
	
       File curDirNode = new File("./files/inputFiles/NodeFolder/directionLines");
      changeAllNodeFileName(curDirNode);
        
//        File curDirRoom = new File("./files/inputFiles/RoomFolder/AnnotatedRoomPictures");
//        changeAllRoomFileName(curDirRoom);
	
    }
	private static void changeAllRoomFileName(File curDir) {
		
		 File[] filesList = curDir.listFiles();
	        for(File f : filesList){
	            if(f.isDirectory())
	                changeAllRoomFileName(f);
	            if(f.isFile()){
	            	String node_floor = "";
	            	String node_number ="";
	            	String room_number="";
	            	String name = f.getName();
	            	System.out.println(name);
	            		//node_floor
	                	node_floor = Character.toString(name.charAt(1));
	                	//node_number
	                	int indexOfslash = name.indexOf(Character.toString('-'));
	                	for(int i=2; i < indexOfslash;i++) {
	                		String newString = Character.toString(name.charAt(i));
	                		node_number+=newString;
	                	}
	                	//room_number
	                	int indexOfr = name.indexOf(Character.toString('r'));
	                	for(int index=indexOfr+1; index <=indexOfr+3; index++) {
	                		String newNum = Character.toString(name.charAt(index));
	                		room_number += newNum;
	                	}

	                	//ct/rooms/<node_floor>.<node_number>-ct<room_number>
	                	String newName = ".//files//ct//room//"+node_floor+"."+node_number+"-ct"+room_number;
	                	File newFile = new File(newName+".jpg");
	                	
	                	System.out.println(f.renameTo(newFile));
	                
	            }
	        }
	}
    private static void changeAllNodeFileName(File curDir) throws IOException {
    	FileWriter writer = null;
  	  	writer = new FileWriter("nodeList.csv",true);
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
                changeAllNodeFileName(f);
            if(f.isFile()){
            	 
            	String node1_floor = "";
            	String node1_number ="";
            	String node2_floor ="";
            	String node2_number="";
            	String newFileInput ="";
            	String name = f.getName();
                if(name.charAt(2) == '-'|| name.charAt(3) == '-')
                {
                	//node1_floor
                	if(name.charAt(0)=='b')
                		node1_floor = Character.toString('0');
                	else
                		node1_floor = Character.toString(name.charAt(0));
                	//node1_number
                	int indexOfslash = name.indexOf(Character.toString('-'));
                	for(int i=1; i < indexOfslash;i++) {
                		String newString = Character.toString(name.charAt(i));
                		node1_number+=newString;
                	}
                	//node2_floor
                	if(name.charAt(indexOfslash+1)=='b')
                		node2_floor = Character.toString('0');
                	else
                		node2_floor = Character.toString(name.charAt(indexOfslash+1));
                	
                	//node2_number
                	int indexOfNextNum = indexOfslash+2;
                	char c = name.charAt(indexOfNextNum);
                	while(Character.isDigit(c)) {
                		String newNum = Character.toString(c);
                		node2_number+=newNum;
                		indexOfNextNum++;
                		c = name.charAt(indexOfNextNum);
                	}
                	
                	String newName = ".//files//ct//"+node1_floor+"."+node1_number+"-"+node2_floor+"."+node2_number;
                	newFileInput = node1_floor+"."+node1_number+"-"+node2_floor+"."+node2_number;
                	
                	File newFile = new File(newName+"."+"jpg");	
                	System.out.println(f.renameTo(newFile));
                	
                		try {
                   		 writer.append(newFileInput);
                   		 writer.append(',');
                   	}catch(Exception e){
                   		System.out.println("fail to write");
                   	}
                	
                	
                	
                	
                 	System.out.println(newFileInput);

                }
                
               
            }

         
        }
        writer.close();
    }

}
