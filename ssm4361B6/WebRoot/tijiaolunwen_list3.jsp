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
	<TITLE>提交论文查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">提交论文列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="tijiaolunwenList.do" name="myform" method="post">
									查询   工号：<input name="gonghao" type="text" id="gonghao" style='border:solid 1px #000000; color:#666666' size="12" />  姓名：<input name="xingming" type="text" id="xingming" style='border:solid 1px #000000; color:#666666' size="12" />  性别：<input name="xingbie" type="text" id="xingbie" style='border:solid 1px #000000; color:#666666' size="12" />  开题名称：<input name="kaitimingcheng" type="text" id="kaitimingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  学生：<input name="xuesheng" type="text" id="xuesheng" style='border:solid 1px #000000; color:#666666' size="12" />  论文：<input name="lunwen" type="text" id="lunwen" style='border:solid 1px #000000; color:#666666' size="12" /> 评审：<select name='pingshen' id='pingshen' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="合格">合格</option><option value="不合格">不合格</option></select>  等级：<input name="dengji" type="text" id="dengji" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>工号</td>
    <td align='center'>姓名</td>
    <td  width='40' align='center'>性别</td>
    <td align='center'>开题名称</td>
    <td align='center'>学生</td>
    <td  width='90' align='center'>论文</td>
    <td align='center'>评审</td>
    <td align='center'>等级</td>
    <td  width='80' align='center'>是否审核</td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.gonghao}</td>
    <td>${u.xingming}</td>
    <td align='center'>${u.xingbie}</td>
    <td>${u.kaitimingcheng}</td>
    <td>${u.xuesheng}</td>
    <td width='90' align='center'><a href='${u.lunwen}' target='_blank'>下载</a></td>
    <td>${u.pingshen}</td>
    <td>${u.dengji}</td>
    <td align='center'>${u.issh} <input type="button" value="审核" onClick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=tijiaolunwen'"/></td>
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateTijiaolunwenlb.do?id=${u.id }">审批</a>  <a href="tijiaolunwenDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="tijiaolunwenList.do?page=1" >首页</a>
             <a href="tijiaolunwenList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="tijiaolunwenList.do?page=${page.page+1 }">下一页</a>
			<a href="tijiaolunwenList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
