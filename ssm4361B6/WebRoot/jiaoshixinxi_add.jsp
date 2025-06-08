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
		<TITLE>添加教师信息</TITLE>
	    

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
	document.location.href="jiaoshixinxi_add.jsp?id=<%=id%>";
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
			<form action="addJiaoshixinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加教师信息</td>
						</tr>
						<tr ><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelgonghao' /></td></tr>
		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmima' /></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxingming' /></td></tr>
		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie'><option value="男">男</option><option value="女">女</option></select>&nbsp;*<label id='clabelxingbie' /></td></tr>
		<tr ><td width="200">年龄：</td><td><input name='nianling' type='text' id='nianling' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelnianling' /></td></tr>
		<tr ><td width="200">联系方式：</td><td><input name='lianxifangshi' type='text' id='lianxifangshi' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabellianxifangshi' /></td></tr>
		<tr ><td width="200">照片：</td><td><input name='zhaopian' type='text' id='zhaopian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('zhaopian')" style='border:solid 1px #000000; color:#666666'/></td></tr>
		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		<tr ><td width="200">可选人数：</td><td><input name='kexuanrenshu' type='text' id='kexuanrenshu' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelkexuanrenshu' />必需数字型</td></tr>
		<tr 0><td width="200">已选人数：</td><td><input name='yixuanrenshu' type='text' id='yixuanrenshu' value='0' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelyixuanrenshu' />必需数字型</td></tr>
		
		
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
function hsgcheck() {
		var gonghao = $("#gonghao").val();
		if(gonghao==""||(gonghao.length<6||gonghao.length>12)){
			 $("#clabelgonghao").html("<font color=red>工号不能为空且长度在3～12位之间！</font>");
			 $("input[id=gonghao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelgonghao").html("");
			$.ajax({
				url : "quchongJiaoshixinxi.do",
				type : "post",
				data : "gonghao=" + gonghao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelgonghao").html("<font color=red>工号已存在，请更换！</font>");
					$("input[id=gonghao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelgonghao").html("系统异常，请检查错误！");
					$("input[id=gonghao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>


<script language=javascript >  
 
 function checkform(){  
 
	var gonghaoobj = document.getElementById("gonghao"); if(gonghaoobj.value==""){document.getElementById("clabelgonghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入工号</font>";return false;}else{document.getElementById("clabelgonghao").innerHTML="  "; } 
	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 
	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 
	var xingbieobj = document.getElementById("xingbie"); if(xingbieobj.value==""){document.getElementById("clabelxingbie").innerHTML="&nbsp;&nbsp;<font color=red>请输入性别</font>";return false;}else{document.getElementById("clabelxingbie").innerHTML="  "; } 
	var nianlingobj = document.getElementById("nianling"); if(nianlingobj.value==""){document.getElementById("clabelnianling").innerHTML="&nbsp;&nbsp;<font color=red>请输入年龄</font>";return false;}else{document.getElementById("clabelnianling").innerHTML="  "; } 
	var nianlingobj = document.getElementById("nianling"); if(nianlingobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(nianlingobj.value)){document.getElementById("clabelnianling").innerHTML=""; }else{document.getElementById("clabelnianling").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var lianxifangshiobj = document.getElementById("lianxifangshi"); if(lianxifangshiobj.value==""){document.getElementById("clabellianxifangshi").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系方式</font>";return false;}else{document.getElementById("clabellianxifangshi").innerHTML="  "; } 
	var lianxifangshiobj = document.getElementById("lianxifangshi"); if(lianxifangshiobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxifangshiobj.value)){document.getElementById("clabellianxifangshi").innerHTML=""; }else{document.getElementById("clabellianxifangshi").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}  
    var kexuanrenshuobj = document.getElementById("kexuanrenshu"); if(kexuanrenshuobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(kexuanrenshuobj.value)){document.getElementById("clabelkexuanrenshu").innerHTML=""; }else{document.getElementById("clabelkexuanrenshu").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var yixuanrenshuobj = document.getElementById("yixuanrenshu"); if(yixuanrenshuobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(yixuanrenshuobj.value)){document.getElementById("clabelyixuanrenshu").innerHTML=""; }else{document.getElementById("clabelyixuanrenshu").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    if(parseInt(document.form1.kexuanrenshu.value)<parseInt(document.form1.yixuanrenshu.value)){alert("对不起，可选人数必需大于已选人数");return false;}
	


return true;   
}   
popheight=450;
</script>  
