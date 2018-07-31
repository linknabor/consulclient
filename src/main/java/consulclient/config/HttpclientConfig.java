package consulclient.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpclientConfig {

	@Value("${http.maxTotal}")
	private int maxTotal;
	
	@Value("${http.maxPerRoute}")
	private int maxPerRoute;
	
	@Value("${http.connectTimeout}")
	private int connectTimeout;
	
	@Value("${http.connectionRequestTimeout}")
	private int connectionRequestTimeout;
	
	@Value("${http.socketTimeout}")
	private int socketTimeout;
	
//	@Value("${staleConnectionCheckEnabled}")
//	private boolean staleConnectionCheckEnabled = true;
	
	@Bean
	public PoolingHttpClientConnectionManager getHttpClientConnectionManager() {
		
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		// 设置连接池大小
		connManager.setMaxTotal(maxTotal);
		connManager.setDefaultMaxPerRoute(maxPerRoute);
		return connManager;
	}
	
	@Bean
	public HttpClientBuilder getHttpClientBuilder(PoolingHttpClientConnectionManager connManager) {
		
		HttpClientBuilder builder = HttpClientBuilder.create();
		builder.setConnectionManager(connManager);
		return builder;
		
	}
	
	@Bean
	public CloseableHttpClient getHttpClient(HttpClientBuilder builder) {
		
		return builder.build();
	}
	
	@Bean
	public RequestConfig getRequestConfig() {
		
		RequestConfig.Builder builder = RequestConfig.custom();
		builder.setConnectTimeout(connectTimeout);
		builder.setConnectionRequestTimeout(connectionRequestTimeout);
		builder.setSocketTimeout(socketTimeout);
		return builder.build();
	}
	

	
	
}
