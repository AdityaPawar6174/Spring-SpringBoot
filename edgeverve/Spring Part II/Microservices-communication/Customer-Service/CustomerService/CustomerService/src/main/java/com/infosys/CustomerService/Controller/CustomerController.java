package com.infosys.CustomerService.Controller;

import com.infosys.CustomerService.CustomerServiceApplication;
import com.infosys.CustomerService.Entitties.Customer;
import com.infosys.CustomerService.Entitties.CustomerResponse;
import com.infosys.CustomerService.Services.CustomerInterface;
import com.infosys.CustomerService.Services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping("/addcustomer")
    public ResponseEntity<CustomerResponse> addNewCustomer(@RequestBody Customer customer)
    {
            customerService.addCustomer(customer);
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setStatusCode("200");
            customerResponse.setStatusMsg("Customer added successfully");
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(customerResponse);
    }
    @GetMapping("/getcustomerbyid")
    public  ResponseEntity<CustomerResponse>  getCustomer(@RequestParam  int customerId)
    {
       Customer customer = customerService.getCustomerOnBasisOfId(customerId);
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setStatusCode("200");
        customerResponse.setStatusMsg("Customer added successfully"+customer.toString());
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(customerResponse);
    }
}
