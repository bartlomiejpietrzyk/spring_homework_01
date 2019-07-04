package pl.coderslab.Homework_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Component
@Primary
public class FileCustomerLogger implements CustomerLogger {
    private String filename;

    @Autowired
    public FileCustomerLogger(@Qualifier("filename") String filename) {
        this.filename = filename;
    }

    @Override
    public void log() {
        System.out.printf("%s:  FileCustomerLogger operation. Exec. in %s", new Date(),new Throwable().getStackTrace()[0].getClassName());
    }

    @Override
    public void log(String methodLog) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write(String.valueOf(new Date()) + "::Logger::operation::method::" + methodLog + "::executed::in::" + new Throwable().getStackTrace()[0].getClassName());

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
