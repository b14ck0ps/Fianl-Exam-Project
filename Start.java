import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        String empName, cusName, empId;
        int option, salary, amount, cusId, intId, nid, accId, tenureYear;
        double interestRate;
        Bank bank = new Bank();
        Employee[] emp = new Employee[Bank.MAX_PPL];
        Customer[] cus = new Customer[Bank.MAX_PPL];
        Account[] account = new Account[Customer.MAX_ACC];
        int eIndex = 0;
        int cIndex = 0;
        int accIndex = 0;
        Scanner scan = new Scanner(System.in);
        do {
            menu();
            System.out.print("Option: ");
            option = scan.nextInt();
            switch (option) {
                case 1: // Employee Option
                    while (option != 0) {
                        emMenu();
                        System.out.print("Option: ");
                        option = scan.nextInt();
                        switch (option) {
                            case 1:
                                System.out.print("Enter Name: ");
                                empName = scan.next();
                                System.out.print("Enter ID: ");
                                empId = scan.next();
                                System.out.print("Enter Salary: ");
                                salary = scan.nextInt();
                                emp[eIndex] = new Employee(empName, empId, salary);
                                bank.insertEmployee(emp[eIndex]);
                                eIndex++;
                                break;
                            case 2:
                                System.out.print("Enter ID: ");
                                empId = scan.next();
                                intId = Integer.parseInt(empId);
                                if (bank.getEmployee(intId) != null) {
                                    bank.removeEmployee(bank.getEmployee(intId));
                                } else
                                    System.out.println("Account doesn't exist . ");
                                break;
                            case 3:
                                System.out.println();
                                bank.showAllEmployees();
                                break;
                            default:
                        }
                    }
                    break;
                case 2: // Customer Option
                    while (option != 0) {
                        cusMenu();
                        System.out.print("Option: ");
                        option = scan.nextInt();
                        switch (option) {
                            case 1:
                                System.out.print("Enter Name: ");
                                cusName = scan.next();
                                System.out.print("Enter NID: ");
                                cusId = scan.nextInt();
                                cus[cIndex] = new Customer(cusName, cusId);
                                bank.insertCustomer(cus[cIndex]);
                                cIndex++;
                                break;
                            case 2:
                                System.out.print("Enter ID: ");
                                cusId = scan.nextInt();
                                if (bank.getCustomer(cusId) != null) {
                                    bank.removeCustomer(bank.getCustomer(cusId));
                                } else
                                    System.out.println("Account doesn't exist . ");
                                break;
                            case 3:
                                System.out.println();
                                bank.showAllCustomers();
                                break;
                            default:
                        }
                    }
                    break;
                case 3: // account mng
                    mngMenu();
                    System.out.print("\nEnter Option: ");
                    option = scan.nextInt();
                    scan.nextLine();
                    switch (option) {
                        case 1:
                            System.out.println("1. Fixed Account \n2. Savings Account");
                            System.out.print("\nEnter Option: ");
                            option = scan.nextInt();
                            scan.nextLine();
                            switch (option) {
                                case 1: // Saving account
                                    FixedAccount f = new FixedAccount();
                                    System.out.print("Enter ID: ");
                                    accId = scan.nextInt();
                                    if (bank.getCustomer(accId) != null) {
                                        System.out.print("Enter account's tenure year:  ");
                                        tenureYear = scan.nextInt();
                                        f.setTenureYear(tenureYear);
                                        account[accIndex] = new FixedAccount(accId, 0);
                                        bank.insertAccount(account[accIndex]);
                                        accIndex++;
                                    } else {
                                        System.out.println("Account doesn't exist . Please Create a Customer account");
                                        option = 0;
                                    }
                                    break;
                                case 2: // Fixed Account
                                    SavingsAccount s = new SavingsAccount();
                                    System.out.print("Enter ID: ");
                                    accId = scan.nextInt();
                                    if (bank.getCustomer(accId) != null) {
                                    System.out.print("Enter account's interest rate:  ");
                                    interestRate = scan.nextDouble();
                                    s.setInterestRate(interestRate);
                                    account[accIndex] = new SavingsAccount(accId, 0);
                                    bank.insertAccount(account[accIndex]);
                                    accIndex++;
                                } else {
                                    System.out.println("Account doesn't exist . Please Create a Customer account");
                                    option = 0;
                                }
                                    break;
                            }
                            break;
                        case 2:
                            System.out.print("Enter ID: ");
                            accId = scan.nextInt();
                            bank.removeAccount(bank.getAccount(accId));
                            break;
                        case 3:
                            System.out.println();
                            bank.showAllAccounts();
                            break;
                        default:
                            System.out.println("No such option\nPlease select another option");
                            break;
                    }
                    break;
                case 4: // Account Transactions
                    while (option != 0) {
                        trnMenu();
                        System.out.print("Option: ");
                        option = scan.nextInt();
                        switch (option) {
                            case 1:// deposit
                                System.out.print("Enter Account ID/NID: ");
                                nid = scan.nextInt();
                                if (bank.getCustomer(nid) != null) {
                                    if (bank.getAccount(nid) != null) {
                                        System.out.print("How much amount you want to deposit: ");
                                        amount = scan.nextInt();
                                        bank.getAccount(nid).deposit(amount);
                                    } else {
                                        System.out.println("Account wasn't Created. Please Create an account from Account Management.");
                                        option = 0;
                                    }
                                } else
                                    System.out.println("Account doesn't exist . Please Create a Customer account");
                                break;
                            case 2:// withdraw
                                System.out.print("Enter Account ID/NID: ");
                                nid = scan.nextInt();
                                if (bank.getCustomer(nid) != null) {
                                    if (bank.getAccount(nid) != null) {
                                        System.out.print("How much amount you want to withdraw: ");
                                        amount = scan.nextInt();
                                        bank.getAccount(nid).withdraw(amount);
                                    } else
                                        System.out.println("Account wasn't Created. Please Create an account from Account Management.");
                                    option = 0;
                                } else
                                    System.out.println("Account doesn't exist . Please Create a Customer account");
                                break;
                            case 3:// transfer
                                System.out.print("Enter Your Account ID/NID: ");
                                nid = scan.nextInt();
                                if (bank.getCustomer(nid) != null) {
                                    if (bank.getAccount(nid) != null) {
                                        int tempId = nid;
                                        System.out.print("Enter Transfer Account ID/NID: ");
                                        nid = scan.nextInt();
                                        if (bank.getCustomer(nid) != null) {
                                            if (bank.getAccount(nid) != null) {
                                                System.out.print("How much amount you want to Transfer: ");
                                                amount = scan.nextInt();
                                                bank.getAccount(tempId).transfer(bank.getAccount(nid), amount);
                                            } else {
                                                System.out.println("Account wasn't Created. Please Create an account from Account Management.");
                                            }
                                        } else {
                                            System.out.println("Account doesn't exist . Please Create a Customer account");
                                        }
                                    } else {
                                        System.out.println("Account wasn't Created. Please Create an account from Account Management.");
                                    }
                                } else {
                                    System.out.println("Account doesn't exist . Please Create a Customer account");
                                }
                                break;
                            case 4: // personal info
                                System.out.println("Enter Account ID/NID: ");
                                nid = scan.nextInt();
                                if (bank.getCustomer(nid) != null) {
                                    if (bank.getAccount(nid) != null) {
                                        System.out.println("Name    : " + bank.getCustomer(nid).name);
                                        System.out.println("ID      : " + nid);
                                        System.out.println("Balance : " + bank.getAccount(nid).balance);
                                    } else {
                                        System.out.println("Account wasn't Created. Please Create an account from Account Management.");
                                    }
                                } else {
                                    System.out.println("Account doesn't exist . Please Create a Customer account");
                                }
                            default:
                                break;
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("wrong choice");
                    break;
            }
        }while (option != 5);
        scan.close();
    }

    public static void menu() {
        System.out.println("-------MAIN MENU-----------");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Account Management");
        System.out.println("4. Account Transactions");
        System.out.println("5. Exit");
    }

    public static void emMenu() {
        System.out.println("-------EMPLOYEE MENU---------");
        System.out.println("1. Insert New Employee");
        System.out.println("2. Remove Existing Employee");
        System.out.println("3. Show All Employees");
        System.out.println("0. Main Menu");
    }

    public static void cusMenu() {
        System.out.println("-------CUSTOMER MENU-----------");
        System.out.println("1. Insert New Customer");
        System.out.println("2. Remove Existing Customer");
        System.out.println("3. Show All Customer");
        System.out.println("0. Main Menu");
    }

    public static void mngMenu() {
        System.out.println("-------Account  Management-----------");
        System.out.println("1. Insert New Account");
        System.out.println("2. Remove Existing Account");
        System.out.println("3. Show All Account");
        System.out.println("0. Main Menu");
    }

    public static void trnMenu() {
        System.out.println("--------Account Transactions------");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Account INFO");
        System.out.println("0. Main Menu");
    }
}
