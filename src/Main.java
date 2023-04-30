import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double principal;
        double yearlyInterestRate;
        int numberOfPayments;

        principal = readInput("Principal ($1K - $1M): ", 1_000, 1_000_000);

        yearlyInterestRate = readInput("Annual Interest Rate: ", 1, 30);

        numberOfPayments = (int) readInput("Period (Years): ", 1, 30);

        mortgageCalculator(principal, yearlyInterestRate, numberOfPayments);

    }




    public static double readInput(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double number;
        while (true) {
            System.out.print(prompt);
            number = scanner.nextDouble();
            if (number >= min && number <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return number;
    }

    public static double balanceCalculator(double principal, double monthlyInterestRate, int numberOfPayments, int paymentsPaid) {
        monthlyInterestRate += 1;
        double number = Math.pow(monthlyInterestRate,numberOfPayments);
        return principal * ( (number - Math.pow(monthlyInterestRate,paymentsPaid))/(number - 1) );
    }
    public static double mortgageCalculator(double principal, double yearlyInterestRate, int numberOfPaymentsMade) {
        final int PERCENT = 100;
        final int MONTHS = 12;
        double balance;
        numberOfPaymentsMade *= MONTHS;
        double monthlyInterestRate = (yearlyInterestRate / PERCENT) / MONTHS;
        double mortgage = principal * ((monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPaymentsMade)) / (Math.pow((1 + monthlyInterestRate), numberOfPaymentsMade) - 1));

        printResults(principal, numberOfPaymentsMade, monthlyInterestRate, mortgage);
        return mortgage;
    }

    private static void printResults(double principal, int numberOfPaymentsMade, double monthlyInterestRate, double mortgage) {
        double balance;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("\nMORTGAGE \n_________\nMonthly Payments: " + currency.format(mortgage));

        System.out.println("\nPAYMENT SCHEDULE\n_______________");
        for (int month = 1; month <= numberOfPaymentsMade; month++){
            balance = balanceCalculator(principal, monthlyInterestRate, numberOfPaymentsMade,month);
            System.out.println(currency.format(balance));
        }
    }

    public static void fizzBuzz(int number) {
        if (number % 3 == 0 || number % 5 == 0) {
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (number % 3 == 0) {
                System.out.println("Buzz");
            } else System.out.println("Fizz");
        } else
            System.out.println(number);
    }
}