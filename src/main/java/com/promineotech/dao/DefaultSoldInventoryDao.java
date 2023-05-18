package com.promineotech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.entity.SoldInventory;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultSoldInventoryDao implements SoldInventoryDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@Override         // method overrides the base class method. For two reasons, the @Override annotation is useful. If the annotated method does not
						//actually override anything, the compiler issues a warning. It can help to make the source code more readable.
	public List<SoldInventory> fetchAllSoldInventory() {
		log.info("In all of sold inventoy dao. fetch all sold  inventory:");
		
		
		String sql = " "
				+ "SELECT * "
				+ "FROM sold_inventory";
		
		Map<String, Object> params = new HashMap<>();
		
		
		//should my directory be caps ?????
		return jdbcTemplate.query(sql, params, new RowMapper<SoldInventory>() {
			@Override
			
			// list ALL sold inventory
		public SoldInventory mapRow(ResultSet rs, int rowNum) throws SQLException {
				return SoldInventory.builder()
					//	.orderId(rs.getInt("order_id"))
						.inventoryId(rs.getInt("inventory_id"))
						.EbayOrderNumber(rs.getInt("Ebay_order_number"))
						.transactionId(rs.getInt("transaction_id"))
						.build();
			}
			
			
			
		});
	}
	@Override
	public SoldInventory createSoldInventory(int inventoryId,int EbayOrderNumber, int transactionId) {
		SqlParams params = new SqlParams();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		log.debug("DAO: inventory_id={},Ebay_order_number={},transactions_id={}",
		        inventoryId,EbayOrderNumber, transactionId);
		
	    params.sql = ""
	    		+ "INSERT INTO sold_inventory ("
		        + "inventory_id,Ebay_order_number,transaction_id"
		        + ") VALUES ("
		        + ":inventory_id, :Ebay_order_number, :transaction_id)";
	    
		//transactions_id
	   params.source.addValue("inventory_id", inventoryId);	
	   params.source.addValue("Ebay_order_number",EbayOrderNumber);
	   params.source.addValue("transaction_id", transactionId);	
	   
	   
	   
	   
	   jdbcTemplate.update (params.sql,params.source, keyHolder);
		return SoldInventory.builder()		
				.orderId(keyHolder.getKey().intValue())   
				.inventoryId(inventoryId)
				.EbayOrderNumber(EbayOrderNumber)
				.transactionId(transactionId)
				.build();
	
	}
	
	class SqlParams {
		
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
	
	
}
