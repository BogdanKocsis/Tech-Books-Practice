package com.practicesets.using_a_request_body_to_get_data_from_the_client.service;

import com.practicesets.using_a_request_body_to_get_data_from_the_client.exception.NotEnoughMoneyException;
import com.practicesets.using_a_request_body_to_get_data_from_the_client.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
