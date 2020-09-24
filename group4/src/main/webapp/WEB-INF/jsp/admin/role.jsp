<%--
  Created by IntelliJ IDEA.
  User: sunjiahe
  Date: 2020/9/22
  Time: 16:23
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
    <title>角色管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
   <%-- <script src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>--%>
</head>
<body>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <!-- 添加按钮 -->
        <a class="layui-btn layui-btn-sm" id="add-role-btn" lay-event="add0">新增</a>
        <a class="layui-btn layui-btn-sm" id="detail-role-btn" lay-event="refresh">刷新</a>
        <!--a class="layui-btn layui-btn-sm" id="update-cus-btn" lay-event="update0">编辑客户</a>
        <a class="layui-btn layui-btn-sm" id="delete-cus-btn" data-type="getCheckData" lay-event="delete0">删除客户</a-->
    </div>
</script>

<br>

<!-- 角色表 -->
<table id="role-tbl" lay-filter="role-tbl"></table>
<script type="text/html" id="role-tbl-toolbar">
    <a class="layui-btn layui-btn-xs" lay-event="updateRole">编辑</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="deleteRole">删除</a>
</script>
<!-- 添加角色弹出层 -->
<div id="add-role-layer" style=" display: none; padding: 20px">
    <form id="add-role-form" class="layui-form layui-form-pane">
        <div class="layui-form-item">
            <label class="layui-form-label">角色名称</label>
            <div class="layui-input-block">
                <select name="roleName" lay-verify="required">
                    <option value="普通用户">普通用户</option>
                    <option value="管理员">管理员</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="add-role-form-submit">提交</button>
            </div>
        </div>
    </form>
</div>


<!-- 更新角色弹出层 -->
<div id="update-role-layer" style="display: none; padding: 20px">
    <form id="update-role-form" class="layui-form layui-form-pane" lay-filter="update-role-form">
        <div class="layui-form-item">
            <label class="layui-form-label">角色名称</label>
            <div class="layui-input-block">
                <select name="roleName" lay-verify="required">
                    <option value="普通用户">普通用户</option>
                    <option value="管理员">管理员</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="update-role-form-submit">提交</button>
            </div>
        </div>
    </form>
</div>

