
package bank.repository;

import bank.model.Account;
import bank.util.FileUtil;

import java.util.*;

public class AccountRepository {

    private final String FILE = "data/accounts.txt";

    public List<Account> load(){

        List<Account> list = new ArrayList<>();

        for(String line : FileUtil.read(FILE)){
            list.add(Account.fromFile(line));
        }

        return list;
    }

    public void save(List<Account> accounts){

        List<String> lines = new ArrayList<>();

        for(Account a : accounts){
            lines.add(a.toFile());
        }

        FileUtil.write(FILE,lines);
    }
}
