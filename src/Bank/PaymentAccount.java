package Bank;

public class PaymentAccount {

    private long paymentScore;

    public PaymentAccount(long paymentScore) { // конструктор родительского класса
        this.paymentScore = paymentScore;
    }


    public void depositCash(long cashIn) { // метод для пополнения счета (внесение наличных)
        paymentScore = paymentScore + cashIn;
    }


    public void withdrawalCash(long cashOut) { // метод для вывода средств (снятие наличных)
        if (requestBalance() < cashOut) {
            System.out.println("Account balance " + requestBalance() + " not enough to withdraw " + cashOut);
        }
        else if (cashOut <= 1000000) {
            paymentScore = paymentScore - cashOut;
        }
        else System.out.println("Cash withdrawal limit exceeded. You cannot withdraw the amount " + cashOut);
    }


    public long requestBalance() { // метод для запроса баланса
        return paymentScore;
    }

}
