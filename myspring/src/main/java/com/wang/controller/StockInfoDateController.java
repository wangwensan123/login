package com.wang.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.model.StockInfoDate;
import com.wang.service.StockInfoDateService;
import com.wang.util.X;


@Controller
@RequestMapping("/stockInfoDate")
public class StockInfoDateController {

	@Autowired
	private StockInfoDateService stockInfoDateService;
	
	
	/**
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAllStockInfoDate")
	public String getAllStockInfoDate(HttpServletRequest request,Model model){

    int start = X.toInt(request.getParameter("start"), 0);
    int limit = X.toInt(request.getParameter("limit"), 10);
    Map map = new HashMap();
    String code = request.getParameter("code");
    String date = request.getParameter("date");
    if(null!=code&&!code.equals("")){
      map.put("code", code);
        }
    if(null!=date&&!date.equals("")){
      map.put("date", date);
        }       
  		List<StockInfoDate> findAll = stockInfoDateService.findByCondition(map,start,limit);
    int total = stockInfoDateService.countByCondition(map);
    model.addAttribute("stockInfoList",findAll);
    model.addAttribute("code",code);
    model.addAttribute("date",date);
    X.setPageInfo(total,start,limit,"/stockInfoDate/getAllStockInfoDate",model,map);
		  return "stock/stockInfoDate.index.html";
	}
	
}
