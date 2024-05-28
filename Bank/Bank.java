package bank;

import java.util.*;

public interface Bank {
	int numberOfAccounts();

	void openCheckingAccount(String client, double amount);
	void openSavingsAccount(String client, double amount, 
			int savingDays, double interestRate);
	double closeAccount(String accountID);

	boolean isThereAccount(String accountID);
	boolean isThereClient(String client);
	boolean canWithdraw(String accountID, double amount);
	boolean isSavings(String accountID);
	boolean isChecking(String accountID);
	
	Iterator<String> accountsIDs();
	Iterator<String> clients();  

	Iterator<Account> accounts();
	
	Iterator<Account> accounts(String client);
	Iterator<Account> accountsClients(String[] clients);
	Iterator<Account> accountsBalanceGreaterThan(double amount);	
	
	Iterator<Account> accountsInterestGreaterThan(double rate);
	Iterator<Account> accountsToPayInterestToday();

	Iterator<Transaction> getTransactions(String accountID);
	
	public void updateInterests(String accountID);
	
	public void updateAccount(String accountID, double amount);

}
