package com.wang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.model.StockInfoDate;
import com.wang.service.StockInfoDateService;


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
    Map map = new HashMap();
   String s = request.getParameter("start");
   String n = request.getParameter("limit");
    int start = s==null?0:Integer.parseInt(s);
    int limit = n==null?10:Integer.parseInt(n);
    map.put("start", start);
    map.put("limit", limit);
    String code = request.getParameter("code");
    String date = request.getParameter("date");
    String pageurl = "/stockInfoDate/getAllStockInfoDate?1=1";
    if(null!=code&&!code.equals("")){
      map.put("code", code);
      pageurl+="&code="+code;
        }
    if(null!=date&&!date.equals("")){
      map.put("date", date);
      pageurl+="&date="+date;
        }       
  		List<StockInfoDate> findAll = stockInfoDateService.findByCondition(map);
    int total = stockInfoDateService.countByCondition(map);
    model.addAttribute("stockInfoList",findAll);
    model.addAttribute("total",total);
    model.addAttribute("start",start);
    model.addAttribute("limit",limit);
    model.addAttribute("code",code);
    model.addAttribute("date",date);
    model.addAttribute("pageurl", pageurl);
		  return "stock/stockInfoDate.index.html";
	}
	
	
}
