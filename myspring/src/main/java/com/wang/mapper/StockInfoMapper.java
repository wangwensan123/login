package com.wang.mapper;

import java.util.List;
import java.util.Map;

import com.wang.model.StockInfo;

public interface StockInfoMapper {

	void save(StockInfo stockInfo);
	boolean update(StockInfo stockInfo);
	boolean delete(int id);
	StockInfo findById(int id);
	StockInfo findByCode(String code);
	List<StockInfo> findAll();
	List<StockInfo> findByCondition(Map map);
	int countByCondition(Map map);
}
