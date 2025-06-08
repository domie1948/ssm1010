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

import com.entity.Kaitixinxi;
import com.server.KaitixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KaitixinxiController {
	@Resource
	private KaitixinxiServer kaitixinxiService;


   
	@RequestMapping("addKaitixinxi.do")
	public String addKaitixinxi(HttpServletRequest request,Kaitixinxi kaitixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kaitixinxi.setAddtime(time.toString().substring(0, 19));
		kaitixinxiService.add(kaitixinxi);
		
		String sql="";
		sql="update kaitixinxi set zhuangtai='已提交'  where xuesheng='"+request.getParameter("xuesheng")+"'";
		db dbo2 = new db();
		dbo2.hsgexecute(sql);
		
		
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kaitixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kaitixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKaitixinxi.do")
	public String doUpdateKaitixinxi(int id,ModelMap map,Kaitixinxi kaitixinxi){
		kaitixinxi=kaitixinxiService.getById(id);
		map.put("kaitixinxi", kaitixinxi);
		return "kaitixinxi_updt";
	}
	
	
	
	@RequestMapping("doUpdateKaitixinxilb.do")
	public String doUpdateKaitixinxilb(int id,ModelMap map,Kaitixinxi kaitixinxi){
		kaitixinxi=kaitixinxiService.getById(id);
		map.put("kaitixinxi", kaitixinxi);
		return "kaitixinxi_updtlb";
	}
	
@RequestMapping("updateKaitixinxilb.do")
	public String updateKaitixinxilb(int id,ModelMap map,Kaitixinxi kaitixinxi){
		kaitixinxiService.updatelb(kaitixinxi);
		return "redirect:kaitixinxiList.do";
	}
	
//	后台详细
	@RequestMapping("kaitixinxiDetail.do")
	public String kaitixinxiDetail(int id,ModelMap map,Kaitixinxi kaitixinxi){
		kaitixinxi=kaitixinxiService.getById(id);
		map.put("kaitixinxi", kaitixinxi);
		return "kaitixinxi_detail";
	}
//	前台详细
	@RequestMapping("ktxxDetail.do")
	public String ktxxDetail(int id,ModelMap map,Kaitixinxi kaitixinxi){
		kaitixinxi=kaitixinxiService.getById(id);
		map.put("kaitixinxi", kaitixinxi);
		return "kaitixinxidetail";
	}
//	
	@RequestMapping("updateKaitixinxi.do")
	public String updateKaitixinxi(int id,ModelMap map,Kaitixinxi kaitixinxi,HttpServletRequest request,HttpSession session){
		kaitixinxiService.update(kaitixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kaitixinxiList.do";
	}

//	分页查询
	@RequestMapping("kaitixinxiList.do")
	public String kaitixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaitixinxi kaitixinxi, String gonghao, String xingming, String xingbie, String kaitimingcheng, String kaitibaogao, String zhuangtai, String tijiaoshijian1,String tijiaoshijian2, String xuesheng, String beizhu){
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
		if(kaitibaogao==null||kaitibaogao.equals("")){pmap.put("kaitibaogao", null);}else{pmap.put("kaitibaogao", kaitibaogao);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(tijiaoshijian1==null||tijiaoshijian1.equals("")){pmap.put("tijiaoshijian1", null);}else{pmap.put("tijiaoshijian1", tijiaoshijian1);}
		if(tijiaoshijian2==null||tijiaoshijian2.equals("")){pmap.put("tijiaoshijian2", null);}else{pmap.put("tijiaoshijian2", tijiaoshijian2);}
		if(xuesheng==null||xuesheng.equals("")){pmap.put("xuesheng", null);}else{pmap.put("xuesheng", xuesheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=kaitixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaitixinxi> list=kaitixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaitixinxi_list";
	}
	
	@RequestMapping("kaitixinxiList2.do")
	public String kaitixinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaitixinxi kaitixinxi, String gonghao, String xingming, String xingbie, String kaitimingcheng, String kaitibaogao, String zhuangtai, String tijiaoshijian1,String tijiaoshijian2, String xuesheng, String beizhu,HttpServletRequest request){
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
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(kaitimingcheng==null||kaitimingcheng.equals("")){pmap.put("kaitimingcheng", null);}else{pmap.put("kaitimingcheng", kaitimingcheng);}
		if(kaitibaogao==null||kaitibaogao.equals("")){pmap.put("kaitibaogao", null);}else{pmap.put("kaitibaogao", kaitibaogao);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(tijiaoshijian1==null||tijiaoshijian1.equals("")){pmap.put("tijiaoshijian1", null);}else{pmap.put("tijiaoshijian1", tijiaoshijian1);}
		if(tijiaoshijian2==null||tijiaoshijian2.equals("")){pmap.put("tijiaoshijian2", null);}else{pmap.put("tijiaoshijian2", tijiaoshijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=kaitixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaitixinxi> list=kaitixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaitixinxi_list2";
	}
	
	
	
	@RequestMapping("kaitixinxiList3.do")
	public String kaitixinxiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaitixinxi kaitixinxi, String gonghao, String xingming, String xingbie, String kaitimingcheng, String kaitibaogao, String zhuangtai, String tijiaoshijian1,String tijiaoshijian2, String xuesheng, String beizhu,HttpServletRequest request){
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
		if(kaitimingcheng==null||kaitimingcheng.equals("")){pmap.put("kaitimingcheng", null);}else{pmap.put("kaitimingcheng", kaitimingcheng);}
		if(kaitibaogao==null||kaitibaogao.equals("")){pmap.put("kaitibaogao", null);}else{pmap.put("kaitibaogao", kaitibaogao);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(tijiaoshijian1==null||tijiaoshijian1.equals("")){pmap.put("tijiaoshijian1", null);}else{pmap.put("tijiaoshijian1", tijiaoshijian1);}
		if(tijiaoshijian2==null||tijiaoshijian2.equals("")){pmap.put("tijiaoshijian2", null);}else{pmap.put("tijiaoshijian2", tijiaoshijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=kaitixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaitixinxi> list=kaitixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaitixinxi_list3";
	}
	
	
	
	
	
	
	@RequestMapping("ktxxList.do")
	public String ktxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kaitixinxi kaitixinxi, String gonghao, String xingming, String xingbie, String kaitimingcheng, String kaitibaogao, String zhuangtai, String tijiaoshijian1,String tijiaoshijian2, String xuesheng, String beizhu){
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
		if(kaitibaogao==null||kaitibaogao.equals("")){pmap.put("kaitibaogao", null);}else{pmap.put("kaitibaogao", kaitibaogao);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(tijiaoshijian1==null||tijiaoshijian1.equals("")){pmap.put("tijiaoshijian1", null);}else{pmap.put("tijiaoshijian1", tijiaoshijian1);}
		if(tijiaoshijian2==null||tijiaoshijian2.equals("")){pmap.put("tijiaoshijian2", null);}else{pmap.put("tijiaoshijian2", tijiaoshijian2);}
		if(xuesheng==null||xuesheng.equals("")){pmap.put("xuesheng", null);}else{pmap.put("xuesheng", xuesheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=kaitixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kaitixinxi> list=kaitixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kaitixinxilist";
	}
	
	@RequestMapping("deleteKaitixinxi.do")
	public String deleteKaitixinxi(int id,HttpServletRequest request){
		kaitixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kaitixinxiList.do";
	}
	
	
}
