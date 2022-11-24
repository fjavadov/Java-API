package readWriteFile;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ReadFile {

	
	
	@Test
	public void readDataFromFile() throws IOException {
		//add path for the resourse
		String filePath = "src/test/resources/testData/GorestRequestData.json";
		
		// create file object and add file path as a parameter
		File file = new File(filePath);
		
		// read the file
		String myData = FileUtils.readFileToString(file);
		
		System.out.println(myData);
	}
	
	
	
	
	
	
	
}
