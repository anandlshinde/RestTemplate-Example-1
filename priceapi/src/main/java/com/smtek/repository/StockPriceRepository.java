package com.smtek.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smtek.entity.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Serializable> {

	public StockPrice findByStockName(String stockName);
}
