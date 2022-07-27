
public class InterfaceTest {

	public static void main(String[] args) {
		
		CurrentAcc ca = new CurrentAcc();
		SavingsAcc sa = new SavingsAcc();
		
		FundTransferServiceMethod.transfer(ca, sa, 50000);
		
		System.out.println("balance : "+ca.balance);
		System.out.println("balance : "+sa.balance);
		
	}

}


interface Withdrawing1
{
	public void withdraw(float amount);
}

interface Depositing1
{
	void deposit(float amount);
}

class CurrentAcc implements Withdrawing1, Depositing1
{
	float balance=80000;
	public void withdraw(float amount)
	{
		balance = balance - amount;
	}
	
	public void deposit(float amount)
	{
		balance = balance + amount; 
	}
	
	
	
}

class SavingsAcc implements Withdrawing1, Depositing1
{
	float balance=20000;
	public void deposit(float amount)
	{
		balance = balance + amount;
	}
	
	public void withdraw(float amount)
	{
		balance = balance - amount;
	}
}

class FundTransferServiceMethod
{
	public static void transfer(Withdrawing1 c, Depositing1 s, float amount)
	{
		System.out.println("********Transfer Initiated********");
		c.withdraw(amount);
		s.deposit(amount);
		System.out.println("********Transfer Done********");
	}
}