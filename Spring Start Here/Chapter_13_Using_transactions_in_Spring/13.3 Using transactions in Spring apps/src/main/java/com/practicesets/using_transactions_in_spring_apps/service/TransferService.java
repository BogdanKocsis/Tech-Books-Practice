package com.practicesets.using_transactions_in_spring_apps.service;

import com.practicesets.using_transactions_in_spring_apps.model.Account;
import com.practicesets.using_transactions_in_spring_apps.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {

        Account sender = accountRepository.findAccountById(idSender); // mutable operation
        Account receiver = accountRepository.findAccountById(idReceiver); // mutable operation

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount); // mutable operation
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
