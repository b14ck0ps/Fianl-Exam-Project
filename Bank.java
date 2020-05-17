public class Bank extends Customer implements CustomerOperations, EmployeeOperations {
    Customer customers[];
    Employee employees[];
    static int indexEmp = 0;
    static int indexCuss = 0;
    static final int MAX_PPL = 100;

    Bank() {
        customers = new Customer[MAX_PPL];
        employees = new Employee[MAX_PPL];
    }

    // ------------------------EMPLOYEE----------------------------//
    @Override
    public void insertEmployee(Employee e) {
        employees[indexEmp] = e;
        indexEmp++;
        System.out.println("Employee Added successfully");
    }

    @Override
    public void removeEmployee(Employee e) {
        int id = Integer.parseInt(e.empId);
        int i, j, k;
        for (i = 0; i < indexEmp; i++) {
            int emId = Integer.parseInt(employees[i].empId);
            if (emId == id) { // searching for id match
                for (k = i; k <= indexEmp - i; k++) {
                    for (j = 0; j < indexEmp - i; j++) {
                        employees[k] = employees[k + 1]; // replace found element with next element
                        System.out.println(emId + " has been removed");
                    }
                }
                indexEmp--;
                break;
            }
        }
    }

    @Override
    public Employee getEmployee(int empId) {
        Employee emp = null;
        int id = empId;
        for (int i = 0; i < indexEmp; i++) {
            int temp = Integer.parseInt(employees[i].empId);
            if (id == temp)
                return employees[i];
        }
        return emp;
    }

    @Override
    public void showAllEmployees() {
        if (indexEmp == 0) {
            System.out.println("No Employee!");
        } else {
            for (int i = 0; i < indexEmp; i++) {
                System.out.println("Name  : " + this.employees[i].name);
                System.out.println("ID    : " + this.employees[i].empId);
                System.out.println("Salary: " + this.employees[i].salary+ " Taka");
                System.out.println();
            }
        }
    }

    // -----------------------------CUSTOMER--------------------------------------//
    @Override
    public void insertCustomer(Customer c) {
        customers[indexCuss] = c;
        indexCuss++;
        System.out.println("Customer Added successfully");
    }

    @Override
    public void removeCustomer(Customer c) {
        int nid = c.nid;
        int i, j, k;
        for (i = 0; i < indexCuss; i++) {
            int cussId = customers[i].nid;
            if (cussId == nid) {
                for (k = i; k <= indexCuss - i; k++) {
                    for (j = 0; j < indexCuss - i; j++) {
                        customers[k] = customers[k + 1];
                        System.out.println(cussId + " has been removed");
                    }
                }
                indexCuss--;
                break;
            }
        }
    }

    @Override
    public Customer getCustomer(int nid) {
        Customer cus = null;
        int id = nid;
        for (int i = 0; i < indexCuss; i++) {
            int temp = customers[i].nid;
            if (id == temp)
                return customers[i];
        }
        return cus;
    }

    @Override
    public void showAllCustomers() {
        if (indexCuss == 0) {
            System.out.println("No Customer!");
        } else {
            for (int i = 0; i < indexCuss; ++i) {
                System.out.println("Name    : " + this.customers[i].name);
                System.out.println("NID     : " + this.customers[i].nid);
                System.out.println();
            }
        }
    }
}