package interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "interview")
@EntityScan(basePackages = "interview")
@ComponentScan(basePackages = "interview")
public class JavaInterviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaInterviewApplication.class, args);
    }
}
