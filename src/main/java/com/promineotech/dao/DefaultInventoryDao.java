package com.promineotech.dao;

import java.math.BigDecimal;

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

import com.promineotech.dao.DefaultCustomerDao.SqlParams;
import com.promineotech.entity.Category;
import com.promineotech.entity.Customer;
import com.promineotech.entity.Inventory;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j

public class DefaultInventoryDao implements InventoryDao{
	
	private static final Object category_id = null;
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
public Inventory createInventory(Enum Category, int itemNumber,
		String itemName, int amountAvaliable, String sellerName) {
		SqlParams params = new SqlParams();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		params.sql = ""
			+ "INSERT into inventory"
			+ "(category_id)"
			+ "(item_number)"
			+ "(item_name)"
			+ "(amount_avaliable"
			+ "(seller_name)"
		    + "VALUES (:category_id,:item_number,:item_name,:amount_avaliable,:sellerName)"; 
	 
		
		/////?????????????????????????????????????? where to go about with this
		params.source.addValue("category_id", category_id);
	   
	   jdbcTemplate.update(params.sql, params.source, keyHolder);
		return Inventory.builder()
				.categoryId(Category)
				.customerId(customer_Id)
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
public Inventory updateInventory(int inventoryId,Category updatedCategory,ItemNumber updatedItemNumber,ItemName updatedItemName, AmountAvaliable updatedAmountAvaliable,
		SellerName updatedSellerName) {
		String sql = ""
				+ "UPDATE inventory"
				+" SET "
				+"inventory_id = :inventory_id "
				+"WHERE inventory_id = :inventory_id ";
		
		
		// is my Ebay_username correct ????????????????????????????????????????????????????
		Map<String, Object> params = new HashMap<>();
		params.put("inventory_id", inventoryId);
		params.put("category_id",updatedCategory.CategoryId());
		params.put("item_number", updatedItemNumber);
		params.put("item_name", updatedItemName);
		params.put("amount_avaliable", updatedAmountAvaliable);
		params.put("seller_name", updatedSellerName);
		
		////////////////////////
		//////     is my sql string Ebay corrct?????????????????????????????????????????????????????????????????????
		
		if (jdbcTemplate.update(sql,params) == 0) {
			throw new NoSuchElementException("failed to update inventory");
		}
		return Customer.builder()	
				//.inventoryId(updatedinventory)
				.categoryId(updatedCategory.getCategroyId())
				.itemNumber(updatedCategory.getItemNumber())
				.itemName(updatedCategory.getItemName())
				.amountAvaliable(updatedCategory)
				.sellerName(updatedCategory)
				.build();
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