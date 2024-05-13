package nz.ac.auckland.se754.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("nz.ac.auckland.se754.web")
public class LearnLanguageWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnLanguageWebApplication.class, args);
    }
}
