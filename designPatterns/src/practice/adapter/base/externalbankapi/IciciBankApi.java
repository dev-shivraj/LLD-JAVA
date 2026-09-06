package practice.adapter.base.externalbankapi;

public class IciciBankApi {

    public void transfer(String accountNo, int amount, String authToken) {
        System.out.println("Sending money from ICICI: "+accountNo+ " amount = "+amount + " token = "+ authToken);
    }

    public int seeBalance(String accountNo) {
        System.out.println("Balance from ICICI: = 10000");
        return 10000;
    }
}