﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>添加公告信息</TITLE>
	    

 	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>      
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="gonggaoxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addGonggaoxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加公告信息</td>
						</tr>
						<tr ><td width="200">公告名称：</td><td><input name='gonggaomingcheng' type='text' id='gonggaomingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelgonggaomingcheng' /></td></tr>
		<tr ><td width="200">内容：</td><td><textarea name='neirong' cols='50' rows='5' id='neirong' onblur='checkform()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabelneirong' /></td></tr>
		
		<tr 2><td width="200">发布时间：</td><td><input name='fabushijian' type='text' id='baoxifabushijianaoshijian' value='<%=connDbBean.gettime()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd HH:mm:ss'})" style='width:120px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelfabushijian' /></td></tr>
		<tr ><td width="200">发布人：</td><td><input name='faburen' type='text' id='faburen' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var gonggaomingchengobj = document.getElementById("gonggaomingcheng"); if(gonggaomingchengobj.value==""){document.getElementById("clabelgonggaomingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入公告名称</font>";return false;}else{document.getElementById("clabelgonggaomingcheng").innerHTML="  "; } 
	var neirongobj = document.getElementById("neirong"); if(neirongobj.value==""){document.getElementById("clabelneirong").innerHTML="&nbsp;&nbsp;<font color=red>请输入内容</font>";return false;}else{document.getElementById("clabelneirong").innerHTML="  "; } 
	var fabushijianobj = document.getElementById("fabushijian"); if(fabushijianobj.value==""){document.getElementById("clabelfabushijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入发布时间</font>";return false;}else{document.getElementById("clabelfabushijian").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
