<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>会找房后台系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../../layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">会找房</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" >
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">我的招租</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="top: 50px">
        <!-- 内容主体区域 -->
        <table id="demo" lay-filter="test"></table>
        <div style="display:none;" id="houseToolBar" class="layui-inline">
            <button type="button" class="layui-btn layui-btn-sm" id="add-house-btn"  lay-event="add">增加</button>
            <button type="button" class="layui-btn layui-btn-sm " id="update-house-btn" lay-event="update">编辑</button>
            <button type="button" class="layui-btn layui-btn-sm"  id="delete-house-btn" lay-event="delete">删除</button>
                搜索关键字：
                <div class="layui-inline">
                    <input class="layui-input" name="id" id="find" autocomplete="off" placeholder="请输入...">
                </div>
                <button class="layui-btn layui-btn-sm" data-type="reload" id="queryArea">搜索</button>
        </div>

<%--        增加招租信息弹出层--%>
        <div id="add-house-layer" style="display: none; padding: 20px;width: 400px">
            <form id="add-house-form" class="layui-form layui-form-pane" >
                <div class="layui-form-item" style="height: 20px;display: none" >
                    <label class="layui-form-label">房源编号</label>
                    <div class="layui-input-block">
                        <input type="text" name="houseId" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px" >
                    <label class="layui-form-label">房源类型</label>
                    <div class="layui-input-block">
                        <select name="houseType" lay-filter="houseType">
                            <option value="0" selected="">房东直租</option>
                            <option value="1" >有房转租</option>
                            <option value="2">有房找室友</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">地区位置</label>
                    <div class="layui-input-block">
                        <input type="text" name="area" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">地铁位置</label>
                    <div class="layui-input-block">
                        <input type="text" name="metro" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">小区名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="estate" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">整套户型</label>
                    <div class="layui-input-block">
                        <input type="text" name="listingsType" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">出租方式</label>
                    <div class="layui-input-block">
                        <select name="rentalMode" lay-filter="rentalMode">
                            <option value=""></option>
                            <option value="0" selected="">整租</option>
                            <option value="1" >合租</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">房间类型</label>
                    <div class="layui-input-block">
                        <select name="roomType" lay-filter="roomType">
                            <option value=""></option>
                            <option value="0" selected="">主卧</option>
                            <option value="1" >次卧</option>
                            <option value="2">隔间</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">月租金</label>
                    <div class="layui-input-block">
                        <input type="text" name="rent" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">房屋标签</label>
                    <div class="layui-input-block">
                            <input type="checkbox" name="houseLable" title="可短租" value="1" >
                            <input type="checkbox" name="houseLable" title="月付" value="2"  >
                            <input type="checkbox" name="houseLable" title="南向" value="3"  >
                            <input type="checkbox" name="houseLable" title="无中介费" value="4"  >
                            <input type="checkbox" name="houseLable" title="独卫" value="5" >
                            <input type="checkbox" name="houseLable" title="独立阳台" value="6"  >
                            <input type="checkbox" name="houseLable" title="电梯房" value="7"  >
                            <input type="checkbox" name="houseLable" title="带飘窗" value="8"  >
                            <input type="checkbox" name="houseLable" title="精装修" value="9"  >
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房屋配置</label>
                    <div class="layui-input-block">
                           <input type="checkbox" name="houseDeploy" title="床" value="1" >
                           <input type="checkbox" name="houseDeploy" title="WIFI" value="2"  >
                           <input type="checkbox" name="houseDeploy" title="空调" value="3"  >
                           <input type="checkbox" name="houseDeploy" title="衣柜" value="4"  >
                           <input type="checkbox" name="houseDeploy" title="书桌" value="5" >
                           <input type="checkbox" name="houseDeploy" title="椅子" value="6"  >
                           <input type="checkbox" name="houseDeploy" title="沙发" value="7"  >
                           <input type="checkbox" name="houseDeploy" title="冰箱" value="8"  >
                           <input type="checkbox" name="houseDeploy" title="洗衣机" value="9"  >
                           <input type="checkbox" name="houseDeploy" title="电视机" value="10" >
                           <input type="checkbox" name="houseDeploy" title="热水器" value="11"  >
                           <input type="checkbox" name="houseDeploy" title="燃气灶" value="12"  >
                           <input type="checkbox" name="houseDeploy" title="微波炉" value="13"  >
                           <input type="checkbox" name="houseDeploy" title="油烟机" value="14" >
                           <input type="checkbox" name="houseDeploy" title="餐桌椅" value="15"  >
                           <input type="checkbox" name="houseDeploy" title="智能锁" value="16"  >
                           <input type="checkbox" name="houseDeploy" title="台灯" value="17"  >
                    </div>
                </div>
                <div class="layui-form-item layui-form-text" style="margin-top: 30px">
                    <label class="layui-form-label">房屋介绍</label>
                    <div class="layui-input-block">
                        <textarea placeholder="为提高您的转租速度，请描述房源核心优势" name="houseIntroduction" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px" >
                    <label class="layui-form-label">可入住时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="checkinTime" id="checkinTime1" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">租客性别</label>
                    <div class="layui-input-block">
                        <select name="sex" lay-filter="sex">
                            <option value="0" selected="">男女均可</option>
                            <option value="1" >限男生</option>
                            <option value="2">限女生</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">您的称呼</label>
                    <div class="layui-input-block">
                        <input type="text" name="call" class="layui-input" lay-verify="required" autocomplete="off" placeholder="如何称呼您?例：刘女士">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">联系方式</label>
                    <div class="layui-input-block">
                        <input type="text" name="tel" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block"style="margin-top: 30px">
                        <button class="layui-btn" lay-submit lay-filter="add-house-form-submit">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
        <!-- 更新招租信息弹出层 -->
        <div id="update-house-layer" style="display: none;padding: 20px">
            <form id="update-house-form" class="layui-form layui-form-pane" lay-filter="update-house-form">
                <div class="layui-form-item" style="height: 20px" >
                    <label class="layui-form-label">房源类型</label>
                    <div class="layui-input-block">
                        <input type="text" name="houseType" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;;margin-top: 30px" >
                    <label class="layui-form-label">地区位置</label>
                    <div class="layui-input-block">
                        <input type="text" name="area" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">地铁位置</label>
                    <div class="layui-input-block">
                        <input type="text" name="metro" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">整套户型</label>
                    <div class="layui-input-block">
                        <input type="text" name="listingsType" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">出租方式</label>
                    <div class="layui-input-block">
                        <input type="text" name="rentalMode" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">房间类型</label>
                    <div class="layui-input-block">
                        <input type="text" name="roomType" class="layui-input" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">月租金</label>
                    <div class="layui-input-block">
                        <input type="text" name="rent" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">房屋标签</label>
                    <div class="layui-input-block">
                        <input type="text" name="houseLabel" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">房屋配置</label>
                    <div class="layui-input-block">
                        <input type="text" name="houseDeploy" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">房屋介绍</label>
                    <div class="layui-input-block">
                        <input type="text" name="houseIntroduction" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">可入住时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="checkinTime" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">租客性别</label>
                    <div class="layui-input-block">
                        <input type="text" name="sex" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">您的称呼</label>
                    <div class="layui-input-block">
                        <input type="text" name="call" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">联系方式</label>
                    <div class="layui-input-block">
                        <input type="text" name="tel" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block"style="margin-top: 30px">
                        <button class="layui-btn" lay-submit lay-filter="add-house-form-submit">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
