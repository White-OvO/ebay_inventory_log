package com.promineotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.entity.Inventory;
import com.promineotech.entity.Transactions;

//import com.promineo.
//import javax.transaction.Transaction;
//import com.promineo.repository.TransactionsRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;




@Validated
@RequestMapping("TransactionsController")
@OpenAPIDefinition(info = @Info(title = "Transactions List"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface TransactionsController {
	
	@Operation(
		summary = "Returns a ist of  Transactions",
		description = "Retruns the created Transaction",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "The created Transaction is returned",
				content = @Content (
						mediaType = "application/json",
						schema = @Schema(implementation = Transactions.class))),
			@ApiResponse(
					responseCode = "400",
					description = "A Transaction component was not found with the input criteria",
					content = @Content (mediaType = "application/json")),
			
			////////////// do i need code 404?????????????????????????????????????
			@ApiResponse(
				
					responseCode = "500",
					description = "An unplanned error occured.",
					content = @Content (mediaType = "application/json")),

		}
)	
	
	@GetMapping//("/ebay_client")
	@ResponseStatus(code = HttpStatus.OK)
	List<Transactions> fetchAllTransactions(
			);
	








@Operation(
		summary = "Creates a new transaction",
		description = "Returns the created transaction item",
		responses = {
				@ApiResponse(
						responseCode = "201",
						description = "A new transaction has been added to the table",
						content = @Content(
								mediaType = "application/json",
								schema = @Schema(implementation =Transactions.class))),
				@ApiResponse(
						responseCode = "400",
						description = "The request parameters are invalid",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404",
						description = "No inventory were found.",
						content = @Content(mediaType = "application/json")),
	
				@ApiResponse(
						responseCode = "500",
						description = "An unplanned error occured.",
						content = @Content(mediaType = "application/json")),
		}

	)
@PostMapping("/createTransactions")
@ResponseStatus(code = HttpStatus.CREATED)	

Transactions createTransactions(int customerId, String dateSold, int buyerPaid, int taxesPerTransaction,
		int shippingCost, int sellerFee);







@DeleteMapping("/deletetransactions")
@ResponseStatus(code = HttpStatus.OK)
	void deleteTransactions(int transactionsId);




















}
			  
			

