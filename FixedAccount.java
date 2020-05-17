
public class FixedAccount extends Account {
    public FixedAccount(){}
    public FixedAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }
    protected int tenureYear;
    public int getTenureYear() {
        return tenureYear;
    }
    public void setTenureYear(int tenureYear) {
        this.tenureYear = tenureYear;
    }
	@Override
	public void showInfo() {
	}
}