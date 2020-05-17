
public class SavingsAccount extends Account {
    public SavingsAccount(){}
    public SavingsAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }
    protected double interestRate ;
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    @Override
    public void showInfo() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Account ID: " + accountNumber); 
        System.out.println("Saving Balance: " + balance);
    }   
}