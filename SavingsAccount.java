import java.util.ArrayList;

/**
 * SavingsAccount
 * @author MasonSilber
 * This method models a savings account
 */
public class SavingsAccount {
	
	private String name;
	private double balance;
	public static double interestRate = 0.014;//arbitrary
	private ArrayList<Double> transactions;
	
	/**
	 * Constructor
	 * @param customer The name of the customer
	 * @param initialBalance Initial balance in the account
	 */
	public SavingsAccount(String customer, double initialBalance)
	{
		name = customer;
		balance = initialBalance;//Starting amount
		transactions = new ArrayList<Double>();
	}
	
	/**
	 * Set Interest Rate
	 * @param rate The rate to which you set the account's interest rate
	 */
	public void setInterestRate(double rate)
	{
		interestRate = rate;
	}
	
	/**
	 * Set Balance
	 * @param newBalance The balance to which you set the account's balance
	 */
	public void setBalance(double newBalance)
	{
		balance = newBalance;
	}
	
	/**
	 * Get Interest Rate
	 * @return Interest Rate
	 */
	public double getInterestRate()
	{
		return interestRate;
	}
	
	/**
	 * Get Name
	 * @return Name of customer
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get Balance
	 * @return Account's balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Get Transactions
	 * @return List of Transactions
	 */
	public ArrayList<Double> getTransactions()
	{
		return transactions;
	}
	
	/**
	 * Deposit
	 * @param deposit the amount being deposited
	 */
	public void deposit(double deposit)
	{
		balance += deposit;
		transactions.add(deposit);
	}
	
	/**
	 * Withdraw
	 * @param withdrawl the amount being withdrawn
	 */
	public void withdraw(double withdrawl)
	{
		double overdraftFee = 20;
		balance -= withdrawl;
		transactions.add(-1*withdrawl);
		if(balance < 0)
		{
			System.err.println("You've overdrafted your account. A $20 fee will be assessed.");
			balance -= overdraftFee;
		}
	}
	
	/**
	 * Compute interest
	 * When interest is computed is arbitrary (most often continuous compounding),
	 * so I just have a computeInterest method which adds the interest to the money in the account
	 */
	public void computeInterest()
	{
		balance *= (1+interestRate);
	}
	
	/**
	 * Reset balance
	 * This is for convenience when using JUnit test cases
	 */
	public void resetBalance()
	{
		balance = 1000;
	}
}
