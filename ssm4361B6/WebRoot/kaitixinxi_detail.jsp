<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>开题信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  开题信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>工号：</td><td width='39%'>${kaitixinxi.gonghao}</td>     <td width='11%'>姓名：</td><td width='39%'>${kaitixinxi.xingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${kaitixinxi.xingbie}</td>     <td width='11%'>开题名称：</td><td width='39%'>${kaitixinxi.kaitimingcheng}</td></tr><tr>     <td width='11%'>开题报告：</td><td width='39%'><a href="${kaitixinxi.kaitibaogao}">点此下载</a></td>     <td width='11%'>状态：</td><td width='39%'>${kaitixinxi.zhuangtai}</td></tr><tr>     <td width='11%'>提交时间：</td><td width='39%'>${kaitixinxi.tijiaoshijian}</td>     <td width='11%'>学生：</td><td width='39%'>${kaitixinxi.xuesheng}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${kaitixinxi.beizhu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

