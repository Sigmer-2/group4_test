<%--
  Created by IntelliJ IDEA.
  User: sunjiahe
  Date: 2020/9/23
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" media="all">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <!-- 添加按钮 -->
        <a class="layui-btn layui-btn-sm" id="add-user-btn" lay-event="add0">新增</a>
        <a class="layui-btn layui-btn-sm" id="detail-user-btn" lay-event="refresh">刷新</a>
    </div>
</script>

<br>
<!-- 用户表 -->
<table id="user-tbl" lay-filter="user-tbl"></table>
<script type="text/html" id="user-tbl-toolbar">
    <a class="layui-btn layui-btn-xs" lay-event="updateUser">编辑</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="deleteUser">删除</a>
</script>

<!-- 添加用户弹出层 -->
<div id="add-user-layer" style="display: none; padding: 20px">
    <form id="add-user-form" class="layui-form layui-form-pane">
            <div class="layui-form-item">
                <label class="layui-form-label">用户类型</label>
                <div class="layui-input-block">
                    <select id="select1" name="userRoleId" lay-verify="required" lay-filter="selectFilter1">
                        <option value=""></option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">联系方式</label>
                <div class="layui-input-block">
                    <input type="text" name="userTel" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户头像</label>
                <div class="layui-input-block">
                    <input type="text" name="userImg" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户昵称</label>
                <div class="layui-input-block">
                    <input type="text" name="userName" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">所在城市</label>
                <div class="layui-input-block">
                    <input type="text" name="userPlace" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户性别</label>
                <div class="layui-input-block">
                    <input type="text" name="userSex" class="layui-input" autocomplete="on">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="text" name="userPassword" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密匙</label>
                <div class="layui-input-block">
                    <input type="text" name="sessionKey" class="layui-input" autocomplete="on">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">唯一id</label>
                <div class="layui-input-block">
                    <input type="text" name="openId" class="layui-input" autocomplete="on">
                </div>
            </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="add-user-form-submit">提交</button>
            </div>
        </div>
    </form>
</div>


<!-- 更新用户弹出层 -->
<div id="update-user-layer" style="display: none; padding: 20px">
    <form id="update-user-form" class="layui-form layui-form-pane" lay-filter="update-user-form">
            <div class="layui-form-item">
                <label class="layui-form-label">用户类型</label>
                <div class="layui-input-block">
                    <select id="select2" name="userRoleId" lay-verify="required" lay-filter="selectFilter2">
                        <option value=""></option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                 <label class="layui-form-label">联系方式</label>
                 <div class="layui-input-block">
                      <input type="text" name="userTel" class="layui-input" autocomplete="on">
                  </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户头像</label>
                <div class="layui-input-block">
                    <input type="text" name="userImg" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户昵称</label>
                <div class="layui-input-block">
                    <input type="text" name="userName" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">所在城市</label>
                <div class="layui-input-block">
                    <input type="text" name="userPlace" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户性别</label>
                <div class="layui-input-block">
                    <input type="text" name="userSex" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="text" name="userPassword" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密匙</label>
                <div class="layui-input-block">
                    <input type="text" name="sessionKey" class="layui-input" autocomplete="on">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">唯一id</label>
                <div class="layui-input-block">
                    <input type="text" name="openId" class="layui-input" autocomplete="on">
                </div>
            </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="update-user-form-submit">提交</button>
            </div>
        </div>
    </form>
