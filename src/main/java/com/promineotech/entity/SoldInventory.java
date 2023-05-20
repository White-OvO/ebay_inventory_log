package com.promineotech.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SoldInventory {
private int orderId;
private int inventoryId;
private int EbayOrderNumber;
private int transactionId;
}
