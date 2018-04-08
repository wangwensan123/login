package com.wang.service;

import java.util.List;
import java.util.Map;
import com.wang.model.StockInfoDate;


public interface StockInfoDateService {
  void save(StockInfoDate stockInfo);
  boolean update(StockInfoDate stockInfo);
  boolean delete(int id);
  StockInfoDate findById(int id);
  List<StockInfoDate> findByCode(String code);
  List<StockInfoDate> findByCondition(Map map);
  int countByCondition(Map map);
  List<StockInfoDate> findAll();
}
