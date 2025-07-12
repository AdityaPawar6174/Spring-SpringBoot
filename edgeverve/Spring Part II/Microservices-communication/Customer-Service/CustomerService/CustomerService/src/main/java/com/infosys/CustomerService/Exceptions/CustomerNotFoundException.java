package com.infosys.CustomerService.Exceptions;

import com.infosys.CustomerService.Entitties.Customer;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(int id)
    {
        super("Customer not found "+id);
    }
}
