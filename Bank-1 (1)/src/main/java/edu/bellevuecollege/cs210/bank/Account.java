package edu.bellevuecollege.cs210.bank;

import edu.bellevuecollege.cs210.bank.exceptions.NonSufficientFundsException;
import java.math.BigDecimal;

public class Account {


    /**
     * Create a new account with the information passed in.
     * @param firstName First name of the account holder.
     * @param lastName Last name of the account holder.
     * @param acctNo Account number to create the account with.
     */
    private String firstName;
    private String lastName;
    private String acctNo;
    private BigDecimal balance;

    public Account(String firstName, String lastName, String acctNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.acctNo = acctNo;
        balance = new BigDecimal(0);
    }


    /**
     * Deposit the amount passed into the function, the balance should reflect this deposit.
     * @param depositAmount Amount to deposit into the account.
     * @return The balance after the deposit.
     * @throws NonSufficientFundsException
     */
    public BigDecimal deposit(BigDecimal depositAmount) throws NonSufficientFundsException {
        if (depositAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NonSufficientFundsException();
        } else {
            balance = balance.add(depositAmount);
        }

        return balance;
    }

    /**
     * Withdraws the amount passed in from the bank account, the balance should reflect this withdrawal.
     * @param withdrawalAmount Amount to withdraw from the account.
     * @return The balance after the withdrawal.
     * @throws NonSufficientFundsException Thrown if there are insufficient funds in the account.
     */
    public BigDecimal withdraw(BigDecimal withdrawalAmount) throws NonSufficientFundsException {
        if (withdrawalAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NonSufficientFundsException();
        } else {
            if (balance.compareTo(withdrawalAmount) == -1) {
                throw new NonSufficientFundsException();
            } else {
                balance = balance.subtract(withdrawalAmount);
            }
        }

        return balance;
    }

    /**
     * Returns the balance of the account.
     * @return The balance of the account.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountNumber() {
        return acctNo;
    }
}
