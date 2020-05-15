import java.util.Scanner;

public class Starts {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String name, empId;
        int nid, accountNumber, tenureYear;
        double salary, balance, interestRate, amount;
        try {
            Bank bank = new Bank();
            Customer existingCustomer = new Customer();
            System.out.println("~~~~~ Welcome to the Bank ~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            int option;
            do {
                menu();
                System.out.print("\nEnter Option: ");
                option = input.nextInt();
                input.nextLine();
                switch (option) {
                    case 1:
                        Employee newEmployee = new Employee();
                        emMenu();
                        System.out.print("\nEnter Option: ");
                        option = input.nextInt();
                        input.nextLine();
                        switch (option) {
                            case 1:
                                System.out.print("Enter the name of employee: ");
                                name = input.nextLine();
                                newEmployee.setName(name);
                                System.out.print("Enter employee's ID:  ");
                                empId = input.nextLine();
                                newEmployee.setEmpId(empId);
                                System.out.print("Enter employee's salary:  ");
                                salary = input.nextDouble();
                                newEmployee.setSalary(salary);
                                bank.insertEmployee(newEmployee);
                                break;
                            case 2:
                                System.out.print("Enter employee's ID:  ");
                                empId = input.nextLine();
                                bank.removeEmployee(bank.getEmployee(empId));
                                break;
                            case 3:
                                bank.showAllEmployees();
                                break;
                            default:
                                System.out.println("No such option\nPlease select another option");
                                break;
                        }
                        break;
                    case 2:
                        Customer newCustomer = new Customer();
                        cusMenu();
                        System.out.print("\nEnter Option: ");
                        option = input.nextInt();
                        input.nextLine();
                        switch (option) {
                            case 1:
                                System.out.print("Enter the name of customer:  ");
                                name = input.nextLine();
                                newCustomer.setName(name);
                                System.out.print("Enter customer's NID:  ");
                                nid = input.nextInt();
                                input.nextLine();
                                newCustomer.setNid(nid);
                                bank.insertCustomer(newCustomer);
                                break;
                            case 2:
                                System.out.print("Enter customer's NID:  ");
                                nid = input.nextInt();
                                input.nextLine();
                                bank.removeCustomer(bank.getCustomer(nid));
                                break;
                            case 3:
                                bank.showAllCustomers();
                                break;
                            default:
                                System.out.println("No such option\nPlease select another option");
                                break;
                        }
                        break;
                    case 3:
                        acMenu();
                        System.out.print("\nEnter Option: ");
                        option = input.nextInt();
                        input.nextLine();
                        switch (option) {
                            case 1:
                                System.out.println("1. Savings Account\n2. Fixed Account");
                                System.out.print("\nEnter Option: ");
                                option = input.nextInt();
                                input.nextLine();
                                switch (option) {
                                    case 1:
                                        SavingsAccount s = new SavingsAccount();
                                        System.out.print("Enter account number:  ");
                                        accountNumber = input.nextInt();
                                        input.nextLine();
                                        s.setAccountNumber(accountNumber);
                                        System.out.print("Enter account's balance:  ");
                                        balance = input.nextDouble();
                                        input.nextLine();
                                        s.setBalance(balance);
                                        System.out.print("Enter account's interest rate:  ");
                                        interestRate = input.nextDouble();
                                        input.nextLine();
                                        s.setInterestRate(interestRate);
                                        existingCustomer.insertAccount(s);
                                        break;
                                    case 2:
                                        FixedAccount f = new FixedAccount();
                                        System.out.print("Enter account number:  ");
                                        accountNumber = input.nextInt();
                                        input.nextLine();
                                        f.setAccountNumber(accountNumber);
                                        System.out.print("Enter account's balance:  ");
                                        balance = input.nextDouble();
                                        input.nextLine();
                                        f.setBalance(balance);
                                        System.out.print("Enter account's tenure year:  ");
                                        tenureYear = input.nextInt();
                                        input.nextLine();
                                        f.setTenureYear(tenureYear);
                                        existingCustomer.insertAccount(f);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 2:
                                System.out.print("Enter account number:  ");
                                accountNumber = input.nextInt();
                                input.nextLine();
                                existingCustomer.removeAccount(existingCustomer.getAccount(accountNumber));
                                break;
                            case 3:
                                existingCustomer.showAllAccounts();
                                break;
                            default:
                                System.out.println("No such option\nPlease select another option");
                                break;
                        }
                        break;
                    case 4:
                        trnMenu();
                        System.out.print("\nEnter Option: ");
                        option = input.nextInt();
                        input.nextLine();
                        switch (option) {
                            case 1:
                                System.out.print("Enter account number in which you want to deposit money:  ");
                                accountNumber = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter amount of money to deposit:  ");
                                amount = input.nextDouble();
                                input.nextLine();
                                (existingCustomer.getAccount(accountNumber)).deposit(amount);
                                break;
                            case 2:
                                System.out.print("Enter account number from which you want to withdraw money:  ");
                                accountNumber = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter amount of money to withdraw:  ");
                                amount = input.nextDouble();
                                input.nextLine();
                                (existingCustomer.getAccount(accountNumber)).withdraw(amount);
                                break;
                            case 3:
                                int transferFrom, transferTo;
                                System.out.print("Enter account number from which you want to transfer money:  ");
                                transferFrom = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter account number to which you want to transfer money:  ");
                                transferTo = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter amount of money to transfer:  ");
                                amount = input.nextDouble();
                                input.nextLine();
                                (existingCustomer.getAccount(transferFrom))
                                        .transfer(existingCustomer.getAccount(transferTo), amount);
                                break;
                            default:
                                System.out.println("No such option\nPlease select another option");
                                break;
                        }
                        break;
                    default:
                        System.out.println("No such option\nPlease select another option");
                        break;
                }
            } while (option != 5);
        } catch (Exception ex) {
            System.out.println("Wrong input\nProgram exited");
        }
        input.close();
    }

    public static void menu() {
        System.out.println("```````````MAIN MENU```````````");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Account Management");
        System.out.println("4. Account Transactions");
        System.out.println("5. EXIT");
    }

    public static void emMenu() {
        System.out.println("```````````EMPLOYEE MENU```````````");
        System.out.println("1. Insert New Employee");
        System.out.println("2. Remove Existing Employee");
        System.out.println("3. Show All Employees");
    }

    public static void cusMenu() {
        System.out.println("```````````CUSTOMER MENU```````````");
        System.out.println("1. Insert New Customer");
        System.out.println("2. Remove Existing Customer");
        System.out.println("3. Show All Customer");
    }

    public static void acMenu() {
        System.out.println("```````````Account  Management```````````");
        System.out.println("1. Insert New Account");
        System.out.println("2. Remove Existing Account");
        System.out.println("3. Show All Account");
    }

    public static void trnMenu() {
        System.out.println("```````````Account Transactions```````````");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
    }
}