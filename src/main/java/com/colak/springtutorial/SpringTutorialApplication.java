package com.colak.springtutorial;

import com.colak.springtutorial.config.ICommonDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringTutorialApplication implements CommandLineRunner {

    private ICommonDAO commonDAO;

    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialApplication.class, args);
    }

    @Autowired
    public void setCommonDAO(ICommonDAO commonDAO) {
        this.commonDAO = commonDAO;
    }

    @Override
    public void run(String... args) {
        // class com.colak.springtutorial.config.CommonDAOImpl$$SpringCGLIB$$1
        // CGLIB proxies work by generating a subclass of the target class at runtime.
        log.info("Class : {}", commonDAO.getClass());
        commonDAO.save();
    }
}
