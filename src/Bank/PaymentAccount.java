package Bank;

public class PaymentAccount {

    private double paymentScore;

    public PaymentAccount() { // конструктор родительского класса с установкой 0 баланса при создании
        paymentScore = 0;
    }

    public PaymentAccount(double paymentScore) { // конструктор родительского класса с установкой баланса при создании
        this.paymentScore = paymentScore;
    }



    public void depositCash(double cashIn) { // метод для пополнения счета (внесение наличных)
        paymentScore = paymentScore + cashIn;
        System.out.println("Entered " + cashIn + " Current balance " + requestBalance());
    }


    public void withdrawalCash(double cashOut) { // метод для вывода средств (снятие наличных)
        if (requestBalance() < cashOut) {
            System.out.println("Account balance " + requestBalance() + " not enough to withdraw " + cashOut);
        }
        else if (cashOut <= 1000000) {
            paymentScore = paymentScore - cashOut;
            System.out.println("Withdrawal " + cashOut + " Current balance " + requestBalance());
        }
        else System.out.println("Cash withdrawal limit exceeded. You cannot withdraw the amount " + cashOut);
    }

    void changeBalance(double paymentScore) { // метод для обновления баланса в дочерних методах
        this.paymentScore = paymentScore;
    }


    public double requestBalance() { // метод для запроса баланса
        return paymentScore;
    }

}
