package com.practicesets.calling_rest_endpoints_using_webclient.controllers;

import com.practicesets.calling_rest_endpoints_using_webclient.model.Payment;
import com.practicesets.calling_rest_endpoints_using_webclient.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        payment.setId(requestId);
        return paymentsProxy.cratePayment(requestId, payment);
    }
}
