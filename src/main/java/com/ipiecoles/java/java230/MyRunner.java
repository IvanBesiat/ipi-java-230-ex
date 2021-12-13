package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import com.ipiecoles.java.java230.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(managerRepository.count());
        Employe Manager = managerRepository.findOneWithEquipeById(5L);
        System.out.println(Manager.toString());
    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
