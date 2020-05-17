import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Account implements ITransactions {
    int accountNumber;
    double balance;
    public abstract void showInfo();
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    File file;
	private FileWriter writer;
	public void writeInFile(String s) {
		try {
			file = new File("Transactions.txt");
			file.createNewFile();
			writer = new FileWriter(file, true);
			writer.write(s + "\r\n");
			writer.flush();
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
    public void deposit(double amount) {
        if (amount > 0) {
            writeInFile("=============================================================\nBefore deposit\nBalance of account number " + accountNumber + " : " + balance);
            balance += amount;
            System.out.println(amount + " taka added to  your balance.");
            writeInFile(amount + " Deposited successfully\nNew balance of account number " + accountNumber + " : " + balance + "\n=============================================================");
        } else {
            System.out.println("Enter valid amount");
        }
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            writeInFile("=============================================================\nBefore withdraw\nBalance of account number " + accountNumber + " : " + balance);
            System.out.println("Withdrawing.....");
            System.out.println("Complete!");
            balance -= amount;
            writeInFile(amount + " Withdrawn successfully\nNew balance of account number " + accountNumber + " : " + balance + "\n============================================================="); 
        } else {
            System.out.println("Insufficient balance");
        }
    }
    public void transfer(Account a, double amount) {
        if (amount <= balance) {
            writeInFile("=============================================================\nBefore transferring");
			writeInFile("Balance of account number " + accountNumber + " : " + balance);
			writeInFile("Balance of account number " + a.accountNumber + " : " + a.balance);
            System.out.println("Transferring.....");
            System.out.println("Complete!");
            balance -= amount;
            a.balance += amount;
            writeInFile(amount + " Transferred successfully from account number " + accountNumber + " to " + a.accountNumber);
			writeInFile("New balance of account number " + accountNumber + " : " + balance);
			writeInFile("New balance of account number " + a.accountNumber + " : " + a.balance + "\n=============================================================");
        } else {
            System.out.println("Insufficient balance");
        }
    }
	public Account() {
    }
}