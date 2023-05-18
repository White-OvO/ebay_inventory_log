package com.promineotech.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.entity.Category;
import com.promineotech.entity.Inventory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
@Validated
@RequestMapping("inventory")
@OpenAPIDefinition(info = @Info(title = "Inventory List"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
public interface InventoryController {

	
	@Operation(
			summary = "Returns the list table for Inventory",
			description = "Retruns Your inventory",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The created Inventory is returned",
					content = @Content (
							mediaType = "application/json",
							schema = @Schema(implementation = Inventory.class))),
				@ApiResponse(
						responseCode = "400",
						description = "A Inventory component was not found with the input criteria",
						content = @Content (mediaType = "application/json")),
				
	
	
				@ApiResponse(
						
						responseCode = "500",
						description = "An unplanned error occured.",
						content = @Content (mediaType = "application/json")),

			}
	)	
	
	
	
	@GetMapping
	//@GetMapping("inventory_id") = to get by inventory id
	
	@ResponseStatus(code = HttpStatus.OK)
	List<Inventory> fetchAllInventory(
			
			);
	
	

	
	@Operation(
			summary = "Creates a new Inventory",
			description = "Returns the created inventory item",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "A new item has been to the inventory",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation =Inventory.class))),
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
			},
			/////////////////////////////// is line 95 correct????????????????????????????????????
			parameters = {
					@Parameter(name = "EbayInventory",
							allowEmptyValue = false,
							required = false,
							description = "The Ebay inventory-item name"),
									}
		)
	@PostMapping("/createInventory")
	@ResponseStatus(code = HttpStatus.CREATED)	
	
	Inventory createInventory(Category category, int itemNumber, String itemName, int amountAvaliable,
			String sellerName);	
	
	
//////////////////////// 
	// update //
	//////////////////////
	@Operation(
			summary = "Updates an existing inventory-item",
			description = "Returns updated existing inventory-chart",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Returns updated existing inventory chart",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Inventory.class))),
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

			},
			parameters = {
					@Parameter(name = "inventory_id",
							allowEmptyValue = false,
							required = false,
							description = "The inventory's ID within the inventory database"),

			}
			)
	

    @PutMapping("/updateinventory")

    @ResponseStatus(code = HttpStatus.OK)
    Inventory updateInventory(int inventoryId, Category category, int itemNumber,
    		String itemName, int amountAvaliable, String sellerName);

	@Operation(
				summary = "Deletes an existing inventory-table",
				description = "Deletes an existing inventory",
				responses = {
	@ApiResponse(
				responseCode = "200",
				description = "Inventory record was deleted",
				content = @Content(
				mediaType = "application/json",
				schema = @Schema(implementation = Inventory.class))),
	@ApiResponse(
				responseCode = "400",
				description = "The request parameters are invalid",
				content = @Content(mediaType = "application/json")),
	@ApiResponse(
				responseCode = "404",
				description = "No exisiting inventory in inventory-table were found.",
				content = @Content(mediaType = "application/json")),

	@ApiResponse(
				responseCode = "500",
				description = "An unplanned error occured.",
				content = @Content(mediaType = "application/json")),

},
	parameters = {
				@Parameter (name = "inventoryId",
				allowEmptyValue = false,
				required = false,
				description = "inventoryId (i.e., 2)"),
}
)
				

@DeleteMapping("/deleteinventory")
@ResponseStatus(code = HttpStatus.OK)

	void deleteInventory(int inventoryId);




		
}

	
	
	// default controllers needs annotation rest controller
	//@controller is also in jpa
	
	
	
	
	
