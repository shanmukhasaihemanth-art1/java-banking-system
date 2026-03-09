
package bank.model;

public class Account {

    private int accountNumber;
    private String name;
    private String pin;
    private double balance;

    public Account(int accountNumber,String name,String pin,double balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccountNumber(){ return accountNumber; }
    public String getName(){ return name; }
    public String getPin(){ return pin; }
    public double getBalance(){ return balance; }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public String toFile(){
        return accountNumber + "," + name + "," + pin + "," + balance;
    }

    public static Account fromFile(String line){
        String[] p = line.split(",");
        return new Account(Integer.parseInt(p[0]),p[1],p[2],Double.parseDouble(p[3]));
    }
}
