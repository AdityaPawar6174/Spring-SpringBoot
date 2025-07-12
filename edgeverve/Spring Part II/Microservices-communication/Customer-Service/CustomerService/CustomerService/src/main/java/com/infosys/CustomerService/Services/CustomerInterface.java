package com.infosys.CustomerService.Services;

import com.infosys.CustomerService.Entitties.Customer;
import com.infosys.CustomerService.Entitties.CustomerResponse;

public interface CustomerInterface {

    public  void addCustomer(Customer customer);
    public Customer getCustomerOnBasisOfId(int id);
}
