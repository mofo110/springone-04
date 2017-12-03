package io.pivotal.training.greeting;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FortuneServiceClient {
  private RestTemplate restTemplate;

  @Value("${fortuneService.baseUrl}")
  private String baseUrl;

  public FortuneServiceClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String getFortune() {
    @SuppressWarnings("unchecked")
	Map<String,String> result = restTemplate.getForObject(baseUrl, Map.class);
    return result.get("fortune");
  }
}