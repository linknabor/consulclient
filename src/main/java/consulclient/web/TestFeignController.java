package consulclient.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import consulclient.service.HelloRemote;

@RestController
public class TestFeignController {

	@Autowired
	private HelloRemote helloRemote;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String demoServiceTest() {
		StringBuffer sb = new StringBuffer();
		sb.append(helloRemote.helloService("yuanyuan"));
		sb.append("\n");
		sb.append(helloRemote.helloService("yjt","xixihaha"));
		sb.append("\n");
		Map<String, String> map = new HashMap<String, String>();
		map.put("yejingtao", "123456");
		sb.append(helloRemote.helloService(map));
		return sb.toString();
		
	}

	
}
