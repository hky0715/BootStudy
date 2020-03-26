package gradleSample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paramTestController {
	@GetMapping("/temp")
	String temp(HttpServletRequest request) {
		
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		return a+b;
	}
	
	@GetMapping("/temp2")
	String temp2(@RequestParam Map<String, String> param) {
		String a = param.get("a");
		String b = param.get("b");
		
		return a+b;
	}
	
	@GetMapping("/temp3")
	String temp3(@RequestParam String a, @RequestParam String b) {
		
		return a+b;
	}

	@GetMapping("/putParam")
	List putParam(@RequestParam int a) {
		Map<String, Object> map = new HashMap<>();
		
		for(int i=0; i<a; i++) {
			map.put(RandomStringUtils.randomNumeric(5), Math.random());
		}
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(map);
		
		return list;
		
	}

}
