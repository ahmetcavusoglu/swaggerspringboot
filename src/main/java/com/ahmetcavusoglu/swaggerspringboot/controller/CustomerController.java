package com.ahmetcavusoglu.swaggerspringboot.controller;


import java.sql.SQLException;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmetcavusoglu.swaggerspringboot.model.Customers;
import com.ahmetcavusoglu.swaggerspringboot.repository.CustomerRepository;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Customer Rest Api", description = "Customer Rest Service")
public class CustomerController {

	private CustomerRepository csRepo;

	public CustomerController(CustomerRepository csRepo) {
		this.csRepo = csRepo;
	}

	@ApiOperation(value = "List of Customer")
	@GetMapping({ "/customers" })
	public List<Customers> getCustomerList() throws SQLException {

		return csRepo.getCustomerList();
	}

	@ApiOperation(value = "Display selected Customer")
	@GetMapping({ "/customer/tckno" })
	public Customers getCustomer(String tckno) throws SQLException {

		return csRepo.getCustomer(tckno);
	}

	@ApiOperation(value = "Add Customer")
	@PostMapping({ "/customers/add" })
	public Customers addCustomer(String tckno, String name, String surname, String phonenumber, String address)
			throws SQLException {

		return csRepo.addCustomer(tckno, name, surname, phonenumber, address);
	}
}
