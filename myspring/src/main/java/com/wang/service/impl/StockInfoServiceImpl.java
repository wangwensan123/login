package com.wang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.mapper.StockInfoMapper;
import com.wang.model.StockInfo;
import com.wang.service.StockInfoService;




@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class StockInfoServiceImpl implements StockInfoService {
	
	@Resource
	private StockInfoMapper mapper;

	public boolean delete(int id) {
		
		return mapper.delete(id);
	}

	public List<StockInfo> findAll() {
		List<StockInfo> findAllList = mapper.findAll();
		return findAllList;
	}
	
	 public List<StockInfo> findByCondition(Map map) {
	    List<StockInfo> findAllList = mapper.findByCondition(map);
	    return findAllList;
	  }

   public int countByCondition(Map map) {
     int count = mapper.countByCondition(map);
     return count;
   }
	 
	public StockInfo findById(int id) {

	  StockInfo stockInfo = mapper.findById(id);
		
		return stockInfo;
	}
	
	 public StockInfo findByCode(String code) {

	   StockInfo stockInfo = mapper.findByCode(code);
	    
	    return stockInfo;
	  }

	public void save(StockInfo stockInfo) {

		mapper.save(stockInfo);
	}

	public boolean update(StockInfo stockInfo) {

		return mapper.update(stockInfo);
	}
	

	

}
