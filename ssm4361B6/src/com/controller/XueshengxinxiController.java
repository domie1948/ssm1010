﻿package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Xueshengxinxi;
import com.server.XueshengxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XueshengxinxiController {
	@Resource
	private XueshengxinxiServer xueshengxinxiService;


   
	@RequestMapping("addXueshengxinxi.do")
	public String addXueshengxinxi(HttpServletRequest request,Xueshengxinxi xueshengxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xueshengxinxi.setAddtime(time.toString().substring(0, 19));
		xueshengxinxiService.add(xueshengxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xueshengxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xueshengxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXueshengxinxi.do")
	public String doUpdateXueshengxinxi(int id,ModelMap map,Xueshengxinxi xueshengxinxi){
		xueshengxinxi=xueshengxinxiService.getById(id);
		map.put("xueshengxinxi", xueshengxinxi);
		return "xueshengxinxi_updt";
	}
	
	@RequestMapping("doUpdateXueshengxinxi2.do")
	public String doUpdateXueshengxinxi2(ModelMap map,Xueshengxinxi xueshengxinxi,HttpServletRequest request){
		xueshengxinxi=xueshengxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("xueshengxinxi", xueshengxinxi);
		return "xueshengxinxi_updt2";
	}
	
@RequestMapping("updateXueshengxinxi2.do")
	public String updateXueshengxinxi2(int id,ModelMap map,Xueshengxinxi xueshengxinxi){
		xueshengxinxiService.update(xueshengxinxi);
		return "redirect:doUpdateXueshengxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("xueshengxinxiDetail.do")
	public String xueshengxinxiDetail(int id,ModelMap map,Xueshengxinxi xueshengxinxi){
		xueshengxinxi=xueshengxinxiService.getById(id);
		map.put("xueshengxinxi", xueshengxinxi);
		return "xueshengxinxi_detail";
	}
//	前台详细
	@RequestMapping("xsxxDetail.do")
	public String xsxxDetail(int id,ModelMap map,Xueshengxinxi xueshengxinxi){
		xueshengxinxi=xueshengxinxiService.getById(id);
		map.put("xueshengxinxi", xueshengxinxi);
		return "xueshengxinxidetail";
	}
//	
	@RequestMapping("updateXueshengxinxi.do")
	public String updateXueshengxinxi(int id,ModelMap map,Xueshengxinxi xueshengxinxi,HttpServletRequest request,HttpSession session){
		xueshengxinxiService.update(xueshengxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xueshengxinxiList.do";
	}

//	分页查询
	@RequestMapping("xueshengxinxiList.do")
	public String xueshengxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengxinxi xueshengxinxi, String xuehao, String mima, String xingming, String xingbie, String nianling1,String nianling2, String lianxifangshi, String zhaopian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling1==null||nianling1.equals("")){pmap.put("nianling1", null);}else{pmap.put("nianling1", nianling1);}		if(nianling2==null||nianling2.equals("")){pmap.put("nianling2", null);}else{pmap.put("nianling2", nianling2);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=xueshengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengxinxi> list=xueshengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengxinxi_list";
	}
	
	
	
	@RequestMapping("xsxxList.do")
	public String xsxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xueshengxinxi xueshengxinxi, String xuehao, String mima, String xingming, String xingbie, String nianling1,String nianling2, String lianxifangshi, String zhaopian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling1==null||nianling1.equals("")){pmap.put("nianling1", null);}else{pmap.put("nianling1", nianling1);}		if(nianling2==null||nianling2.equals("")){pmap.put("nianling2", null);}else{pmap.put("nianling2", nianling2);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=xueshengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xueshengxinxi> list=xueshengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xueshengxinxilist";
	}
	
	@RequestMapping("deleteXueshengxinxi.do")
	public String deleteXueshengxinxi(int id,HttpServletRequest request){
		xueshengxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xueshengxinxiList.do";
	}
	
	@RequestMapping("quchongXueshengxinxi.do")
	public void quchongXueshengxinxi(Xueshengxinxi xueshengxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("xuehao", xueshengxinxi.getXuehao());
		   System.out.println("xuehao==="+xueshengxinxi.getXuehao());
		   System.out.println("xuehao222==="+xueshengxinxiService.quchongXueshengxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(xueshengxinxiService.quchongXueshengxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "学号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
