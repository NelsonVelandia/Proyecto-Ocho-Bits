package com.usa.empresa;

import com.usa.empresa.repository.crud.LaptopCrudRepository;
import com.usa.empresa.repository.crud.OrderCrudRepository;
import com.usa.empresa.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class EmpresaApplication implements CommandLineRunner {

    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private LaptopCrudRepository laptopCrudRepository;
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmpresaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userCrudRepository.deleteAll();
        laptopCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }

}
