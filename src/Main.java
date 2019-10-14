import Bank.CardAccount;
import Bank.DepositoryAccount;
import Bank.PaymentAccount;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Main {

    public static void main(String[] args) {

        System.out.println("\nPayment Account");
        PaymentAccount paymentAccount = new PaymentAccount(0);
        System.out.println("Current balance: " + paymentAccount.requestBalance());
        paymentAccount.depositCash(10000);
        System.out.println("Current balance: " + paymentAccount.requestBalance());
        paymentAccount.withdrawalCash(1000);
        System.out.println("Current balance: " + paymentAccount.requestBalance());
        paymentAccount.depositCash(555);
        System.out.println("Current balance: " + paymentAccount.requestBalance());

        System.out.println("\nDepository Account");
        DepositoryAccount depositoryAccount = new DepositoryAccount(0);
        System.out.println("Current balance depositary account: " + depositoryAccount.requestBalance());
        depositoryAccount.withdrawalCash(1000);
        System.out.println("Current balance depositary account: " + depositoryAccount.requestBalance());
        depositoryAccount.depositCash(200000);
        System.out.println("Current balance depositary account: " + depositoryAccount.requestBalance());
        depositoryAccount.withdrawalCash(15000);
        System.out.println("Current balance depositary account: " + depositoryAccount.requestBalance());

        System.out.println("\nCard Account");
        CardAccount cardAccount = new CardAccount();
        System.out.println("Current balance: " + cardAccount.requestBalance());
        cardAccount.depositCash(10000);
        System.out.println("Current balance: " + cardAccount.requestBalance());
        cardAccount.withdrawalCash(1000000);
        cardAccount.withdrawalCash(1000);
        System.out.println("Current balance: " + cardAccount.requestBalance());
        cardAccount.withdrawalCash(1500);
        System.out.println("Current balance: " + cardAccount.requestBalance());
        cardAccount.depositCash(800);
        System.out.println("Current balance: " + cardAccount.requestBalance());
        
    }
}
