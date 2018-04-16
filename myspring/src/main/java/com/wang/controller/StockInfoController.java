package com.wang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.model.StockInfo;
import com.wang.service.StockInfoService;
import com.wang.util.DateUtils;
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
	
  @RequestMapping("/getPriceList")
  public String getAddRolePage(HttpServletRequest request,Model model) {
    String begindate = request.getParameter("begindate");
    String enddate = request.getParameter("enddate");
    String code = request.getParameter("code");
    if(null==begindate||begindate.equals("")){
      begindate = DateUtils.getStringDateShort();
          }
    if(null==enddate||enddate.equals("")){
      enddate = DateUtils.getStringDateShort();
          }
    String symbol = "sz";
    Pattern p=Pattern.compile("^6");
    Matcher m = p.matcher(code);
    while(m.find()){
      symbol = "sh";
          }
    symbol+=code;
    model.addAttribute("begindate",begindate);
    model.addAttribute("enddate",enddate);
    model.addAttribute("code",code);
    model.addAttribute("symbol",symbol);
    return "stock/priceList.detail.html";
  }
	
}
