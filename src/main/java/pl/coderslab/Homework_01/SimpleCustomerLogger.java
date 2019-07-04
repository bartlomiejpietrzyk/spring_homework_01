package pl.coderslab.Homework_01;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SimpleCustomerLogger implements CustomerLogger {

    @Override
    public void log() {
        System.out.printf("%s: Customer operation\n", new Date());
    }
    @Override
    public void log(String log) {

    }
}
