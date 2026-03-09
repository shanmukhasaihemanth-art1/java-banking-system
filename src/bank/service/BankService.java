
package bank.service;

import bank.model.*;
import bank.repository.AccountRepository;
import bank.util.FileUtil;

import java.util.*;

public class BankService {

    private List<Account> accounts;
    private AccountRepository repo = new AccountRepository();
    private final String TX_FILE = "data/transactions.txt";

    public BankService(){
        accounts = repo.load();
    }

    private int nextAccount(){
        return 1000 + accounts.size() + 1;
    }

    public void createAccount(String name,String pin,double deposit){

        int id = nextAccount();

        Account acc = new Account(id,name,pin,deposit);

        accounts.add(acc);
        repo.save(accounts);

        System.out.println("Account Created Successfully");
        System.out.println("Account Number: " + id);
        System.out.println("Current Balance: " + acc.getBalance());

        FileUtil.append(TX_FILE,new Transaction(id,"ACCOUNT_CREATED",deposit).toFile());
    }

    private Account find(int id){

        for(Account a : accounts){
            if(a.getAccountNumber()==id)
                return a;
        }

        return null;
    }

    public void deposit(int id,double amt){

        Account a = find(id);

        if(a == null){
            System.out.println("Account not found");
            return;
        }

        a.deposit(amt);
        repo.save(accounts);

        FileUtil.append(TX_FILE,new Transaction(id,"DEPOSIT",amt).toFile());

        System.out.println("Deposit Successful");
        System.out.println("Updated Balance: " + a.getBalance());
    }

    public void withdraw(int id,String pin,double amt){

        Account a = find(id);

        if(a == null || !a.getPin().equals(pin)){
            System.out.println("Invalid account or PIN");
            return;
        }

        if(a.withdraw(amt)){

            repo.save(accounts);

            FileUtil.append(TX_FILE,new Transaction(id,"WITHDRAW",amt).toFile());

            System.out.println("Withdraw Successful");
            System.out.println("Remaining Balance: " + a.getBalance());

        }else{
            System.out.println("Insufficient Balance");
        }
    }

    public void transfer(int from,int to,String pin,double amt){

        Account sender = find(from);
        Account receiver = find(to);

        if(sender == null || receiver == null || !sender.getPin().equals(pin)){
            System.out.println("Transfer Failed");
            return;
        }

        if(sender.withdraw(amt)){

            receiver.deposit(amt);

            repo.save(accounts);

            FileUtil.append(TX_FILE,new Transaction(from,"TRANSFER_SENT",amt).toFile());
            FileUtil.append(TX_FILE,new Transaction(to,"TRANSFER_RECEIVED",amt).toFile());

            System.out.println("Transfer Successful");
            System.out.println("Your New Balance: " + sender.getBalance());

        }else{
            System.out.println("Insufficient Balance");
        }
    }

    public void balance(int id){

        Account a = find(id);

        if(a == null){
            System.out.println("Account not found");
            return;
        }

        System.out.println("----------- ACCOUNT DETAILS -----------");
        System.out.println("Account Number : " + a.getAccountNumber());
        System.out.println("Account Holder : " + a.getName());
        System.out.println("Current Balance: " + a.getBalance());
        System.out.println("---------------------------------------");
    }

    public void transactions(int id){

        List<String> list = FileUtil.read(TX_FILE);

        boolean found = false;

        System.out.println("------ TRANSACTION HISTORY ------");

        for(String l : list){

            if(l.startsWith(id + ",")){
                System.out.println(Transaction.format(l));
                found = true;
            }
        }

        if(!found){
            System.out.println("No transactions found.");
        }

        System.out.println("---------------------------------");
    }

    public void report(){

        double total = 0;

        for(Account a : accounts){
            total += a.getBalance();
        }

        System.out.println("Total Accounts : " + accounts.size());
        System.out.println("Total Bank Balance : " + total);
    }
}
