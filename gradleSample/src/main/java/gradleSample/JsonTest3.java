package gradleSample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest3 {
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "hong");
		map.put("age", 31);
		
		List<Object> list = new ArrayList<>();
		list.add("msg 1");
		list.add("msg 2");
		
		map.put("message", list);
		
		try {
			mapper.writeValue(new File("/Users/hong-kyuyoung/workspace_sts/gradleSample/test.json"), map);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
