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

import com.entity.Tongzhi;
import com.server.TongzhiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class TongzhiController {
	@Resource
	private TongzhiServer tongzhiService;


   
	@RequestMapping("addTongzhi.do")
	public String addTongzhi(HttpServletRequest request,Tongzhi tongzhi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		tongzhi.setAddtime(time.toString().substring(0, 19));
		tongzhiService.add(tongzhi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "tongzhiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:tongzhiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateTongzhi.do")
	public String doUpdateTongzhi(int id,ModelMap map,Tongzhi tongzhi){
		tongzhi=tongzhiService.getById(id);
		map.put("tongzhi", tongzhi);
		return "tongzhi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("tongzhiDetail.do")
	public String tongzhiDetail(int id,ModelMap map,Tongzhi tongzhi){
		tongzhi=tongzhiService.getById(id);
		map.put("tongzhi", tongzhi);
		return "tongzhi_detail";
	}
//	前台详细
	@RequestMapping("tzDetail.do")
	public String tzDetail(int id,ModelMap map,Tongzhi tongzhi){
		tongzhi=tongzhiService.getById(id);
		map.put("tongzhi", tongzhi);
		return "tongzhidetail";
	}
//	
	@RequestMapping("updateTongzhi.do")
	public String updateTongzhi(int id,ModelMap map,Tongzhi tongzhi,HttpServletRequest request,HttpSession session){
		tongzhiService.update(tongzhi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:tongzhiList.do";
	}

//	分页查询
	@RequestMapping("tongzhiList.do")
	public String tongzhiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tongzhi tongzhi, String faburen, String tongzhineirong, String jieshouren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		if(tongzhineirong==null||tongzhineirong.equals("")){pmap.put("tongzhineirong", null);}else{pmap.put("tongzhineirong", tongzhineirong);}		if(jieshouren==null||jieshouren.equals("")){pmap.put("jieshouren", null);}else{pmap.put("jieshouren", jieshouren);}		
		int total=tongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tongzhi> list=tongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tongzhi_list";
	}
	
	@RequestMapping("tongzhiList2.do")
	public String tongzhiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tongzhi tongzhi, String faburen, String tongzhineirong, String jieshouren,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("faburen", (String)request.getSession().getAttribute("username"));
		if(tongzhineirong==null||tongzhineirong.equals("")){pmap.put("tongzhineirong", null);}else{pmap.put("tongzhineirong", tongzhineirong);}		
		
		int total=tongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tongzhi> list=tongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tongzhi_list2";
	}	@RequestMapping("tongzhiList3.do")
	public String tongzhiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tongzhi tongzhi, String faburen, String tongzhineirong, String jieshouren,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("jieshouren", (String)request.getSession().getAttribute("username"));
		if(tongzhineirong==null||tongzhineirong.equals("")){pmap.put("tongzhineirong", null);}else{pmap.put("tongzhineirong", tongzhineirong);}		
		
		int total=tongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tongzhi> list=tongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tongzhi_list3";
	}	
	
	@RequestMapping("tzList.do")
	public String tzList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tongzhi tongzhi, String faburen, String tongzhineirong, String jieshouren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		if(tongzhineirong==null||tongzhineirong.equals("")){pmap.put("tongzhineirong", null);}else{pmap.put("tongzhineirong", tongzhineirong);}		if(jieshouren==null||jieshouren.equals("")){pmap.put("jieshouren", null);}else{pmap.put("jieshouren", jieshouren);}		
		int total=tongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tongzhi> list=tongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tongzhilist";
	}
	
	@RequestMapping("deleteTongzhi.do")
	public String deleteTongzhi(int id,HttpServletRequest request){
		tongzhiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:tongzhiList.do";
	}
	
	
}
