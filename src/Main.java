import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int PERCENT = 100;
        final int MONTHS = 12;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");

        double principal = scanner.nextDouble();
        System.out.print("Annual Interest Rate: ");

        double monthlyInterestRate = (scanner.nextDouble() / PERCENT) / MONTHS;
        System.out.print("Period (Years): ");

        int numberOfPayments = scanner.nextInt() * MONTHS;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Mortgage: " + currency.format(mortgage(principal,monthlyInterestRate,numberOfPayments)));
    }

    public static double mortgage(double principal, double monthlyInterestRate, int numberOfPayment) {
        return principal * ((monthlyInterestRate*Math.pow((1+monthlyInterestRate),numberOfPayment))/(Math.pow((1+monthlyInterestRate),numberOfPayment)-1));
    }
}