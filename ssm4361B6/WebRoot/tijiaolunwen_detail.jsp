<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>提交论文详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  提交论文详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${tijiaolunwen.gonghao}</td>     <td width='11%'>姓名：</td><td width='39%'>${tijiaolunwen.xingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${tijiaolunwen.xingbie}</td>     <td width='11%'>开题名称：</td><td width='39%'>${tijiaolunwen.kaitimingcheng}</td></tr><tr>     <td width='11%'>学生：</td><td width='39%'>${tijiaolunwen.xuesheng}</td>     <td width='11%'>论文：</td><td width='39%'><a href="${tijiaolunwen.lunwen}">点此下载</a></td></tr><tr>     <td width='11%'>评审：</td><td width='39%'>${tijiaolunwen.pingshen}</td>     <td width='11%'>等级：</td><td width='39%'>${tijiaolunwen.dengji}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

