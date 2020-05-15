import java.io.*;

public abstract class Account implements ITransactions {
	private int accountNumber;
	private double balance;

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public double getBalance() {
		return this.balance;
	}

	abstract public void showInfo();

	File file;
	private FileWriter writer;
	private FileReader reader;
	private BufferedReader buffer;

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

	public void readFromFile() {
		try {
			reader = new FileReader(file);
			buffer = new BufferedReader(reader);
			String text = "", temp;
			while ((temp = buffer.readLine()) != null) {
				text = text + temp + "\r" + "\n";
			}
			System.out.print(text);
			reader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void deposit(double amount) {
		writeInFile("`````````````````````````````\nBefore deposit\nBalance of account number " + accountNumber + " : " + balance);
		this.balance = balance + amount;
		writeInFile(amount + " Deposited successfully\nNew balance of account number " + accountNumber + " : " + balance + "\n`````````````````````````````");
		readFromFile();
	}

	public void withdraw(double amount) {
		if (amount <= balance) {
			writeInFile("`````````````````````````````\nBefore withdraw\nBalance of account number " + accountNumber + " : " + balance);
			this.balance = balance - amount;
			writeInFile(amount + " Withdrawn successfully\nNew balance of account number " + accountNumber + " : " + balance + "\n`````````````````````````````");
			readFromFile();
		} else {
			System.out.println("Withdraw failed\nThe account " + accountNumber + " has insufficient Balance");
		}
	}

	public void transfer(Account a, double amount) {
		if (amount <= balance) {
			writeInFile("`````````````````````````````\nBefore transferring");
			writeInFile("Balance of account number " + accountNumber + " : " + balance);
			writeInFile("Balance of account number " + a.accountNumber + " : " + a.balance);
			this.balance = balance - amount;
			a.balance = a.balance + amount;
			writeInFile(amount + " Transferred successfully from account number " + accountNumber + " to " + a.accountNumber);
			writeInFile("New balance of account number " + accountNumber + " : " + balance);
			writeInFile("New balance of account number " + a.accountNumber + " : " + a.balance + "\n`````````````````````````````");
			readFromFile();
		} else {
			System.out.println("Transfer failed\nThe account " + accountNumber + " has insufficient money to transfer");
		}
	}
}