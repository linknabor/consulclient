package consulclient.config;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempletConfig {
	
	@Value("${http.connectTimeout}")
	private int connectTimeout;
	
	@Value("${http.connectionRequestTimeout}")
	private int connectionRequestTimeout;
	
	@Value("${http.readTimeout}")
	private int readTimeout;

	@Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }
	
	@Bean
	public HttpComponentsClientHttpRequestFactory getHttpRequestFactory(HttpClient httpClient) {

		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);// httpClient连接配置
		clientHttpRequestFactory.setBufferRequestBody(false);
		clientHttpRequestFactory.setConnectTimeout(connectTimeout);
		clientHttpRequestFactory.setConnectionRequestTimeout(connectionRequestTimeout);
		clientHttpRequestFactory.setReadTimeout(readTimeout);
		return clientHttpRequestFactory;
	}

}
