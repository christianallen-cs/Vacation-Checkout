package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @PostConstruct
    public void initialData() {
        if (customerRepository.count() == 1) {

            Customer customer1 = new Customer();
            customer1.setFirstName("John");
            customer1.setLastName("Donut");
            customer1.setPostal_code("12345");
            customer1.setAddress("123 Donut Street");
            customer1.setPhone("(123) 123 - 1234");
            customer1.setDivision(divisionRepository.findAll().get(8));
            customer1.setCreate_date(new Date());
            customer1.setLast_update(new Date());

            Customer customer2 = new Customer();
            customer2.setFirstName("Cameron");
            customer2.setLastName("Doe");
            customer2.setPostal_code("12345");
            customer2.setAddress("123 YoYo Street");
            customer2.setPhone("(098) 123 - 2345");
            customer2.setDivision(divisionRepository.findAll().get(2));
            customer2.setCreate_date(new Date());
            customer2.setLast_update(new Date());

            Customer customer3 = new Customer();
            customer3.setFirstName("Chris");
            customer3.setLastName("Topper");
            customer3.setPostal_code("09123");
            customer3.setAddress("123 Tipper lane");
            customer3.setPhone("(123) 234 - 2643");
            customer3.setDivision(divisionRepository.findAll().get(3));
            customer3.setCreate_date(new Date());
            customer3.setLast_update(new Date());

            Customer customer4 = new Customer();
            customer4.setFirstName("Gianna");
            customer4.setLastName("Mustard");
            customer4.setPostal_code("00000");
            customer4.setAddress("032 Crispy Ave");
            customer4.setPhone("(000) 000 - 0000");
            customer4.setDivision(divisionRepository.findAll().get(9));
            customer4.setCreate_date(new Date());
            customer4.setLast_update(new Date());

            Customer customer5 = new Customer();
            customer5.setFirstName("Lil");
            customer5.setLastName("Wayne");
            customer5.setPostal_code("67890");
            customer5.setAddress("123 Weezy Rd");
            customer5.setPhone("(000) 654 - 3425");
            customer5.setDivision(divisionRepository.findAll().get(4));
            customer5.setCreate_date(new Date());
            customer5.setLast_update(new Date());

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

            System.out.println("Samples added");
        } else {
            System.out.println("Samples not added");
        }
    }
}
