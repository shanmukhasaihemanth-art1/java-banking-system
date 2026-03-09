
package bank.app;

import bank.service.BankService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        BankService bank = new BankService();

        while(true){

            System.out.println("\n===== JAVA BANKING SYSTEM =====");
            System.out.println("1 Create Account");
            System.out.println("2 Deposit");
            System.out.println("3 Withdraw");
            System.out.println("4 Transfer");
            System.out.println("5 Check Balance");
            System.out.println("6 Transaction History");
            System.out.println("7 Bank Report");
            System.out.println("8 Exit");
            System.out.println("=================================");
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Set PIN: ");
                    String pin = sc.nextLine();

                    System.out.print("Initial Deposit: ");
                    double d = sc.nextDouble();

                    bank.createAccount(name,pin,d);
                    break;

                case 2:
                    System.out.print("Account: ");
                    int a = sc.nextInt();

                    System.out.print("Amount: ");
                    double dep = sc.nextDouble();

                    bank.deposit(a,dep);
                    break;

                case 3:
                    System.out.print("Account: ");
                    int w = sc.nextInt();

                    System.out.print("PIN: ");
                    String p = sc.next();

                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();

                    bank.withdraw(w,p,amt);
                    break;

                case 4:
                    System.out.print("From: ");
                    int f = sc.nextInt();

                    System.out.print("To: ");
                    int t = sc.nextInt();

                    System.out.print("PIN: ");
                    String pi = sc.next();

                    System.out.print("Amount: ");
                    double tr = sc.nextDouble();

                    bank.transfer(f,t,pi,tr);
                    break;

                case 5:
                    System.out.print("Account: ");
                    bank.balance(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Account: ");
                    bank.transactions(sc.nextInt());
                    break;

                case 7:
                    bank.report();
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}
