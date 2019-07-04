package pl.coderslab.Homework_01;

import java.util.ArrayList;
import java.util.List;

public class MemoryCustomerRepository implements CustomerRepository {
    private FileCustomerLogger fileCustomerLogger;

    List<Customer> customerList = new ArrayList<>();

    public MemoryCustomerRepository(FileCustomerLogger fileCustomerLogger) {
        this.fileCustomerLogger = fileCustomerLogger;
    }

    @Override
    public void addClient(Customer customer) {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        customerList.add(customer);
        fileCustomerLogger.log(methodName + " " + customer.getId());
    }

    @Override
    public void removeClient(Customer customer) {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        customerList.remove(customer);
        fileCustomerLogger.log(methodName + " ID: " + customer + " removed.");

    }

    public void getList() {
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        for (Customer customers : this.customerList) {
            System.out.println(customers);
            fileCustomerLogger.log(methodName);
        }
    }


}
