package Framwork.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class DataReader 

{

//Json Data Reader for Order Test
	public static List<HashMap<String, Object>> getJsonDataToMap(String jsondataFilePath) throws IOException
	{
		String jsonData=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Framework//TestData//data.json"),StandardCharsets.UTF_8);
		
		ObjectMapper mapper= new ObjectMapper();
		
		List<HashMap<String, Object>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String, Object>>>() {
	      });
		
		  return data;
		

		
	}
	
	
}
