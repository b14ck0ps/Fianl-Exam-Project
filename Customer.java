public class Customer implements AccountOperations
{
	private String name;
	private int nid;
	final static int MAC_ACC = 50;
	static int index=0;
	private Account[] accounts=new Account[MAC_ACC];

	public void setName(String name)
	{
		this.name=name;
	}
	public void setNid(int nid)
	{
		this.nid=nid;
	}
	public String getName()
	{
		return this.name;
	}
	public int getNid()
	{
		return this.nid;
	}

	public void insertAccount(Account a)
	{
		try
		{
			accounts[index]=a;
			index++;
			System.out.println("Account inserted successfully");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Account insertion failed\nMaximum "+accounts.length+" accounts can be created");
		}
	}
	public void removeAccount(Account a)
	{
		int count=0;
		if(a!=null)
		{
			for(index=0;index<accounts.length;index++)
			{
				if(accounts[index]==a)
				{
					if(index==(accounts.length-1))
					{
						accounts[index]=null;
						count++;
					}
					else
					{
						for(int k=index;k<(accounts.length-1);k++)
						{
							accounts[k]=accounts[k+1];
							if((k+1)==(accounts.length-1))
							{
								accounts[k+1]=null;
							}
						}
						count++;
						break;			
					}
				}
			}
			if(count==0)
			{
				System.out.println("Account number not found");
			}
			else
			{
				System.out.println("Account removed successfully");
			}
		}
	}
	public Account getAccount(int accountNumber)
	{
		try
		{
			for(index=0;index<accounts.length;index++)
			{
				if(accounts[index].getAccountNumber()==accountNumber)
				{
					return accounts[index];
				}
			}
		}
		catch(NullPointerException ex)
		{
			System.out.println("Account number not found");
		}
		return null;
	}
	public void showAllAccounts()
	{
		for(index=0;index<accounts.length;index++)
		{
			if(accounts[index]!=null)
			{
				System.out.println("<=================================>");
				System.out.println("Details of Account "+(index+1)+":");
				System.out.println("Account number: "+accounts[index].getAccountNumber());
				System.out.println("Balance: "+accounts[index].getBalance());
				System.out.println("<=================================>");
			}
			else
			{
				break;
			}
		}
	}
}