<script src="../../../layui/layui.js"></script>
<!-- 引入插件 -->
<script src="../../../dist/xm-select.js" type="text/javascript" charset="utf-8"></script>
<script>
    layui.use(['jquery', 'table', 'layer', 'form','element', 'util','laydate'], function(){
        var $ = layui.$;
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        var element = layui.element;
        var util = layui.util;
        var laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#checkinTime'
            ,trigger: 'click'
        });
        laydate.render({
            elem: '#checkinTime1'
            ,trigger: 'click'
        });

        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,height: 500
            ,url: '/house/list' //数据接口
            ,title: '我的招租表'
            ,page: true //开启分页
            ,toolbar:'#houseToolBar'//开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,defaultToolbar: []
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'houseId', title: '房源编号', width:200}
                ,{field: 'houseType', title: '房源类型', width:200}
                ,{field: 'area', title: '区域位置', width:200}
                ,{field: 'metro', title: '地铁位置', width:200}
                ,{field: 'estate', title: '小区名称', width:100}
                ,{field: 'listingsType', title: '整套户型', width:100}
                ,{field: 'rentalMode', title: '出租方式', width: 100}
                ,{field: 'roomType', title: '房间类型', width: 100}
                ,{field: 'rent', title: '月租金', width:100}
                ,{field: 'houseLabel', title: '房屋标签', width:150}
                ,{field: 'houseDeploy', title: '房屋配置', width:100}
                ,{field: 'houseIntroduction', title: '房屋介绍', width: 300}
                ,{field: 'checkinTime', title: '可入住时间', width:200}
                ,{field: 'sex', title: '租客性别', width: 100}
                ,{field: 'call', title: '您的称呼', width:150}
                ,{field: 'tel', title: '联系方式', width: 200}
            ]],
            // 表格容器id，用于表格重载
            id: 'demo',
        });

        // 显示添加客户弹出层
        $('#add-house-btn').click(function() {
            layer.open({
                type: 1,
                title: '添加招租信息',
                area: ['450px','80%'],
                skin:'layui-layer-molv',
                content: $('#add-house-layer'),
                shade:0
            });
            // 添加招租信息表单提交
            form.on('submit(add-house-form-submit)', function(data) {
                // ajax方式添加
                $.ajax({
                    url: 'house/add',//添加接口
                    type: "POST",
                    data: JSON.stringify(data.field),
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function(data) {
                        if (data.status == 1) {
                            layer.close(layer.index);
                            layer.msg('添加成功');
                            table.reload('house-tbl');
                        } else {
                            layer.msg('添加失败');
                        }
                    },
                    error: function() {
                        console.log("ajax error");
                    }
                });
                // 阻止表单跳转
                return false;
            });
        });
        //显示删除客户弹出层
        $('#delete-house-btn').click(function() {
            var checkStatus = table.checkStatus('demo');
            var data = checkStatus.data;
            var arr = [];
            data.forEach(function (data) {
                arr.push(data.houseId);
            })
            var long = data.length;
            if(long===0){
                layer.msg('请选中你准备删除的招租房源');
                return false;
            }
            layer.open({
                title: '删除招租信息',
                skin: 'layui-layer-molv',
                content: '确定删除选中的招租信息么？',
                btn: ['确定','取消'],
                yes: function (index) {
                    layer.close(index);
                    // ajax方式删除
                    $.ajax({
                        type: 'POST',
                        contentType: "application/json;charset=UTF-8",
                        url: '/delete',//删除接口
                        data: JSON.stringify(arr),
                        dataType: 'json',
                        success: function (data) {
                            if (data.status == 1) {
                                layer.close(layer.index);
                                layer.msg('删除成功');
                                table.reload('house-tbl');
                            } else {
                                layer.msg('删除失败');
                            }
                        },
                    });
                }
            });
        });

        //显示编辑招租信息弹出层
        $('#update-house-btn').click(function() {
            var checkStatus = table.checkStatus('demo');
            var data = checkStatus.data;
            var long = data.length;
            if(long>1){
                layer.msg('只能选择一条信息编辑');
                return false;
            }
            if(long===0){
                layer.msg('必须选择一条信息才能编辑');
                return false;
            }

            // 显示更新招租信息表单的弹出层
            layer.open({
                type: 1,
                title: '更新招租信息',
                skin: 'layui-layer-molv',
                area: ['500px','80%'],
                content: $('#update-house-layer'),
                shade:0,
                success:function (){
                    form.val('update-house-form', {
                        "houseType":data[0].houseType,
                        "area": data[0].area,
                        "metro":data[0].metro,
                        "listingsType":data[0].listingsType,
                        "rentalMode":data[0].rentalMode,
                        "roomType":data[0].roomType,
                        "rent":data[0].rent,
                        "houseImg":data[0].houseImg,
                        "houseLabel":data[0].houseLabel,
                        "houseDeploy":data[0].houseDeploy,
                        "houseIntroduction":data[0].houseIntroduction,
                        "checkinTime":data[0].checkinTime,
                        "sex":data[0].sex,
                        "call":data[0].call,
                        "tel":data[0].tel
                    });
                }
            });
            // 编辑招租信息表单提交
            form.on('submit(update-house-form-submit)', function(data) {
                $.ajax({
                    url: '/update',//编辑接口
                    type: "PUT",
                    data: JSON.stringify(data.field),
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        if (data.status == 1) {
                            layer.close(layer.index);
                            layer.msg('更新成功');
                            table.reload('house-tbl');
                        } else {
                            layer.msg('更新失败');
                        }
                    },
                    error: function () {
                        console.log("ajax error");
                    }
                });
                // 阻止表单跳转
                return false;
            });
        });
    });
    var demo1 = xmSelect.render({
        // 这里绑定css选择器
        el: '#demo1',
        // 渲染的数据
        data: [
            {name: '水果', value: 1, selected: true, disabled: true},
            {name: '蔬菜', value: 2, selected: true},
            {name: '桌子', value: 3, disabled: true},
            {name: '北京', value: 4},
        ],
    })

</script>

</body>
</html>