</div>
<script type="text/html" id="roleName">
{{d.role.roleName}}
</script>
<script>
    layui.use(['jquery','table','layer','form'],function () {
        // 加载layui模块，使用其推荐的【预先加载】方式，详见官网【模块规范】一节
        var $ = layui.$;
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;

        $.ajax({
            type: "GET",
            url: "<%=request.getContextPath()%>/findRoleIdAndName",
            success: function (msg) {
                 console.log(msg);
                $.each(msg, function (index, value) {
                    //console.log(value);
                    $("#select1").append(new Option(value.roleName,value.roleId));
                });
                form.render("select1");
            }
        });

        $.ajax({
            type: "GET",
            url: "<%=request.getContextPath()%>/findRoleIdAndName",
            success: function (msg) {
                // console.log(msg);
                $.each(msg, function (index, value) {
                    //console.log(value);
                    $("#select2").append(new Option(value.roleName,value.roleId));
                    //var iid=value.roleId;
                });
                form.render("select2");
            }
        });

        // 显示所有用户
        table.render({
            elem: '#user-tbl',
            url: '<%=request.getContextPath()%>/userManager',
            page: true,
            cols: [[
                //{checkbox: true, fixed: true}
                {field: 'userId', title: '用户id', width: 100, sort: true}
                , {field: 'userRoleId', title: '用户类型', width: 110,templet:$("#roleName")}//,templet:$("#roleName")
                , {field: 'userTel', title: '联系方式', width: 177}
                , {field: 'userImg', title: '用户头像', width: 177}
                , {field: 'userName', title: '用户昵称', width: 100}
                , {field: 'userPlace', title: '所在城市', width: 100}
                , {field: 'userSex', title: '用户性别', width: 100}
                , {field: 'userPassword', title: '密码', width: 177}
                , {field: 'sessionKey', title: '密匙', width: 177}
                , {field: 'openId', title: '唯一id', width: 177}
                , {fixed: 'right',toolbar: '#user-tbl-toolbar', title: '操作', width:150}
            ]]
            // 表格容器id，用于表格重载
            , id: 'testReload'
            , toolbar: '#toolbarDemo'
        });

        /*//重载
        var $ = layui.$, active = {
            reload: function () {
                //var demoReload = $('#demoReload');

                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,url: "<%=request.getContextPath()%>/findUserListById"
                    , where: {
                        userId: $("#select").val()
                    }
                });
            }
        };*/

       /* //监听下拉框
        form.on('select(selectFilter)', function (data) {
            active["reload"] ? active["reload"].call(this) : '';
        });*/


        //监听下拉框
        form.on('select1(selectFilter1)', function (data) {
            active["reload"] ? active["reload"].call(this) : '';
        });

        //监听下拉框
        form.on('select2(selectFilter2)', function (data) {
            active["reload"] ? active["reload"].call(this) : '';
        });


        //监听头工具栏事件 刷新
        table.on('toolbar(user-tbl)', function (obj) {

            // var checkStatus = table.checkStatus(obj.config.id);
            var data = obj.data;

            switch (obj.event) {
                case 'refresh':
                    //$(".layui-laypage-btn").click();
                    window.location.reload();
                    break;
                case 'add0':
                    // 每次显示前重置表单
                    $('#add-user-form')[0].reset();
                    // 显示更新客户表单的弹出层
                    layer.open({
                        type: 1,
                        title: '添加用户',
                        skin: 'layui-layer-molv',
                        area: ['500px'],
                        content: $('#add-user-layer')
                    });

                    // 添加用户表单提交
                    form.on('submit(add-user-form-submit)', function (data) {
                        /*var course={
                            "roleId":data.roleId,
                            "userName":data.field.userName,
                            "roleName":data.field.roleName
                        };*/
                        console.log(data.field);//
                        // ajax方式添加用户
                        $.ajax({
                            url: '<%=request.getContextPath()%>/saveUser',
                            type: "POST",
                            data: JSON.stringify(data.field),
                            contentType: 'application/json',
                            dataType: 'json',
                            success: function (data) {
                                if (data.status == 1) {
                                    layer.close(layer.index);
                                    layer.msg('添加成功');
                                    //table.reload('user-tbl');
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
        table.on('tool(user-tbl)', function (obj) {
            // 获取当前行数据和lay-event的值
            var data = obj.data;
            var event = obj.event;


            // 删除用户事件
            if (event === 'deleteUser') {
                layer.confirm('确定删除用户'+data.userName + '吗？', function (index) {
                    // ajax方式删除用户
                    $.ajax({
                        url: '<%=request.getContextPath()%>/' + data.userId,
                        type: "DELETE",
                        dataType: 'json',
                        success: function (data) {
                            if (data.status == 1) {
                                layer.msg('删除成功');
                                table.reload('user-tbl');
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
            if (event === 'updateUser') {
                // 每次显示更新用户的表单前自动为表单填写该行的数据
                var userId=data.userId;
                //var userRoleId=data.roleId
                form.val('update-user-form', {
                    "userId": userId,
                    "userRoleId": data.userRoleId,
                    //"userRoleId":data.roleId,
                    "userTel": data.userTel,
                    "userImg": data.userImg,
                    "userName": data.userName,
                    "userPlace": data.userPlace,
                    "userSex": data.userSex,
                    "userPassword": data.userPassword,
                    "sessionKey": data.sessionKey,
                    "openId": data.openId,
                });
                // 显示更新客户表单的弹出层
                layer.open({
                    type: 1,
                    title: '更新客户',
                    skin: 'layui-layer-molv',
                    area: ['500px'],
                    content: $('#update-user-layer')
                });

                // 更新客户表单提交
                form.on('submit(update-user-form-submit)', function (data) {
                    var course={
                        "userId":userId,
                        "userRoleId":data.field.userRoleId,
                        //"userRoleId":data.field.roleId,
                        "userTel":data.field.userTel,
                        "userImg":data.field.userImg,
                        "userName":data.field.userName,
                        "userPlace":data.field.userPlace,
                        "userSex":data.field.userSex,
                        "userPassword":data.field.userPassword,
                        "sessionKey":data.field.sessionKey,
                        "openId":data.field.openId
                    };
                    console.log(course);//打印更新的用户信息
                    // ajax方式更新用户
                    $.ajax({
                        url: '<%=request.getContextPath()%>/',
                        type: "PUT",
                        data: JSON.stringify(course),
                        contentType: 'application/json',
                        dataType: 'json',
                        success: function (data) {
                            if (data.status == 1) {
                                layer.close(layer.index);
                                layer.msg('更新成功');
                                table.reload('user-tbl');
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
