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

import com.entity.Xuanzedaoshi;
import com.server.XuanzedaoshiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XuanzedaoshiController {
	@Resource
	private XuanzedaoshiServer xuanzedaoshiService;


   
	@RequestMapping("addXuanzedaoshi.do")
	public String addXuanzedaoshi(HttpServletRequest request,Xuanzedaoshi xuanzedaoshi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		String sql="";
		sql="select id from xuanzedaoshi where 1=1  and gonghao='"+xuanzedaoshi.getGonghao()+"' and xuesheng='"+xuanzedaoshi.getXuesheng()+"'";
		db dbo = new db();
		ResultSet rs=null;
		rs=dbo.executeQuery(sql);
		int tt=0;
		while(rs.next()){

				tt++;
		}

		if(tt>=1)
		{
			
			session.setAttribute("backxx", "你已申请过该导师！");
			session.setAttribute("backurl", request.getHeader("Referer"));
			
			//session.setAttribute("backurl", "xuanzedaoshiList.do");
			
			return "redirect:postback.jsp";
			//return "redirect:xuanzedaoshiList.do";
		}
		xuanzedaoshi.setAddtime(time.toString().substring(0, 19));
		xuanzedaoshiService.add(xuanzedaoshi);
		
		
		
		
		
			


		sql="update jiaoshixinxi set yixuanrenshu=yixuanrenshu+1  where gonghao='"+request.getParameter("gonghao")+"'";
		db dbo2 = new db();
		dbo2.hsgexecute(sql);


		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xuanzedaoshiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xuanzedaoshiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXuanzedaoshi.do")
	public String doUpdateXuanzedaoshi(int id,ModelMap map,Xuanzedaoshi xuanzedaoshi){
		xuanzedaoshi=xuanzedaoshiService.getById(id);
		map.put("xuanzedaoshi", xuanzedaoshi);
		return "xuanzedaoshi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xuanzedaoshiDetail.do")
	public String xuanzedaoshiDetail(int id,ModelMap map,Xuanzedaoshi xuanzedaoshi){
		xuanzedaoshi=xuanzedaoshiService.getById(id);
		map.put("xuanzedaoshi", xuanzedaoshi);
		return "xuanzedaoshi_detail";
	}
//	前台详细
	@RequestMapping("xzdsDetail.do")
	public String xzdsDetail(int id,ModelMap map,Xuanzedaoshi xuanzedaoshi){
		xuanzedaoshi=xuanzedaoshiService.getById(id);
		map.put("xuanzedaoshi", xuanzedaoshi);
		return "xuanzedaoshidetail";
	}
//	
	@RequestMapping("updateXuanzedaoshi.do")
	public String updateXuanzedaoshi(int id,ModelMap map,Xuanzedaoshi xuanzedaoshi,HttpServletRequest request,HttpSession session){
		xuanzedaoshiService.update(xuanzedaoshi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xuanzedaoshiList.do";
	}

//	分页查询
	@RequestMapping("xuanzedaoshiList.do")
	public String xuanzedaoshiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuanzedaoshi xuanzedaoshi, String gonghao, String xingming, String xingbie, String kexuanrenshu, String yixuanrenshu, String xuesheng, String lianxifangshi, String beizhu, String issh){
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
		if(kexuanrenshu==null||kexuanrenshu.equals("")){pmap.put("kexuanrenshu", null);}else{pmap.put("kexuanrenshu", kexuanrenshu);}
		if(yixuanrenshu==null||yixuanrenshu.equals("")){pmap.put("yixuanrenshu", null);}else{pmap.put("yixuanrenshu", yixuanrenshu);}
		if(xuesheng==null||xuesheng.equals("")){pmap.put("xuesheng", null);}else{pmap.put("xuesheng", xuesheng);}
		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=xuanzedaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuanzedaoshi> list=xuanzedaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuanzedaoshi_list";
	}
	
	@RequestMapping("xuanzedaoshiList3.do")
	public String xuanzedaoshiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuanzedaoshi xuanzedaoshi, String gonghao, String xingming, String xingbie, String kexuanrenshu, String yixuanrenshu, String xuesheng, String lianxifangshi, String beizhu, String issh,HttpServletRequest request){
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
		
		pmap.put("gonghao", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(kexuanrenshu==null||kexuanrenshu.equals("")){pmap.put("kexuanrenshu", null);}else{pmap.put("kexuanrenshu", kexuanrenshu);}
		if(yixuanrenshu==null||yixuanrenshu.equals("")){pmap.put("yixuanrenshu", null);}else{pmap.put("yixuanrenshu", yixuanrenshu);}
		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=xuanzedaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuanzedaoshi> list=xuanzedaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuanzedaoshi_list3";
	}
	@RequestMapping("xuanzedaoshiList2.do")
	public String xuanzedaoshiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuanzedaoshi xuanzedaoshi, String gonghao, String xingming, String xingbie, String kexuanrenshu, String yixuanrenshu, String xuesheng, String lianxifangshi, String beizhu, String issh,HttpServletRequest request){
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
		
		pmap.put("xuesheng", (String)request.getSession().getAttribute("username"));
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(kexuanrenshu==null||kexuanrenshu.equals("")){pmap.put("kexuanrenshu", null);}else{pmap.put("kexuanrenshu", kexuanrenshu);}
		if(yixuanrenshu==null||yixuanrenshu.equals("")){pmap.put("yixuanrenshu", null);}else{pmap.put("yixuanrenshu", yixuanrenshu);}
		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=xuanzedaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuanzedaoshi> list=xuanzedaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuanzedaoshi_list2";
	}
	
	
	@RequestMapping("xzdsList.do")
	public String xzdsList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuanzedaoshi xuanzedaoshi, String gonghao, String xingming, String xingbie, String kexuanrenshu, String yixuanrenshu, String xuesheng, String lianxifangshi, String beizhu, String issh){
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
		if(kexuanrenshu==null||kexuanrenshu.equals("")){pmap.put("kexuanrenshu", null);}else{pmap.put("kexuanrenshu", kexuanrenshu);}
		if(yixuanrenshu==null||yixuanrenshu.equals("")){pmap.put("yixuanrenshu", null);}else{pmap.put("yixuanrenshu", yixuanrenshu);}
		if(xuesheng==null||xuesheng.equals("")){pmap.put("xuesheng", null);}else{pmap.put("xuesheng", xuesheng);}
		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=xuanzedaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuanzedaoshi> list=xuanzedaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuanzedaoshilist";
	}
	
	@RequestMapping("deleteXuanzedaoshi.do")
	public String deleteXuanzedaoshi(int id,HttpServletRequest request){
		xuanzedaoshiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xuanzedaoshiList.do";
	}
	
	
}
