package practice.adapter.base.adapter;


import practice.adapter.base.service.BankApi;
import practice.adapter.base.externalbankapi.YesBankApi;

public class YesBankAdapter implements BankApi {

    private YesBankApi yesBankApi;

    public YesBankAdapter() {
        this.yesBankApi = new YesBankApi();
    }

    @Override
    public void send(String accountNo, int amount) {
        yesBankApi.makeTransaction(accountNo,amount);
    }

    @Override
    public int fetchBalance(String accountNo) {
        return yesBankApi.getBalance(accountNo);
    }
}