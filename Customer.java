public class Customer extends Account implements AccountOperations {
    String name;
    int nid;
    Account[] accounts;
    final static int MAX_ACC = 100;
    static int index = 0;

    Customer() {
        super();
        accounts = new Account[MAX_ACC];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getName() {
        return name;
    }

    public int getNid() {
        return nid;
    }

    @Override
    public void showInfo() {
    }

    // -----------------ACCOUNT---------------------//
    @Override
    public void insertAccount(Account a) {
        accounts[index] = a;
        index++;
        System.out.println("Account created successfully");
    }

    @Override
    public void removeAccount(Account a) {
        int accountNumber = a.accountNumber;
        int i, j, k;
        for (i = 0; i < index; i++) {
            int accId = accounts[i].accountNumber;
            if (accId == accountNumber) {
                for (k = i; k <= index - i; k++) {
                    for (j = 0; j < index - i; j++) {
                        accounts[k] = accounts[k + 1];
                        System.out.println(accId + " has been removed");
                    }
                }
                index--;
                break;
            }
        }
    }

    @Override
    public Account getAccount(int accountNumber) {
        Account acc = null;
        int id = accountNumber;
        for (int i = 0; i < index; i++) {
            int temp = accounts[i].accountNumber;
            if (id == temp)
                return accounts[i];
        }
        return acc;
    }

    @Override
    public void showAllAccounts() {
        if (index == 0) {
            System.out.println("No Account Found!");
        } else {
            for (int i = 0; i < index; ++i) {
                System.out.println(i + 1 + ". Account Number: " + accounts[i].accountNumber);
                // System.out.println("Balance : " + accounts[i].balance);
                System.out.println();
            }
        }
    }

    public Customer(String name, int nid) {
        super();
        this.name = name;
        this.nid = nid;
    }
}