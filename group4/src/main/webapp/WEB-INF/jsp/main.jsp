<%--
  Created by IntelliJ IDEA.
  User: sunjiahe
  Date: 2020/9/22
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>后台大布局</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">会找房</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    <span id="username"></span>
                </a>
            </li>
            <li class="layui-nav-item"><a href="<%=basePath%>/user/logout">退出登录</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="<%=basePath%>/houseForAdmin" target="page">招租管理</a>
                    <%--<dl class="layui-nav-child">
                        <dd><a href="javascript:;">房源信息</a></dd>
                        <dd><a href="javascript:;">区域表</a></dd>
                        <dd><a href="javascript:;">地铁</a></dd>
                        <dd><a href="javascript:;">房源标签</a></dd>
                        <dd><a href="javascript:;">房屋标签</a></dd>
                        <dd><a href="javascript:;">房源配置</a></dd>
                        <dd><a href="javascript:;">房屋配置</a></dd>
                        <dd><a href="javascript:;">房屋图片</a></dd>
                    </dl>--%>
                </li>
                <li class="layui-nav-item">
                    <a href="<%=basePath%>/report" target = "page">举报管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="<%=basePath%>/repair" target = "page">报修管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="<%=basePath%>/question" target = "page">问题与咨询</a>
                </li>
                <li class="layui-nav-item">
                   <%-- <a href="javascript:;" target="page">角色管理</a>--%>
                    <dd><a href="<%=request.getContextPath()%>/user "target="page">用户管理</a></dd>
                    <dd><a href="<%=request.getContextPath()%>/role" target="page">角色管理</a></dd>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe src="<%=basePath%>/houseForAdmin" name="page" style="width: 100%;height: 100%;border: 0 none;vertical-align: middle" frameborder="1"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->

    </div>
</div>
<script>
    layui.use(['element','jquery'], function(){
        var element = layui.element
            ,$=layui.jquery;
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>/user/loginUser",
            async: false,
            success: function(msg){
                //console.log(msg);
                $("#username").html("管理员："+msg.userName+"  欢迎登录！");
            }
        });
    });
</script>
</body>
</html>
