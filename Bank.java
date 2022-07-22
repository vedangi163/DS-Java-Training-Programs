

public class Bank {
	public static void main(String args[]) 
	{
		BankAccount baObj1 = new BankAccount();
		BankAccount baObj2 = new BankAccount();
		
		baObj1.setbankAccount(1001, "Vedangi", 75000);
		baObj2.setbankAccount(1002, "Shital", 75300);
		
		baObj1.printBankAccount();
		baObj2.printBankAccount();
		
		baObj1.withraw(6000);
		baObj2.deposit(6000);
		
		baObj1.printBankAccount();
		baObj2.printBankAccount();
	
	}
}


class BankAccount
{
	int accNo;
	String accHolderName;
	double balance;
	
	void setbankAccount(int x, String y, float z)
	{
		accNo = x;
		accHolderName = y;
		balance =z;
	}
	
	double calculateSimpleInterest(int rateOfInterest, int period)
	{
		double simpleInterest = (balance*rateOfInterest*period)/100.0f;
		return simpleInterest;
	}
	
	void withraw(double amountToWithdraw)
	{
		System.out.println("Windraw "+amountToWithdraw);
		balance = balance - amountToWithdraw;
	}
	
	void deposit(double amountToDeposit)
	{
		System.out.println("Deposit "+amountToDeposit);
		balance = balance + amountToDeposit;
		
	}

	double getBalance()
	{
		return balance;
	}
	
	void printBankAccount()
	{
		System.out.println("Account No: "+accNo);
		System.out.println("Account holder name: "+accHolderName);
		System.out.println("Balance : "+balance);
		System.out.println("----------------------------");
	}
	
	
	
	
}


