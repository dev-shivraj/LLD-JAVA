package practice.adapter.base.factory;

import practice.adapter.base.service.BankApi;
import practice.adapter.base.adapter.IciciBankAdapter;
import practice.adapter.base.adapter.YesBankAdapter;

public class AdapterFactory {

    public static BankApi getBankAdapter(String bankName) {
        if(bankName.equals("icici")) {
            return new IciciBankAdapter();
        }
        else if(bankName.equals("yes")) {
            return new YesBankAdapter();
        }

        return null;
    }
}