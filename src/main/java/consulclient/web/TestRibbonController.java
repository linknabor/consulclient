package consulclient.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestRibbonController {

	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/call")
	public String call() {
		ServiceInstance serviceInstance = loadBalancer.choose("consul-client2");
		System.out.println("服务地址：" + serviceInstance.getUri());
		System.out.println("服务名称：" + serviceInstance.getServiceId());
		
		String url = serviceInstance.getUri().toString() + "/onlinepay/testfeign/serviceGet?name=yuanyuan";
		System.out.println("请求地址：" + url);
		
		String callServiceResult = restTemplate.getForObject(url,
				String.class);
		System.out.println(callServiceResult);
		return callServiceResult;
	}

}
