<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<TITLE>设置开题信息</TITLE>
	    
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
	document.location.href="kaitixinxi_add.jsp?id=<%=id%>";
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
			<form action="updateKaitixinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">设置开题信息<input type="hidden" name="id" value="${kaitixinxi.id}" /></td>
						</tr>
						<tr style='display:none'><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">性别：</td><td><input name='xingbie' type='text' id='xingbie' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">开题名称：</td><td><input name='kaitimingcheng' type='text' id='kaitimingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelkaitimingcheng' /></td></tr>
		<tr style='display:none'><td width="200">开题报告：</td><td><input name='kaitibaogao' type='text' id='kaitibaogao' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('kaitibaogao')" style='border:solid 1px #000000; color:#666666'/></td></tr>
		<tr ><td width="200">状态：</td><td><select name='zhuangtai' id='zhuangtai'><option <option value="已驳回">已驳回</option><option value="审批通过">审批通过</option></select></td></tr>
		<tr style='display:none'><td width="200">提交时间：</td><td><input name='tijiaoshijian' type='text' id='tijiaoshijian' value='<%=connDbBean.gettime()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd HH:mm:ss'})" style='width:120px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabeltijiaoshijian' /></td></tr>
		<tr style='display:none'><td width="200">学生：</td><td><input name='xuesheng' type='text' id='xuesheng' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly"  readonly='readonly' /></td></tr>
		<tr style='display:none'><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.gonghao.value='${kaitixinxi.gonghao}';</script>
	<script language="javascript">document.form1.xingming.value='${kaitixinxi.xingming}';</script>
	<script language="javascript">document.form1.xingbie.value='${kaitixinxi.xingbie}';</script>
	<script language="javascript">document.form1.kaitimingcheng.value='${kaitixinxi.kaitimingcheng}';</script>
	<script language="javascript">document.form1.kaitibaogao.value='${kaitixinxi.kaitibaogao}';</script>
	<script language="javascript">document.form1.zhuangtai.value='${kaitixinxi.zhuangtai}';</script>
	<script language="javascript">document.form1.tijiaoshijian.value='${kaitixinxi.tijiaoshijian}';</script>
	<script language="javascript">document.form1.xuesheng.value='${kaitixinxi.xuesheng}';</script>
	<script language="javascript">document.form1.beizhu.value='${kaitixinxi.beizhu}';</script>
	
					 </table>
			</form>
   </body>
</html>





<script language=javascript >  
 
 function checkform(){  
 
	var kaitimingchengobj = document.getElementById("kaitimingcheng"); if(kaitimingchengobj.value==""){document.getElementById("clabelkaitimingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入开题名称</font>";return false;}else{document.getElementById("clabelkaitimingcheng").innerHTML="  "; } 
	var tijiaoshijianobj = document.getElementById("tijiaoshijian"); if(tijiaoshijianobj.value==""){document.getElementById("clabeltijiaoshijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入提交时间</font>";return false;}else{document.getElementById("clabeltijiaoshijian").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
