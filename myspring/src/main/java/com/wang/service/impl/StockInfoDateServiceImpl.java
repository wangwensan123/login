package com.wang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.mapper.StockInfoDateMapper;
import com.wang.model.StockInfoDate;
import com.wang.service.StockInfoDateService;





@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class StockInfoDateServiceImpl implements StockInfoDateService {
	
	@Resource
	private StockInfoDateMapper mapper;

	public boolean delete(int id) {
		
		return mapper.delete(id);
	}

	public List<StockInfoDate> findAll() {
		List<StockInfoDate> findAllList = mapper.findAll();
		return findAllList;
	}

	public StockInfoDate findById(int id) {

	  StockInfoDate stockInfo = mapper.findById(id);
		
		return stockInfo;
	}
	
	 public List<StockInfoDate> findByCode(String code) {

	   List<StockInfoDate>  list = mapper.findByCode(code);
	    
	    return list;
	  }
	 
   public List<StockInfoDate> findByCondition(Map map) {

     List<StockInfoDate>  list = mapper.findByCondition(map);
      
      return list;
    }
   
   public int countByCondition(Map map) {

     int  count = mapper.countByCondition(map);
      
      return count;
    }

	public void save(StockInfoDate stockInfo) {

		mapper.save(stockInfo);
	}

	public boolean update(StockInfoDate stockInfo) {

		return mapper.update(stockInfo);
	}
	

	

}
