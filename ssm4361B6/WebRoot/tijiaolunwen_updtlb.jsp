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
		<TITLE>设置提交论文</TITLE>
	    
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
//islbd1q 
   %>
<script language="javascript">

function gows()
{
	document.location.href="tijiaolunwen_add.jsp?id=<%=id%>";
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
			<form action="updateTijiaolunwen.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">设置提交论文<input type="hidden" name="id" value="${tijiaolunwen.id}" /></td>
						</tr>
						<tr style='display:none'><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">性别：</td><td><input name='xingbie' type='text' id='xingbie' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">开题名称：</td><td><input name='kaitimingcheng' type='text' id='kaitimingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">学生：</td><td><input name='xuesheng' type='text' id='xuesheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">论文：</td><td><input name='lunwen' type='text' id='lunwen' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('lunwen')" style='border:solid 1px #000000; color:#666666'/></td></tr>
		<tr ><td width="200">评审：</td><td><select name='pingshen' id='pingshen'><option value="合格">合格</option><option value="不合格">不合格</option></select></td></tr>
		<tr ><td width="200">等级：</td><td><select name='dengji' id='dengji'><option value="A">A</option><option value="B">B</option><option value="C">C</option><option value="D">D</option></select></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.gonghao.value='${tijiaolunwen.gonghao}';</script>
	<script language="javascript">document.form1.xingming.value='${tijiaolunwen.xingming}';</script>
	<script language="javascript">document.form1.xingbie.value='${tijiaolunwen.xingbie}';</script>
	<script language="javascript">document.form1.kaitimingcheng.value='${tijiaolunwen.kaitimingcheng}';</script>
	<script language="javascript">document.form1.xuesheng.value='${tijiaolunwen.xuesheng}';</script>
	<script language="javascript">document.form1.lunwen.value='${tijiaolunwen.lunwen}';</script>
	<script language="javascript">document.form1.pingshen.value='${tijiaolunwen.pingshen}';</script>
	<script language="javascript">document.form1.dengji.value='${tijiaolunwen.dengji}';</script>
	
					 </table>
			</form>
   </body>
</html>





