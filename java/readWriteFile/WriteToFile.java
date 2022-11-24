package readWriteFile;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class WriteToFile {
	
	
	@Test
	public void writeDataIntoFile() throws IOException {
		
		
		String myData = "I am testing the writing data";
		// create file path
		String filePath = "src/test/resources/testData/GorestResponseData.json";
		
		// create file object and asign file path as a parameter
		File file = new File(filePath);
		
		FileUtils.writeStringToFile(file, myData);;
		
	}
	
	

}
