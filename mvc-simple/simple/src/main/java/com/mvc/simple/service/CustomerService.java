package com.mvc.simple.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.simple.entity.CustomerEntity;
import com.mvc.simple.repository.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepo;

    // @Autowired
    /*
     * Please note, that since Spring 4.3 you don't even need an @Autowired on your
     * constructor, so you can write your code in Java style rather than tying to
     * Spring's annotations
     */
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;

    }

    public List<CustomerEntity> getList() {
        return this.customerRepo.findAll();
    }

    public String helloWorld() {
        return "";
    }

    public void addSome() {

    }

    public void updateSome(String a) {

    }

    public void manipulatedObject() {

        CustomerEntity a = new CustomerEntity("Jhoan", "Saavedra", "sebas@gmail.com");
        String bc = a.getFirstName();
        a.executeAnother();

        CustomerEntity.another();
        System.out.println(a.toString());
    }
}
