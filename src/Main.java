import Bank.CardAccount;
import Bank.DepositoryAccount;
import Bank.PaymentAccount;


public class Main {

    public static void main(String[] args) {

        System.out.println("\nPayment Account");
        PaymentAccount paymentAccount = new PaymentAccount(0);
        System.out.println("Currently balance: " + paymentAccount.requestBalance());
        paymentAccount.depositCash(10000);
        System.out.println("Currently balance: " + paymentAccount.requestBalance());
        paymentAccount.withdrawalCash(1000);
        System.out.println("Currently balance: " + paymentAccount.requestBalance());
        paymentAccount.depositCash(555);
        System.out.println("Currently balance: " + paymentAccount.requestBalance());

        System.out.println("\nDepository Account");
        DepositoryAccount depositoryAccount = new DepositoryAccount(0);
        System.out.println("Current balance depositary account: " + depositoryAccount.requestBalance());
        depositoryAccount.depositCash(200000);
        System.out.println("Current balance depositary account: " + depositoryAccount.requestBalance());
        depositoryAccount.withdrawalCash(15000);
        System.out.println("Current balance depositary account: " + depositoryAccount.requestBalance());

        System.out.println("\nCard Account");
        CardAccount cardAccount = new CardAccount(500000);
        System.out.println("Currently balance: " + cardAccount.requestBalance());
        cardAccount.depositCash(1000);
        System.out.println("Currently balance: " + cardAccount.requestBalance());
        cardAccount.withdrawalCash(1000000000);
        cardAccount.withdrawalCash(1000);
        System.out.println("Currently balance: " + cardAccount.requestBalance());
        cardAccount.withdrawalCash(150000);
    }
}
