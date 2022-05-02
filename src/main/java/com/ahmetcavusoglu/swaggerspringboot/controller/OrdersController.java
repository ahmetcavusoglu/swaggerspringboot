package com.ahmetcavusoglu.swaggerspringboot.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmetcavusoglu.swaggerspringboot.model.Orders;
import com.ahmetcavusoglu.swaggerspringboot.repository.OrderRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Customer Rest Api", description = "Orders Rest Service")
public class OrdersController {

	private OrderRepository orderRepo;

	public OrdersController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

	@ApiOperation(value = "Display selected Orders")
	@GetMapping({ "/order/orderid" })
	public Orders getOrderDetails(String orderid) throws SQLException {
		return orderRepo.getOrderDetails(orderid);
	}

	@ApiOperation(value = "Add Orders")
	@PostMapping({ "/orders/add" })
	public Orders addOrder(String id, String customerTcknNo, double total, String bookId) throws SQLException {
		return orderRepo.addOrder(id, customerTcknNo, total, bookId);
	}

	@ApiOperation(value = "Display Orders of Customer")
	@GetMapping({ "/order/customerTcknNo" })
	public List<Orders> getOrderOfCustomer(String customerTcknNo) throws SQLException {
		return orderRepo.getOrderOfCustomer(customerTcknNo);
	}

	@ApiOperation(value = "List of Orders")
	@GetMapping({ "/orders" })
	public List<Orders> getOrderList() throws SQLException {
		return orderRepo.getOrderList();
	}

}
