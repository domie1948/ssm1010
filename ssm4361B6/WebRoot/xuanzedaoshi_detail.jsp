<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>选择导师详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  选择导师详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${xuanzedaoshi.gonghao}</td>     <td width='11%'>姓名：</td><td width='39%'>${xuanzedaoshi.xingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${xuanzedaoshi.xingbie}</td>     <td width='11%'>可选人数：</td><td width='39%'>${xuanzedaoshi.kexuanrenshu}</td></tr><tr>     <td width='11%'>已选人数：</td><td width='39%'>${xuanzedaoshi.yixuanrenshu}</td>     <td width='11%'>学生：</td><td width='39%'>${xuanzedaoshi.xuesheng}</td></tr><tr>     <td width='11%'>联系方式：</td><td width='39%'>${xuanzedaoshi.lianxifangshi}</td>     <td width='11%'>备注：</td><td width='39%'>${xuanzedaoshi.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

