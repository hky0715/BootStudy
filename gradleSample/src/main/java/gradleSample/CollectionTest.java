package gradleSample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CollectionTest {
	/*
	 * 1. {name, value} 출력 (Map)
	 * 2. [{name, value}] 출력 (List<Map>)
	 * 3. [{name, value}, {name, value}] 출력 (for 문 미사용)
	 * 4. [{name, value}, {name, value}] 출력 (for 문 사용)
	 * 5. [{name, value}, ...] 출력 (for 문 사용, List.length 를 len 변수로 지)
	 * 
	 * 1-5을 각각의 static method 로 구현하고 순서대로 호출
	 */
	
	@GetMapping("/test1") // {name, value} 출력 (Map)
	static Map<String, Object> test1(@RequestParam String a, @RequestParam Object b) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"Name\":\""+ a + "\", \"Address\":\"" +b +"\"}";
		// {"Name":"a", "Address":"b"}
		// '{"Name":"' + a + ', "Address":"' + b + '"}'
		// "{\"Name\":\"" + a + ", \"Address\":\"" + b + "\"}"
	// "이름 : 홍규영"
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		// Convert json to map
		try {
			jsonMap = mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
			jsonMap.put("Name", a);
			jsonMap.put("Address", b);
			System.out.println(jsonMap);
			System.out.println("Name : "+a);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	@GetMapping("/test0")
	static Map<String, Object> test0(@RequestParam String a, @RequestParam Object b) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("Name", a);
		jsonMap.put("Address", b);
		return jsonMap;
	}
	
	@GetMapping("/test2") // [{name, value}] 출력 (List<Map>)
	static List<Map<String, Object>> test2(@RequestParam String a, @RequestParam Object b) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<Map<String, Object>> listMap = new ArrayList<>();
		
		jsonMap.put("Name", a);
		jsonMap.put("Address", b);
		
		listMap.add(jsonMap);
		
		return listMap;
	}
	
	@GetMapping("/test3") // [{name, value}, {name, value}] 출력 (for 문 미사용)
	//Hashmap은 map 내 데이터에 대해 순서를 보장하지 않기 때문에 다른 map을 써보기로 함..
	static List<Map<String, Object>> temp3(@RequestParam String a, @RequestParam String b, @RequestParam String c, @RequestParam String d) {	
		
		Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
		Map<String, Object> jsonMap2 = new LinkedHashMap<String, Object>();
		
		List<Map<String, Object>> listMap = new ArrayList<>();
		
		jsonMap.put("Name", a);
		jsonMap.put("Address", b);
		
		listMap.add(jsonMap);
		
		jsonMap2.put("Name", c);
		jsonMap2.put("Address", d);
		
		listMap.add(jsonMap2);
		
		return listMap;
	}
	
	@GetMapping("/test4") // [{name, value}, {name, value}] 출력 (for 문 사용)
	static List<Map<String, Object>> temp4(@RequestParam int a) {
		
		List<Map<String, Object>> listMap = new ArrayList<>();
		
		for (int i=0; i<a; i++) {
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("Name", RandomStringUtils.randomAlphabetic(5));
			map.put("Address", Math.random());
			listMap.add(map);
		}
		
		return listMap;
	}
}
