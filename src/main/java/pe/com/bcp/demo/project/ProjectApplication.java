package pe.com.bcp.demo.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories({"pe.com.bcp.demo.project.money.repository", "pe.com.bcp.demo.project.typechange.repository"})
@EntityScan({"pe.com.bcp.demo.project.money.entity", "pe.com.bcp.demo.project.typechange.entity"})
@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

}
