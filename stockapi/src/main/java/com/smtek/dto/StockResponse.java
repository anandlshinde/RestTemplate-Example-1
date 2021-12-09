package com.smtek.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockResponse {

	private String stockName;
	private int stockQty;
	private double stockPrice;
	private double totalAmount;
}
