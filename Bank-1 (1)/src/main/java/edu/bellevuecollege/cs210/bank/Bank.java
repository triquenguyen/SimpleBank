package edu.bellevuecollege.cs210.bank;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.bellevuecollege.cs210.bank.exceptions.UnknownAccountException;

public class Bank {

    private Account[] accountList;
    private int num;
    private Account acct = null;

    public Bank() {
        accountList = new Account[10000];
        num = 0;
    }
    /**
     * Opens a new account based on the information passed in, adds it to the list of accounts.
     * @param firstName First name of account holder.
     * @param lastName Last name of account holder.
     */

    public void openAccount(String firstName, String lastName) {
        int no = num + 1;
        accountList[num] = new Account(firstName, lastName, String.valueOf(no));
        System.out.println("Your Account Number is : " + no);
        num++;
    }

    /**
     * Closes an account based on the account number, remove it from the list of accounts.
     * @param accountNumber
     */

    public static Account[] remove( Account[] acctList2, int index ) {
        List<Account> tempList = new ArrayList<Account>(Arrays.asList(acctList2));
        tempList.remove(index);	
        return tempList.toArray(new Account[0]);
    }

    public void closeAccount(String accountNumber) throws UnknownAccountException {
        int index = Integer.parseInt(accountNumber) - 1;
        if (accountList[index].getAccountNumber().equals(accountNumber)) {
    		accountList = remove(accountList, index);
    		num--;
    	} else 
    		throw new UnknownAccountException();
    }

    /**
     * Returns the account based on the account number passed in.
     * @param accountNumber  The account number to look up and return the account.
     * @return
     */
    public Account getAccount(String accountNumber) throws UnknownAccountException {
        int index = Integer.parseInt(accountNumber) - 1;
        if (accountList[index].getAccountNumber().equals(accountNumber)) {
            acct = accountList[index];
        } else 
        	throw new UnknownAccountException();

        return acct;
    }

    /**
     * Return all accounts currently in the bank.
     * @return A list of all accounts open in the bank.
     */
    public Account[] getAllAccounts() {
        return accountList;
    }
}