<script>
   layui.use(['jquery','table','layer','form'],function () {
       // 加载layui模块，使用其推荐的【预先加载】方式，详见官网【模块规范】一节
       var $ = layui.$;
       var table = layui.table;
       var layer = layui.layer;
       var form = layui.form;

      /* $.ajax({
           type: "POST",
           url: "<%=request.getContextPath()%>/findIdAndRoleName",
           success: function (msg) {
               // console.log(msg);
               $.each(msg, function (index, value) {
                   //console.log(value);
                   $("#select0").append(new Option(value.roleId, value.roleName));
               });
               form.render("select0");
           }
       });

       $.ajax({
           type: "POST",
           url: "<%=request.getContextPath()%>/findIdAndRoleName",
           success: function (msg) {
               // console.log(msg);
               $.each(msg, function (index, value) {
                   //console.log(value);
                   $("#select1").append(new Option(value.roleId, value.roleName));
               });
               form.render("select1");
           }
       });*/

       // 显示所有用户
       table.render({
           elem: '#role-tbl',
           url: '<%=request.getContextPath()%>/roleManager',
           page: true,
           cols: [[
               //{checkbox: true, fixed: true}
               {field: 'roleId', title: '角色ID', width: 100, sort: true}
               , {field: 'roleName', title: '角色名称', width: 177}
               , {fixed: 'right',toolbar: '#role-tbl-toolbar', title: '操作', width:150}
           ]]
           // 表格容器id，用于表格重载
           , id: 'testReload'
           , toolbar: '#toolbarDemo'
       });
/*
       //重载
       var $ = layui.$, active = {
           reload: function () {
               //var demoReload = $('#demoReload');

               //执行重载
               table.reload('testReload', {
                   page: {
                       curr: 1 //重新从第 1 页开始
                   }
                   ,url: "<%=request.getContextPath()%>/findRoleListById"
                   , where: {
                       roleId: $("#select0").val()
                   }
               });
           }
       };*/

       /*//监听下拉框
       form.on('select0(selectFilter0)', function (data) {
           active["reload"] ? active["reload"].call(this) : '';
       });

       //监听下拉框
       form.on('select1(selectFilter1)', function (data) {
           active["reload"] ? active["reload"].call(this) : '';
       });
*/

       //监听头工具栏事件 刷新
       table.on('toolbar(role-tbl)', function (obj) {

           // var checkStatus = table.checkStatus(obj.config.id);
           var data = obj.data;


           switch (obj.event) {
               case 'refresh':
                   //$(".layui-laypage-btn").click();
                   window.location.reload();
                   break;
               case 'add0':
                   // 每次显示前重置表单
                   $('#add-role-form')[0].reset();
                   // 显示更新客户表单的弹出层
                   layer.open({
                       type: 1,
                       title: '添加角色',
                       skin: 'layui-layer-molv',
                       area: ['500px'],
                       content: $('#add-role-layer')
                   });

                   // 添加角色表单提交
                   form.on('submit(add-role-form-submit)', function (data) {
                       /*var course={
                           "roleId":data.roleId,
                           "userName":data.field.userName,
                           "roleName":data.field.roleName
                       };*/
                       console.log(data.field);
                       // ajax方式添加用户
                       $.ajax({
                           url: '<%=request.getContextPath()%>/saveRole',
                           type: "POST",
                           data: JSON.stringify(data.field),
                           contentType: 'application/json',
                           dataType: 'json',
                           success: function (data) {
                               if (data.status == 1) {
                                   layer.close(layer.index);
                                   layer.msg('添加成功');
                                  // table.reload('role-tbl');
                                   window.location.reload();
                               } else {
                                   layer.msg('添加失败');
                               }
                           },
                           error: function () {
                               console.log("ajax error");
                           }
                       });
                       // 阻止表单跳转
                       return false;
                   });
                   break;
           }

           ;

       });


       ////////////////////////////////////////////////////////////////////////////////////////下
       // 监听行工具栏事件：删除用户与更新用户(包括备注，不需要修改)
       table.on('tool(role-tbl)', function (obj) {
           // 获取当前行数据和lay-event的值
           var data = obj.data;
           var event = obj.event;


           // 删除用户事件
           if (event === 'deleteRole') {
               layer.confirm('确定删除'+data.roleName+data.roleId + '吗？', function (index) {
                   // ajax方式删除用户
                   $.ajax({
                       url: '<%=request.getContextPath()%>/deleteRole/' + data.roleId,
                       type: "DELETE",
                       dataType: 'json',
                       success: function (data) {
                           if (data.status == 1) {
                               layer.msg('删除成功');
                               table.reload('role-tbl');
                           } else {
                               layer.msg('删除失败');
                           }
                           setTimeout(function () {
                               window.location.reload();
                           }, 1000);
                       },
                       error: function () {
                           console.log("ajax error");
                       }
                   });
                   layer.close(index);
               });
           }

           // 更新用户事件
           if (event === 'updateRole') {
               // 每次显示更新用户的表单前自动为表单填写该行的数据
               var roleId=data.roleId;
               form.val('update-role-form', {
                   "roleId": data.roleId,
                   "roleName": data.roleName,
               });
               // 显示更新客户表单的弹出层
               layer.open({
                   type: 1,
                   title: '更新客户',
                   skin: 'layui-layer-molv',
                   area: ['500px'],
                   content: $('#update-role-layer')
               });

               // 更新客户表单提交
               form.on('submit(update-role-form-submit)', function (data) {
                   var course={
                       "roleId":roleId,
                       "roleName":data.field.roleName
                   };
                   //console.log(data.field);
                   // ajax方式更新用户
                   $.ajax({
                       url: '<%=request.getContextPath()%>/updateRole',
                       type: "PUT",
                       data: JSON.stringify(course),
                       contentType: 'application/json',
                       dataType: 'json',
                       success: function (data) {
                           if (data.status == 1) {
                               layer.close(layer.index);
                               layer.msg('更新成功');
                               table.reload('role-tbl');
                           } else {
                               layer.msg('更新失败');
                           }
                           setTimeout(function () {
                               window.location.reload();
                           }, 1000);
                       },
                       error: function () {
                           console.log("ajax error");
                       }
                   });
                   // 阻止表单跳转
                   return false;
               });
           }
       });

   });


</script>


</body>
</html>
