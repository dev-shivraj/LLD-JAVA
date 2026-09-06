package practice.adapter.base.service;

public interface BankApi {

    void send(String accountNo, int amount);

    int fetchBalance(String accountNo);
}