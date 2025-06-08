<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="kaitixinxihsgb" scope="page" class="com.bean.KaitixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=kaitixinxi.xls");
%>
<html>
  <head>
    <title>开题信息</title>
  </head>

  <body >
 <%
			String sql="select * from kaitixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>工号</td>    <td align='center'>姓名</td>    <td  width='40' align='center'>性别</td>    <td align='center'>开题名称</td>    <td  width='90' align='center'>开题报告</td>    <td align='center'>状态</td>    <td  width='95' align='center'>提交时间</td>    <td align='center'>学生</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=kaitixinxihsgb.getAllKaitixinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.gonghao}</td>    <td>${u.xingming}</td>    <td align='center'>${u.xingbie}</td>    <td>${u.kaitimingcheng}</td>    <td width='90' align='center'><a href='${u.kaitibaogao}' target='_blank'>下载</a></td>    <td>${u.zhuangtai}</td>    <td>${u.tijiaoshijian}</td>    <td>${u.xuesheng}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

