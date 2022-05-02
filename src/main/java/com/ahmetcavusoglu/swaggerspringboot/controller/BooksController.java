package com.ahmetcavusoglu.swaggerspringboot.controller;


import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmetcavusoglu.swaggerspringboot.model.Books;
import com.ahmetcavusoglu.swaggerspringboot.repository.BookRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Customer Rest Api", description = "Books Rest Service")
public class BooksController {

	private BookRepository bookRepo;

	public BooksController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	@ApiOperation(value = "Display selected Book")
	@GetMapping({ "/book/id" })
	public Books getBook(String id) throws SQLException {
		return bookRepo.getBook(id);
	}

	@ApiOperation(value = "Add Book")
	@PostMapping({ "/books/add" })
	public Books addBook(String id, String name, String author, String publisher, String stockNumber, double price,
			String edition) throws SQLException {

		return bookRepo.addBook(id, name, author, publisher, stockNumber, price, edition);
	}

	@ApiOperation(value = "Update Book Stock Records")
	@PutMapping({ "/books/update" })
	public Books updateStockRecords(String id, String stockNumber) throws SQLException {

		return bookRepo.updateStockRecords(id, stockNumber);
	}

}
