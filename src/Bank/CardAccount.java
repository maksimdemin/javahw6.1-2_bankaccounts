package Bank;

import java.util.Queue;

public class CardAccount extends PaymentAccount {


    public CardAccount(long paymentScore) {
        super(paymentScore);
    }


    @Override
    public void withdrawalCash(long cashOut) {
        if (requestBalance() < cashOut) {
            System.out.println("Account balance " + requestBalance() + " not enough to withdraw " + cashOut);
        } else {
            long bankPercent = cashOut / 100;
            if (cashOut <= 100000) {
                paymentScore = paymentScore - cashOut - bankPercent;
                System.out.println("Withdrawn from account " + cashOut +
                        "\nBank commission is " + bankPercent);
            } else System.out.println("Cash withdrawal limit exceeded. You cannot withdraw the amount " + cashOut);
        }
    }

}
