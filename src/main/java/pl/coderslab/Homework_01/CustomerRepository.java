package pl.coderslab.Homework_01;

import java.util.List;

public interface CustomerRepository {

    void addClient(Customer customer);
    void removeClient(Customer customer);
    void getList();
}
