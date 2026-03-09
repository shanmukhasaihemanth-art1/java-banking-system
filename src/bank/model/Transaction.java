
package bank.model;

import java.time.LocalDateTime;

public class Transaction {

    private int account;
    private String type;
    private double amount;
    private LocalDateTime time;

    public Transaction(int account,String type,double amount){
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public String toFile(){
        return account + "," + type + "," + amount + "," + time;
    }

    public static String format(String line){

        String[] p = line.split(",");

        return "Account: " + p[0] +
               " | Type: " + p[1] +
               " | Amount: " + p[2] +
               " | Time: " + p[3];
    }
}
