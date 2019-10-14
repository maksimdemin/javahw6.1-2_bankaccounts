package Bank;

public class CardAccount extends PaymentAccount {

    public CardAccount() {
        super();
    }

    public CardAccount(double paymentScore) {
        super(paymentScore);
    }

    @Override
    public void withdrawalCash(double amount) {
        if (requestBalance() < amount) {
            System.out.println("Current balance " + requestBalance() + " not enough to withdraw " + amount);
        } else {
            double bankPercent = amount / 100;
//            double bankPercentSimple = 1.01; // (balance - amount - amount * 0.01) = balance - amount * 1.01
            if (amount <= 100000) {
                 super.changeBalance(requestBalance() - amount - bankPercent);
//                 super.withdrawalCash((amount * bankPercentSimple));
                System.out.println("Withdrawal from account " + amount + " Bank commission is " + bankPercent);
            } else System.out.println("Cash withdrawal limit exceeded. You cannot withdraw the amount " + amount);
        }
    }

}
