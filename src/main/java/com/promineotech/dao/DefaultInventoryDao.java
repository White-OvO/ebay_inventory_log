package com.promineotech.dao;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

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
			//SqlParams params = new SqlParams();
			KeyHolder keyHolder = new GeneratedKeyHolder();
			   log.debug("DAO: category={},  item_number={},item_name={},amount_avaliable={}, seller_name={}",
				        category, itemNumber, itemName, amountAvaliable, sellerName);
			//Method one
//			
//			String sql = ""
//				+ "INSERT into inventory"
//				+ "(category_id), "
//				+ "(item_number), "
//				+ "( item_name ), "
//				+ "(amount_avaliable), "
//				+ "( seller_name ) "
//			    + "VALUES (:category_id,:item_number,:item_name,:amount_avaliable,:sellerName)"; 
//		 
		
			//Method two
			
			
			 // @formatter:off
		    String sql = ""
		        + "INSERT INTO inventory ("
		        + "category_id, item_number, item_name, amount_avaliable, seller_name"
		        + ") VALUES ("
		        + ":category_id, :item_number, :item_name, :amount_avaliable, :seller_Name)";
		    // @formatter:on
			
			
			////////// LINE 121 might be wrong
			
			
			
			Map<String, Object> params = new HashMap<>();
			params.put("categoryId",category);
			params.put("itemNumber",itemNumber);
			params.put("itemName", itemName);
			params.put("amountAvaliable", amountAvaliable);
			params.put("sellerName",sellerName);
			
			
			///////////////			wrong params //////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////			
//			params.source.addValue("category",category, "item_number", itemNumber, 
//									"item_name", itemName, "amount_avaliable", amountAvaliable, 
//									"seller_name", sellerName);
//		
			
			
			jdbcTemplate.update(sql, params);
	//   jdbcTemplate.update(params.sql, params.source, keyHolder);
			return Inventory.builder()
					.categoryId(category)
					.itemNumber(itemNumber)
					.itemName(itemName)
					.amountAvaliable(amountAvaliable)
					.sellerName(sellerName)
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
				+" category_Id = :new_category_id "
				+" item_Number = :new_item_Number "
				+" item_Name = :new_item_Name "
				+" amount_Avaliable = :new_amount_Avaliable "
				+" seller_Name = :new_seller_Name "
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



