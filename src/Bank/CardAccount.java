package Bank;


public class CardAccount extends PaymentAccount {


    public CardAccount(long paymentScore) {
        super(paymentScore);
    }


    @Override
    public void withdrawalCash(long amount) {
        if (requestBalance() < amount) {
            System.out.println("Account balance " + requestBalance() + " not enough to withdraw " + amount);
        } else {
            long bankPercent = amount / 100;
            if (amount <= 100000) {
                paymentScore = paymentScore - amount - bankPercent;
                System.out.println("Withdrawn from account " + amount +
                        "\nBank commission is " + bankPercent);
            } else System.out.println("Cash withdrawal limit exceeded. You cannot withdraw the amount " + amount);
        }
    }

}
