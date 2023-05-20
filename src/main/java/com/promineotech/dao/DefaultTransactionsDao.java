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
import org.springframework.stereotype.Component;

import com.promineotech.dao.DefaultCustomerDao.SqlParams;
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
						.transactions_id(rs.getInt("transaction_id"))
						.customer_id(rs.getInt("customer_id"))
						.date_sold(rs.getString("date_sold"))
						.buyer_paid(rs.getInt("buyer_paid"))
						.taxes_per_transaction(rs.getInt("taxes_per_transaction"))
						.shipping_cost(rs.getInt("shipping_cost"))
						.seller_fee(rs.getInt("seller_fee"))
						.build();
			}
	});
	
}


	@Override
	public Transactions createtransactions(int transactionsId, int customerId, String dateSold, int taxesPerTransaction,
			int shippingCost, int sellerFee) {
	SqlParams params = new  SqlParams();
	keyHolder keyHolder = new GeneratedKeyHolder();
		log.debug("DAO: customer_id={}, date_sold={}, buyer_paid={}, taxes_per_transactions={}, shipping_cost={}, seller_fee={}",
						transactionsId,customerId, dateSold, dateSold, taxesPerTransaction, shippingCost, sellerFee);
		
		
		
		
		
		
		params.sql = ""
				+ "INSERT INTO transactions ("
				+"customer_id, date_sold, buyer_paid, taxes_per_transactions, shipping_cost, seller_fee"
				+") VALUES ("
				+":customer_id, :date_sold, :buyer_paid, :taxes_per_transactions, :shipping_cost, :seller_fee)";
		params.source.addValue("customer_id", customerId);					
		params.source.addValue("date_sold", dateSold);
		params.source.addValue("buyer_paid", buyerPaid);
		params.source.addValue("taxes_per_transactions", taxesPerTransaction); 
	    params.source.addValue("shipping_cost" shippingCost);
	    params.source.addValue("seller_fee" sellerFee);
							
	   
		   jdbcTemplate.update(params.sql, params.source, keyHolder);
				return Transactions.builder()
						.transactionsId(keyHolder.getKey().intValue())
						.customerId(customerid)
						.dateSold(dateSold)
						.buyerpaid(buyerPaid)
						.taxesPerTransactions(taxesPerTransaction)
						.shippingCost(shippingCost)
				     	.sellerFee(sellerFee)
						.build();
	
	}
	class SqlParams {
		
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}

	@Override
	public void deleteTransations(int transactionsId) {
		// TODO Auto-generated method stub
		
	}

}