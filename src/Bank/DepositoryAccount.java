package Bank ;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositoryAccount extends PaymentAccount {

    private static LocalDate dateStopLock; // дата, когда закончится срок действия депозитного периода


    public DepositoryAccount(long paymentScore) {
        super(paymentScore);
    }

    @Override
    public void depositCash(long amount) {
        dateStopLock = LocalDate.now().plusMonths(1); // присваиваем переменной период действия запрета на снятие со счета
        super.depositCash(requestBalance() + amount);
    }


    public void withdrawalCash(long amount, LocalDate dateStopLock) {
        if (requestBalance() < amount) {
            System.out.println("Account balance " + requestBalance() + " not enough to withdraw " + amount);
        }
        else {
            long periodLock = ChronoUnit.DAYS.between(LocalDate.now(), dateStopLock);
            if (LocalDate.now().isBefore(dateStopLock)) {
                System.out.println("You can withdraw cash only after " + periodLock + " days.");
            }
            else {
                super.withdrawalCash(requestBalance() - amount);
                System.out.println("The amount of " + amount + " was withdrawn from the account");
            }
        }
    }

    public static LocalDate getDateStopLock() {
        return dateStopLock;
    }

}
