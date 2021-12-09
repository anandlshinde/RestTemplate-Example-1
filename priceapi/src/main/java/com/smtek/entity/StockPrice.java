package com.smtek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tbl_stock_price")
public class StockPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stock_id")
	private int stockId;
	
	@Column(name="stock_name")
	private String stockName;
	
	@Column(name="stock_price")
	private double stockPrice;
}
