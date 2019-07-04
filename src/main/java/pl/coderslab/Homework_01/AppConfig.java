package pl.coderslab.Homework_01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AppConfig {
    private final String filename ="logger.txt";

    @Bean(name="filename")
    public String getFilename() {
        return filename;
    }

    @Bean
    public MemoryCustomerRepository memoryCustomerRepository(FileCustomerLogger fileCustomerLogger) {
        return new MemoryCustomerRepository(fileCustomerLogger);
    }

    @Bean
    public FileCustomerLogger fileCustomerLogger() throws IOException {
        return new FileCustomerLogger(filename);
    }
}
