package com.controller;

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

import com.entity.Tijiaolunwen;
import com.server.TijiaolunwenServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class TijiaolunwenController {
	@Resource
	private TijiaolunwenServer tijiaolunwenService;


   
	@RequestMapping("addTijiaolunwen.do")
	public String addTijiaolunwen(HttpServletRequest request,Tijiaolunwen tijiaolunwen,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		tijiaolunwen.setAddtime(time.toString().substring(0, 19));
		tijiaolunwenService.add(tijiaolunwen);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "tijiaolunwenList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:tijiaolunwenList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateTijiaolunwen.do")
	public String doUpdateTijiaolunwen(int id,ModelMap map,Tijiaolunwen tijiaolunwen){
		tijiaolunwen=tijiaolunwenService.getById(id);
		map.put("tijiaolunwen", tijiaolunwen);
		return "tijiaolunwen_updt";
	}
	
	
	
	@RequestMapping("doUpdateTijiaolunwenlb.do")
	public String doUpdateTijiaolunwenlb(int id,ModelMap map,Tijiaolunwen tijiaolunwen){
		tijiaolunwen=tijiaolunwenService.getById(id);
		map.put("tijiaolunwen", tijiaolunwen);
		return "tijiaolunwen_updtlb";
	}
	
@RequestMapping("updateTijiaolunwenlb.do")
	public String updateTijiaolunwenlb(int id,ModelMap map,Tijiaolunwen tijiaolunwen){
		tijiaolunwenService.updatelb(tijiaolunwen);
		return "redirect:tijiaolunwenList.do";
	}
	
//	后台详细
	@RequestMapping("tijiaolunwenDetail.do")
	public String tijiaolunwenDetail(int id,ModelMap map,Tijiaolunwen tijiaolunwen){
		tijiaolunwen=tijiaolunwenService.getById(id);
		map.put("tijiaolunwen", tijiaolunwen);
		return "tijiaolunwen_detail";
	}
//	前台详细
	@RequestMapping("tjlwDetail.do")
	public String tjlwDetail(int id,ModelMap map,Tijiaolunwen tijiaolunwen){
		tijiaolunwen=tijiaolunwenService.getById(id);
		map.put("tijiaolunwen", tijiaolunwen);
		return "tijiaolunwendetail";
	}
//	
	@RequestMapping("updateTijiaolunwen.do")
	public String updateTijiaolunwen(int id,ModelMap map,Tijiaolunwen tijiaolunwen,HttpServletRequest request,HttpSession session){
		tijiaolunwenService.update(tijiaolunwen);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:tijiaolunwenList.do";
	}

//	分页查询
	@RequestMapping("tijiaolunwenList.do")
	public String tijiaolunwenList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijiaolunwen tijiaolunwen, String gonghao, String xingming, String xingbie, String kaitimingcheng, String xuesheng, String lunwen, String pingshen, String dengji, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(kaitimingcheng==null||kaitimingcheng.equals("")){pmap.put("kaitimingcheng", null);}else{pmap.put("kaitimingcheng", kaitimingcheng);}
		if(xuesheng==null||xuesheng.equals("")){pmap.put("xuesheng", null);}else{pmap.put("xuesheng", xuesheng);}
		if(lunwen==null||lunwen.equals("")){pmap.put("lunwen", null);}else{pmap.put("lunwen", lunwen);}
		if(pingshen==null||pingshen.equals("")){pmap.put("pingshen", null);}else{pmap.put("pingshen", pingshen);}
		if(dengji==null||dengji.equals("")){pmap.put("dengji", null);}else{pmap.put("dengji", dengji);}
		
		int total=tijiaolunwenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijiaolunwen> list=tijiaolunwenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijiaolunwen_list";
	}
	
	
	
	@RequestMapping("tijiaolunwenList2.do")
	public String tijiaolunwenList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijiaolunwen tijiaolunwen, String gonghao, String xingming, String xingbie, String kaitimingcheng, String xuesheng, String lunwen, String pingshen, String dengji, String issh,HttpServletRequest request){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("xuesheng", (String)request.getSession().getAttribute("username"));
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(kaitimingcheng==null||kaitimingcheng.equals("")){pmap.put("kaitimingcheng", null);}else{pmap.put("kaitimingcheng", kaitimingcheng);}
		
		if(lunwen==null||lunwen.equals("")){pmap.put("lunwen", null);}else{pmap.put("lunwen", lunwen);}
		if(pingshen==null||pingshen.equals("")){pmap.put("pingshen", null);}else{pmap.put("pingshen", pingshen);}
		if(dengji==null||dengji.equals("")){pmap.put("dengji", null);}else{pmap.put("dengji", dengji);}
		
		int total=tijiaolunwenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijiaolunwen> list=tijiaolunwenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijiaolunwen_list2";
	}
	
	
	
	
	
	@RequestMapping("tijiaolunwenList3.do")
	public String tijiaolunwenList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijiaolunwen tijiaolunwen, String gonghao, String xingming, String xingbie, String kaitimingcheng, String xuesheng, String lunwen, String pingshen, String dengji, String issh,HttpServletRequest request){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("gonghao", (String)request.getSession().getAttribute("username"));
		
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(kaitimingcheng==null||kaitimingcheng.equals("")){pmap.put("kaitimingcheng", null);}else{pmap.put("kaitimingcheng", kaitimingcheng);}
		if(xuesheng==null||xuesheng.equals("")){pmap.put("xuesheng", null);}else{pmap.put("xuesheng", xuesheng);}
		if(lunwen==null||lunwen.equals("")){pmap.put("lunwen", null);}else{pmap.put("lunwen", lunwen);}
		if(pingshen==null||pingshen.equals("")){pmap.put("pingshen", null);}else{pmap.put("pingshen", pingshen);}
		if(dengji==null||dengji.equals("")){pmap.put("dengji", null);}else{pmap.put("dengji", dengji);}
		
		int total=tijiaolunwenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijiaolunwen> list=tijiaolunwenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijiaolunwen_list3";
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("tjlwList.do")
	public String tjlwList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tijiaolunwen tijiaolunwen, String gonghao, String xingming, String xingbie, String kaitimingcheng, String xuesheng, String lunwen, String pingshen, String dengji, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(kaitimingcheng==null||kaitimingcheng.equals("")){pmap.put("kaitimingcheng", null);}else{pmap.put("kaitimingcheng", kaitimingcheng);}
		if(xuesheng==null||xuesheng.equals("")){pmap.put("xuesheng", null);}else{pmap.put("xuesheng", xuesheng);}
		if(lunwen==null||lunwen.equals("")){pmap.put("lunwen", null);}else{pmap.put("lunwen", lunwen);}
		if(pingshen==null||pingshen.equals("")){pmap.put("pingshen", null);}else{pmap.put("pingshen", pingshen);}
		if(dengji==null||dengji.equals("")){pmap.put("dengji", null);}else{pmap.put("dengji", dengji);}
		
		int total=tijiaolunwenService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tijiaolunwen> list=tijiaolunwenService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tijiaolunwenlist";
	}
	
	@RequestMapping("deleteTijiaolunwen.do")
	public String deleteTijiaolunwen(int id,HttpServletRequest request){
		tijiaolunwenService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:tijiaolunwenList.do";
	}
	
	
}
