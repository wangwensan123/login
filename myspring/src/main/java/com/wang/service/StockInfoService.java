package com.wang.service;

import java.util.List;
import java.util.Map;

import com.wang.model.StockInfo;


public interface StockInfoService {
  void save(StockInfo stockInfo);
  boolean update(StockInfo stockInfo);
  boolean delete(int id);
  StockInfo findById(int id);
  StockInfo findByCode(String code);
  List<StockInfo> findByCondition(Map map);
  int countByCondition(Map map);
  List<StockInfo> findAll();
}
