import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import junit.framework.*;


public class SavingsAccountTest extends TestCase{

	SavingsAccount testAccount;
	@Before
	public void setUp() throws Exception 
	{
		testAccount = new SavingsAccount("Mason Silber", 1000);
	}

	public void testBalanceReset()
	{
		testAccount.resetBalance();
		Assert.assertEquals(testAccount.getBalance(), 1000, 0.0);
	}
	
	public void testDeposit()
	{
		testAccount.resetBalance();
		double depositAmount = 100;
		testAccount.deposit(depositAmount);
		Assert.assertEquals(testAccount.getBalance(),depositAmount+1000,0.0);
	}
	
	public void testSetBalance()
	{
		testAccount.setBalance(1500);
		Assert.assertEquals(testAccount.getBalance(), 1500.0);
	}
	
	public void testWithdrawl()
	{
		testAccount.resetBalance();
		double withdrawlAmount = 100;
		testAccount.withdraw(withdrawlAmount);
		Assert.assertEquals(testAccount.getBalance(), 1000-withdrawlAmount,0.0);
	}
	
	public void testOverdraft()
	{
		testAccount.resetBalance();
		double withdrawlAmount = testAccount.getBalance() + 50;
		testAccount.withdraw(withdrawlAmount);
		Assert.assertEquals(testAccount.getBalance(), 1000 - withdrawlAmount - 20, 0.0);
	}
	
	public void testInterest()
	{
		testAccount.resetBalance();
		testAccount.computeInterest();
		Assert.assertEquals(testAccount.getBalance(), 1000*(1+SavingsAccount.interestRate));
	}
	
	public void testTransactionLog()
	{
		testAccount.resetBalance();
		testAccount.deposit(100);
		testAccount.withdraw(200);
		testAccount.deposit(450);
		ArrayList<Double> expectedTransactions = new ArrayList<Double>(Arrays.asList(100.0,-200.0,450.0));
		Assert.assertEquals(testAccount.getTransactions(),expectedTransactions);
	}
	
	public void testFirstSequence()
	{
		testAccount.deposit(1000);
		testAccount.withdraw(100);
		testAccount.withdraw(100);
		testAccount.withdraw(100);
		Assert.assertEquals(testAccount.getBalance(), 1700.);
	}
	
	public void testSecondSequence()
	{
		testAccount.deposit(1000);
		testAccount.withdraw(1000);
		testAccount.withdraw(1000);
		testAccount.withdraw(100);
		//Expected value is -120 because of the $20 overdraft fee
		Assert.assertEquals(testAccount.getBalance(), -120.);
	}
	
	public void testSetInterestRate()
	{
		testAccount.setInterestRate(0.02);
		Assert.assertEquals(testAccount.getInterestRate(), 0.02);
	}
	@After
	public void tearDown() throws Exception 
	{
		
	}

}
