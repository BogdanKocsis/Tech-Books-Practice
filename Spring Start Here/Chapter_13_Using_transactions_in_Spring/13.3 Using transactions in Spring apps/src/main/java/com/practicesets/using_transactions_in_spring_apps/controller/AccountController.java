package com.practicesets.using_transactions_in_spring_apps.controller;

import com.practicesets.using_transactions_in_spring_apps.model.Account;
import com.practicesets.using_transactions_in_spring_apps.model.TransferRequest;
import com.practicesets.using_transactions_in_spring_apps.service.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(request.getSenderAccountId(), request.getReceiverAccountId(), request.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return transferService.getAllAccounts();
    }

}
