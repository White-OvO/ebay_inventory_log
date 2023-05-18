package com.promineotech.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.entity.Customer;
import com.promineotech.entity.SoldInventory;
import com.promineotech.entity.Transactions;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("SoldInventory")
@OpenAPIDefinition(info = @Info(title = "Sold inventory List"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface SoldInventoryController {
	
	@Operation(
		summary = "Return a list of the sold inventory",
		description = "Retruns the created sold list",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "The created sold inventory is returned",
				content = @Content (
						mediaType = "application/json",
						schema = @Schema(implementation = SoldInventory.class))),
			@ApiResponse(
					responseCode = "400",
					description = "A sold invoice component was not found with the input criteria",
					content = @Content (mediaType = "application/json")),
			
			////////////// do i need code 404?????????????????????????????????????
			@ApiResponse(
				
					responseCode = "500",
					description = "An unplanned error occured.",
					content = @Content (mediaType = "application/json")),

		}
)	
	
//	@GetMapping("/ebay_client")
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<SoldInventory> fetchAllSoldInventory(
			);
	
	

	@Operation(
			summary = "Creates a new sold item details for transaction",
			description = "Returns the newly created sold inventory",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "A new invoivce has been created",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = SoldInventory.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "no existing sold transactions exist.",
							content = @Content(mediaType = "application/json")),
		
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occured.",
							content = @Content(mediaType = "application/json")),
			}
//,
			
//			parameters = {
//					@Parameter(name = "sold inventory data",
//							allowEmptyValue = false,
//							required = false,
//							description = "The inventory list for local transactions"),
//									}
		)
	@PostMapping("/createsoldinventory")
	@ResponseStatus(code = HttpStatus.CREATED)
				SoldInventory soldInventory(int EbayOrderNumber, int transactionId,int itemNumber);
}
			  
