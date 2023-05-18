package com.promineotech.dao;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.entity.Category;
import com.promineotech.entity.Category;
import com.promineotech.entity.Inventory;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j

public class DefaultInventoryDao implements InventoryDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	
	
	@Override

	
	public List<Inventory> fetchAllInventory() {
		
		
		
		
		log.info("In inventory dao layer, fetch all inventory");
		
		String sql = ""
				+ "SELECT *"
				+ "FROM inventory";
		
		
		Map<String, Object> params = new HashMap<> ();
		return  jdbcTemplate.query(sql,  params, new RowMapper<Inventory>() {
			@Override
			public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return Inventory.builder()
						.inventoryId(rs.getInt("inventory_id"))
						.categoryId(Category.valueOf(rs.getString("category_id")))
						.itemNumber(rs.getInt("item_number"))
						.itemName(rs.getString("item_name"))
						.amountAvaliable(rs.getInt("amount_avaliable"))
						.sellerName(rs.getString("seller_name"))
						.build();
		
	}});
	
	

}
	@Override
	public Inventory createInventory(Category category, int itemNumber,
			String itemName, int amountAvaliable, String sellerName) {
			SqlParams params = new SqlParams();
			KeyHolder keyHolder = new GeneratedKeyHolder();
			params.sql = ""
				+ " INSERT into inventory "
				+ "( category_id), "
				+ "( item_number), "
				+ "( item_name), "
				+ "( amount_avaliable), "
				+ "( seller_name ), "
			    + "VALUES (:category_id,:item_number,:item_name,:amount_avaliable,:sellerName)"; 
		 
			
			/////?????????????????????????????????????? where to go about with this
			params.source.addValue("category_id", category);
		   
		   jdbcTemplate.update(params.sql, params.source, keyHolder);
			return Inventory.builder()
					.categoryId(category)
				//	.customerId(customer_Id)
					.itemNumber(itemNumber)
					.itemName(itemName)
					.amountAvaliable(amountAvaliable)
			     	.build();
		
		}
		
	class SqlParams {
			
			String sql;
			MapSqlParameterSource source = new MapSqlParameterSource();
		}

	
	
@Override
public Inventory updateInventory(
		Category updatedCategory,int updatedItemNumber,String updatedItemName,
		int updatedAmountAvaliable, String updatedSellerName) {
		String sql = ""
				+ "UPDATE inventory"
				+" SET "
				+"categoryId = :new_Category_id "
				//add more here 
				+"WHERE inventory_id = :inventory_id ";
		
		
		// is my Ebay_username correct ????????????????????????????????????????????????????
		Map<String, Object> params = new HashMap<>();
		//params.put("inventory_id", inventoryId);
		//params.put("inventory_id",inventory_Id);
		params.put("category_id",updatedCategory.toString());
		
		////////////////////////
		//////     is my sql string Ebay corrct?????????????????????????????????????????????????????????????????????
		
		if (jdbcTemplate.update(sql,params) == 0) {
			throw new NoSuchElementException("failed to update inventory");
		}
		return Inventory.builder()	
				//.inventoryId(updatedinventory)
				.categoryId(updatedCategory)
				.itemNumber(updatedItemNumber)////////
				.itemName(updatedItemName)////////
				.amountAvaliable(updatedAmountAvaliable)////////
				.sellerName(updatedSellerName)//////////
				.build();/////
	}
	
@Override
public void deleteInventory(int deleteId) {
	String sql = ""
			+ "DELETE FROM inventory "
			+ "WHERE inventory_id = :inventory_id";
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("inventory_id", deleteId);
		if (jdbcTemplate.update(sql, params) == 0) throw new NoSuchElementException();

}




}



