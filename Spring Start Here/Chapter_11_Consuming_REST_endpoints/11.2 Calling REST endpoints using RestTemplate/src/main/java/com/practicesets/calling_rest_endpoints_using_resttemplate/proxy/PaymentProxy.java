package com.practicesets.calling_rest_endpoints_using_resttemplate.proxy;

import com.practicesets.calling_rest_endpoints_using_resttemplate.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentProxy {

    private final RestTemplate restTemplate;

    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public PaymentProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(Payment payment) {
        String uri = paymentServiceUrl + "/payment";

        HttpHeaders headers = new HttpHeaders();
        headers.set("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);

        ResponseEntity<Payment> response =
                restTemplate.exchange(uri,
                        HttpMethod.POST, httpEntity, Payment.class);

        return response.getBody();
    }
}
