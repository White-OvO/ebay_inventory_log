package com.promineotech.dao;



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

//import com.promineotech.dao.DefaultCustomerDao.SqlParams;
import com.promineotech.entity.Inventory;
import com.promineotech.entity.Transactions;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j


public class DefaultTransactionsDao implements TransactionsDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Override
	// list of all transacations
	
	public List<Transactions> fetchAllTransactions() {
		log.info("In transactions dao layer, fetch all transactions: ");
		
		
		String sql = ""
				+"SELECT * "
				+"FROM transactions";
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////  need help filing this final request
		
		
		
		
		Map<String, Object> params = new HashMap<>();
		return jdbcTemplate.query(sql,  params, new RowMapper<Transactions>() {
			@Override
			public Transactions mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Transactions.builder()
						.transactionsId(rs.getInt("transactions_id"))
						.customerId(rs.getInt("customer_id"))
						.dateSold(rs.getString("date_sold"))
						.buyerPaid(rs.getInt("buyer_paid"))
						.taxesPerTransaction(rs.getInt("taxes_per_transaction"))
						.shippingCost(rs.getInt("shipping_cost"))
						.sellerFee(rs.getInt("seller_fee"))
						.build();
			}
	});
	
}


	@Override
	public Transactions createTransactions(int customerId,String dateSold,int buyerPaid, int taxesPerTransaction,
			int shippingCost, int sellerFee) {
	SqlParams params = new  SqlParams();
	KeyHolder keyHolder = new GeneratedKeyHolder();
	
	
	//params.sql = ""
			
log.debug("DAO: customer_id={}, date_sold={}, buyer_paid={}, taxes_per_transaction={}, shipping_cost={}, seller_fee={}",
					customerId, dateSold, dateSold, taxesPerTransaction, shippingCost, sellerFee);
//		
		params.sql = ""
					+ "INSERT INTO transactions ("
					+ "customer_id, date_sold, buyer_paid, taxes_per_transaction, shipping_cost, seller_fee"
					+ ") VALUES ("
					+ ":customer_id, :date_sold, :buyer_paid, :taxes_per_transaction, :shipping_cost, :seller_fee)";
			
			
			                      params.source.addValue("customer_id", customerId);					
			                      params.source.addValue("date_sold", dateSold);
			                      params.source.addValue("buyer_paid", buyerPaid);
			                      params.source.addValue("taxes_per_transaction", taxesPerTransaction); 
		                          params.source.addValue("shipping_cost", shippingCost);
		                          params.source.addValue("seller_fee", sellerFee);
								
		   
			   jdbcTemplate.update(params.sql, params.source, keyHolder);
					return Transactions.builder()
							.transactionsId(keyHolder.getKey().intValue())
							.customerId(customerId)
							.dateSold(dateSold)
							.buyerPaid(buyerPaid)
							.taxesPerTransaction(taxesPerTransaction)
							.shippingCost(shippingCost)
					     	.sellerFee(sellerFee)
							.build();
			
		}
		class SqlParams {
			
			String sql;
			MapSqlParameterSource source = new MapSqlParameterSource();
		}


		
		
		
		
			@Override
	public void deleteTransactions(int transactionsId) {
		String sql = ""
				+ "DELETE FROM transactions "
				+ "WHERE transactions_id = :transactions_id";
			
			Map<String, Object> params = new HashMap<>();
			
			params.put("transactions_id", transactionsId);
			 jdbcTemplate.update(sql, params);// == 0) throw new NoSuchElementException();

	}



}