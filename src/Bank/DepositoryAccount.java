package Bank ;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositoryAccount extends PaymentAccount {

    private static int quantityMonthsForPeriodDeposit; // переменная для установки длительности периода депозитного вклада
    private static LocalDate dateStopDeposit; // дата, когда закончится срок действия депозитного периода
    private long depositCapitalization = 0; // капитализация вклада


    public DepositoryAccount(long paymentScore, int quantityMonthsForPeriodDeposit) {
        super(paymentScore);
        dateStopDeposit = LocalDate.now().plusMonths(quantityMonthsForPeriodDeposit); // присваиваем переменной период действия вклада
        System.out.println("You have made a contribution in the amount of " + paymentScore + " with an interest rate of 5%. Period: " + quantityMonthsForPeriodDeposit + " month(s)");
    }


    @Override
    public void withdrawalCash(long cashOut) {
        if (requestBalance() < cashOut) {
            System.out.println("Account balance " + requestBalance() + " not enough to withdraw " + cashOut);
        }
        else {
            long periodDeposit = ChronoUnit.DAYS.between(LocalDate.now(), dateStopDeposit);
            if (LocalDate.now().isBefore(dateStopDeposit)) {
                System.out.println("You can withdraw cash only after " + periodDeposit + " days.");
            }
            else {
                depositCapitalization = (long) (paymentScore * 0.05);
                paymentScore = paymentScore + depositCapitalization;
                System.out.println("Account capitalization is " + depositCapitalization);

                paymentScore = paymentScore - cashOut;
                System.out.println("The amount of " + cashOut + " was withdrawn from the account");
            }
        }
    }

    @Override
    public long requestBalance() {
        long periodDeposit = ChronoUnit.DAYS.between(LocalDate.now(), dateStopDeposit);
        if (LocalDate.now().isBefore(dateStopDeposit)) {
            System.out.println("You can withdraw cash only after " + periodDeposit + " days.");
        }
        else {
            depositCapitalization = (long) (paymentScore * 0.05);
            paymentScore = paymentScore + depositCapitalization;
            System.out.println("Account capitalization is " + depositCapitalization);
        }
        return paymentScore;
    }


}
