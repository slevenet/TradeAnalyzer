package exchange.analyzer;

import exchange.analyzer.model.Order;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Lazy
@Component
public class OrderManagerMS {
    private String host = "http://localhost";
    private String port = ":8090";
    private String password;
    private String name;
    private RestTemplate restTemplate   = new RestTemplate();

public void sendOrder(Order order){
    HttpEntity<Order> requestBody = new HttpEntity<>(order);
    String endPoint = host + port + "/rest";
    restTemplate.postForObject(endPoint, requestBody,Order.class);
    System.out.println(requestBody.getBody().toString());
}

private boolean validationOrder(Order order){
  //  if(order.getSl())
    return true;
}
}
