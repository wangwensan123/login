package com.wang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.model.StockInfo;
import com.wang.service.StockInfoService;


@Controller
@RequestMapping("/stockInfo")
public class StockInfoController {

	@Autowired
	private StockInfoService stockInfoService;
	
	
	/**
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAllStockInfo")
	public String getAllStockInfo(HttpServletRequest request,Model model){
	   Map map = new HashMap();
    String s = request.getParameter("start");
    String n = request.getParameter("limit");
	   int start = s==null?0:Integer.parseInt(s);
	   int limit = n==null?10:Integer.parseInt(n);
	   map.put("start", start);
	   map.put("limit", limit);
  		List<StockInfo> findAll = stockInfoService.findByCondition(map);
		  int total = stockInfoService.countByCondition(map);
		  model.addAttribute("stockInfoList",findAll);
  		model.addAttribute("currenttime",System.currentTimeMillis());
  		model.addAttribute("total",total);
  		model.addAttribute("start",start);
  		model.addAttribute("limit",limit);
  		model.addAttribute("pageurl", "/stockInfo/getAllStockInfo?1=1");
		  return "stock/stockInfo.index.html";
	}
	
	
}
