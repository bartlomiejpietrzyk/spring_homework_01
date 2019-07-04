package pl.coderslab.Homework_01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringDiApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        SimpleCustomerLogger simpleCustomerLogger = context.getBean(SimpleCustomerLogger.class);
//        simpleCustomerLogger.log();

        MemoryCustomerRepository customerRepository = context.getBean(MemoryCustomerRepository.class);
        FileCustomerLogger fileCustomerLogger = context.getBean(FileCustomerLogger.class);

        Customer customer0 = new Customer(1, "Jan", "Polaczek");
        Customer customer1 = new Customer(2, "Kajtek", "Olejura");
        Customer customer2 = new Customer(3, "Marian", "Biegły");
        Customer customer3 = new Customer(4, "Wiesiu", "Podejno");

        customerRepository.addClient(customer0);
        customerRepository.addClient(customer1);
        customerRepository.addClient(customer2);
        customerRepository.getList();
        customerRepository.removeClient(customer1);
        customerRepository.getList();
        customerRepository.addClient(customer3);
        customerRepository.getList();

        fileCustomerLogger.log();

    }

}

