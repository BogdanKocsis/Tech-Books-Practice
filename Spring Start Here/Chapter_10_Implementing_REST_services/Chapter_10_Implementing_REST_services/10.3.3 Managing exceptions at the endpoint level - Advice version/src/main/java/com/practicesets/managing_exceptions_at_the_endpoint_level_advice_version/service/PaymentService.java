package com.practicesets.managing_exceptions_at_the_endpoint_level_advice_version.service;

import com.practicesets.managing_exceptions_at_the_endpoint_level_advice_version.exception.NotEnoughMoneyException;
import com.practicesets.managing_exceptions_at_the_endpoint_level_advice_version.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
