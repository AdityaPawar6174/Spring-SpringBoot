package com.infosys.CustomerService.Services;

import com.infosys.CustomerService.DAO.CustomerRepo;
import com.infosys.CustomerService.Entitties.Customer;
import com.infosys.CustomerService.Exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CustomerServiceImpl implements  CustomerInterface{
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public void addCustomer(Customer customer) {
        customerRepo.save(customer);


    }

    public Customer getCustomerOnBasisOfId(int id)
    {
        return customerRepo.findById(id).
                orElseThrow(()->new CustomerNotFoundException(id));

    }
}
