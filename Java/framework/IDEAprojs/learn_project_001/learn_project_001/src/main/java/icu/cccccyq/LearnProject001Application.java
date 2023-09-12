package icu.cccccyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //开启对servlet组件的支持
@SpringBootApplication
public class LearnProject001Application {

    public static void main(String[] args) {
        SpringApplication.run(LearnProject001Application.class, args);
    }

}
