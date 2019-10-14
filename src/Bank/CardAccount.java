package Bank;

public class CardAccount extends PaymentAccount {

    public CardAccount() {
        super();
    }

    public CardAccount(long paymentScore) {
        super(paymentScore);
    }

    @Override
    public void withdrawalCash(long amount) {
        if (requestBalance() < amount) {
            System.out.println("Current balance " + requestBalance() + " not enough to withdraw " + amount);
        } else {
            long bankPercent = amount / 100;
            if (amount <= 100000) {
                 super.changeBalance(requestBalance() - amount - bankPercent);
                System.out.println("Withdrawal from account " + amount + " Bank commission is " + bankPercent);
            } else System.out.println("Cash withdrawal limit exceeded. You cannot withdraw the amount " + amount);
        }
    }

}
