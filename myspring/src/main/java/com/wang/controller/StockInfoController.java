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
import com.wang.util.X;


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
	    int start = X.toInt(request.getParameter("start"), 0);
	    int limit = X.toInt(request.getParameter("limit"), 10);
  	   map.put("start", start);
  	   map.put("limit", limit);
	    String code = request.getParameter("code");
	    String abbreviation = request.getParameter("abbreviation");
	    if(null!=code&&!code.equals("")){
	      map.put("code", code);
	        }
	    if(null!=abbreviation&&!abbreviation.equals("")){
	      map.put("abbreviation", abbreviation);
	        } 
  		List<StockInfo> findAll = stockInfoService.findByCondition(map);
		  int total = stockInfoService.countByCondition(map);
		  model.addAttribute("stockInfoList",findAll);
	    model.addAttribute("code",code);
	    model.addAttribute("abbreviation",abbreviation);
    X.setPageInfo(total,start,limit,"/stockInfo/getAllStockInfo",model,map);
		  return "stock/stockInfo.index.html";
	}
	
	
}
