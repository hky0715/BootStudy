package gradleSample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class restapiTestController {

	@RequestMapping(value="/printList")
	@ResponseBody
	public List<Map<String, Object>> printMap() {
		Map<String, Object> map = new HashMap<>();
		
		for(int i=0; i<5; i++) {
			map.put(RandomStringUtils.randomNumeric(5), Math.random());
		}
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(map);
		
		return list;
	}
}
