import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int PERCENT = 100;
        final int MONTHS = 12;

        Scanner scanner = new Scanner(System.in);

        double principal;
        double monthlyInterestRate;
        int numberOfPayments;


        while(true){
            System.out.print("Principal ($1K - $1M: ");
            principal = scanner.nextDouble();
            if(principal >= 1_000 && principal <= 1_000_000)
              break;
            System.out.println("Enter a number between 1,000 ans 1,000,000");
        }



        while (true){
            System.out.print("Annual Interest Rate: ");
            monthlyInterestRate = scanner.nextDouble();
            if(monthlyInterestRate > 0 && monthlyInterestRate <= 30){
                monthlyInterestRate = (monthlyInterestRate / PERCENT) / MONTHS;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }



        while (true){
            System.out.print("Period (Years): ");
            numberOfPayments = scanner.nextInt();
            if(numberOfPayments >= 1 && numberOfPayments <= 30){
                numberOfPayments *=  MONTHS;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Mortgage: " + currency.format(mortgage(principal,monthlyInterestRate,numberOfPayments)));
    }

    public static double mortgage(double principal, double monthlyInterestRate, int numberOfPayment) {
        return principal * ((monthlyInterestRate*Math.pow((1+monthlyInterestRate),numberOfPayment))/(Math.pow((1+monthlyInterestRate),numberOfPayment)-1));
    }
    public static void fizzBuzz(int number){
        if(number%3==0 || number%5==0){
            if(number%3==0 && number%5 == 0){
                System.out.println("FizzBuzz");
            } else if (number%3==0) {
                System.out.println("Buzz");
            }else System.out.println("Fizz");
        }else
            System.out.println(number);
    }
}