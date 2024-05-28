package bank;

import java.util.*;

public class BankClass implements Bank {

	private static final int NUMACCOUNTS = 500;
	
	private static final int NUMCLIENTS = 50;

	private Map<String, Account> accounts;
	
	private Map<String, SortedSet<Account>> accountsperclient;

	public BankClass() {
		this.accounts = new HashMap<String, Account>(NUMACCOUNTS);
		this.accountsperclient = 
			new HashMap<String,SortedSet<Account>>(NUMCLIENTS);
	}

	public int numberOfAccounts() {
		return accounts.size();
	}

	private void addClientAccount(Account acc, String client) {
		SortedSet<Account> s = accountsperclient.get(client);
		if (s == null) {
			s = new TreeSet<Account>();
			accountsperclient.put(client,s);
		}
		s.add(acc);
	}

	public void openSavingsAccount(String client,
			double amount, int savingDays, double interestRate) {
		Account acc = new SavingsAccountClass(client, 
				new GregorianCalendar(), amount, 
				savingDays, interestRate);
		accounts.put(acc.getAccountID(), acc);
		addClientAccount(acc,client);
	}

	public void openCheckingAccount(String client, double amount) {
		Account acc = 
			new CheckingAccountClass(client, amount, 
					new GregorianCalendar());
		accounts.put(acc.getAccountID(), acc);
		addClientAccount(acc,client);
	}

	public void updateAccount(String accountID, double amount) {
		Account acc = accounts.get(accountID);
		if (acc instanceof Savings)
			((Savings)acc).updateBalance(amount);
		else if (acc instanceof Checking)
			((Checking)acc).addTransaction(new GregorianCalendar(),amount);		
	}

	public double closeAccount(String accountID) {
		Account a = accounts.remove(accountID);
		Set<Account> s = accountsperclient.get(a.getClient());
		s.remove(a);
		if (s.isEmpty())
			accountsperclient.remove(a.getClient());
		return a.getBalance();
	}

	public boolean isThereAccount(String accountID) {
		return accounts.containsKey(accountID);
	}

	public boolean isThereClient(String client) {
		return accountsperclient.containsKey(client);
	}

	public boolean canWithdraw(String accountID, double amount) {
		Account a = accounts.get(accountID);
		return a.canWithdraw(amount);
	}

	@Override
	public boolean isSavings(String accountID) {
		Account a = accounts.get(accountID);
		return a instanceof Savings;
	}

	@Override
	public boolean isChecking(String accountID) {
		Account a = accounts.get(accountID);
		return a instanceof Checking;
	}

	public Iterator<String> accountsIDs() {
		return accounts.keySet().iterator();
	}

	public Iterator<String> clients() {
		return accountsperclient.keySet().iterator();
	}

	public Iterator<Account> accounts() {
		return accounts.values().iterator();
	}

	public Iterator<Account> accounts(String client) {
		return accountsperclient.get(client).iterator();
	}

	public Iterator<Account> accountsBalanceGreaterThan(double amount) {
		return new RichAccountsIterator(accounts.values().iterator(),amount);
	}

	@Override
	public Iterator<Account> accountsInterestGreaterThan(double rate) {
		return new ProfitableAccountsIterator(accounts.values().iterator(),rate);
	}

	@Override
	public Iterator<Account> accountsToPayInterestToday() {
		return new DueAccountsIterator(accounts.values().iterator(), new GregorianCalendar());
	}

	@Override
	public Iterator<Account> accountsClients(String[] clients) {
		return new ClientAccountsIterator(accountsperclient, clients);
	}

	@Override
	public Iterator<Transaction> getTransactions(String accountID) {
		Checking c = (Checking)accounts.get(accountID);
		return c.getTransactions();
	}

	@Override
	public void updateInterests(String accountID) {
		Savings s = (Savings)accounts.get(accountID);
		s.updateInterests(new GregorianCalendar());
	}
}
