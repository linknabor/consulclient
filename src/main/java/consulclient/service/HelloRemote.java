package consulclient.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("consul-client2")
public interface HelloRemote {

	@RequestMapping(value="/onlinepay/testfeign/serviceGet",method=RequestMethod.GET)
	String helloService(@RequestParam("name") String name);
	
	@RequestMapping(value="/onlinepay/testfeign/serviceHead", method=RequestMethod.HEAD)
	String helloService(@RequestHeader("name") String name,
			@RequestHeader("password") String password);
	
	@RequestMapping(value="/onlinepay/testfeign/servicePost", method=RequestMethod.POST)
	String helloService(@RequestBody Map<String, String> map);

	
}