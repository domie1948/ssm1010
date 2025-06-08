<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>后台左侧导航</title>
<link rel="stylesheet" type="text/css" href="images/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><head></head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box"><a href="sy.jsp" target="main"><div class="line"><img src="images/coin01.png" />&nbsp;&nbsp;首页</div></a>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin03.png" /><img class="icon2" src="images/coin04.png" /> 个人资料管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a class="cks" href="doUpdateJiaoshixinxi2.do" target="main">个人资料管理</a><img class="icon5" src="images/coin21.png" />
				</dd>
				
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin01.png" /><img class="icon2" src="images/coin02.png" /> 公告信息查询<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a class="cks" href="gonggaoxinxiList2.do" target="main">公告信息查询</a><img class="icon5" src="images/coin21.png" />
				</dd>
				
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin07.png" /><img class="icon2" src="images/coin08.png" /> 通知信息查询<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a class="cks" href="tongzhiList3.do" target="main">通知信息查询</a><img class="icon5" src="images/coin21.png" />
				</dd>
				
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin10.png" /><img class="icon2" src="images/coin09.png" /> 学生选择管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a class="cks" href="xuanzedaoshiList3.do" target="main">学生选择管理</a><img class="icon5" src="images/coin21.png" />
				</dd>
				
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin11.png" /><img class="icon2" src="images/coin12.png" /> 开题报告管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a class="cks" href="kaitixinxiList3.do" target="main">开题报告管理</a><img class="icon5" src="images/coin21.png" />
				</dd>
				
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin14.png" /><img class="icon2" src="images/coin13.png" /> 学生论文管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a class="cks" href="tijiaolunwenList3.do" target="main">学生论文管理</a><img class="icon5" src="images/coin21.png" />
				</dd>
				
			</dl>
			
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coin14.png" /><img class="icon2" src="images/coin13.png" /> 通知查询<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a class="cks" href="tongzhiList3.do" target="main">通知查询</a><img class="icon5" src="images/coin21.png" />
				</dd>
				
			</dl>
			
			
			
		
			<dl class="system_log">
				<dt>
					<img class="icon1" src="images/coinL1.png" /><img class="icon2" src="images/coinL2.png" /> 系统管理<img class="icon3" src="images/coin19.png" /><img class="icon4" src="images/coin20.png" />
				</dt>
			
				<dd>
					<img class="coin11" src="images/coin111.png" /><img class="coin22" src="images/coin222.png" /><a class="cks" href="logout.jsp" target="_blank">退出</a><img class="icon5" src="images/coin21.png" />
				</dd>
			</dl>

		</div>

	</div>
</body>
</html>
