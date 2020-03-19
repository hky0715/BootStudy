package gradleSample;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"name\":\"Hong\", \"age\":31}";
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		// Convert json to map
		try {
			jsonMap = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
			
			System.out.println(jsonMap);
			System.out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
