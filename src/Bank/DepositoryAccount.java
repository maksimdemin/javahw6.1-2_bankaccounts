package Bank ;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositoryAccount extends PaymentAccount {

    private LocalDate dateStopLock; // дата, когда закончится срок действия депозитного периода

    public DepositoryAccount() {
        super();
    }

    public DepositoryAccount(double paymentScore) {
        super(paymentScore);
    }


    @Override
    public void depositCash(double amount) {
        getDateStopLock();
        super.changeBalance(requestBalance() + amount);
//        super.depositCash(amount);
        System.out.println("Entered " + amount + " Current balance " + requestBalance());
    }


    public void withdrawalCash(double amount) {
        if (requestBalance() < amount) {
            System.out.println("Account balance " + requestBalance() + " not enough to withdraw " + amount);
        }
        else {
            if (LocalDate.now().isBefore(dateStopLock)) {
                double periodLock = ChronoUnit.DAYS.between(LocalDate.now(), dateStopLock);
                System.out.println("You can withdraw " + amount + " cash only after " + (int) periodLock + " day(s).");
            }
            else {
                super.changeBalance(requestBalance() - amount);
//                super.withdrawalCash(amount);
                System.out.println("The amount of " + amount + " was withdrawn from the account");
            }
        }
    }


    public LocalDate getDateStopLock() {
        return dateStopLock = LocalDate.now().plusMonths(1);
    }

}
