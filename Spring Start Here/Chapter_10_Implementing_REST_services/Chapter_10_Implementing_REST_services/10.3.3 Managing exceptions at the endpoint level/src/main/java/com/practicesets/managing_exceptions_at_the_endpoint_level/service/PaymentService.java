package com.practicesets.managing_exceptions_at_the_endpoint_level.service;

import com.practicesets.managing_exceptions_at_the_endpoint_level.exception.NotEnoughMoneyException;
import com.practicesets.managing_exceptions_at_the_endpoint_level.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
