package gradleSample;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonTest2 {
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "hong");
		map.put("age", 31);
		
		// convert map to json
		try {
			json = mapper.writeValueAsString(map);
			System.out.println(json);
			
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
