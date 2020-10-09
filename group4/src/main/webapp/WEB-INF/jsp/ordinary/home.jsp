<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>会找房后台系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../../layui/css/layui.css" media="all">
    <style type="text/css">
        .uploader-list {
            margin-left: -15px;
        }

        .uploader-list .info {
            position: relative;
            margin-top: -25px;
            background-color: black;
            color: white;
            filter: alpha(Opacity=80);
            -moz-opacity: 0.5;
            opacity: 0.5;
            width: 100px;
            height: 25px;
            text-align: center;
            display: none;
        }

        .uploader-list .handle {
            position: relative;
            background-color: black;
            color: white;
            filter: alpha(Opacity=80);
            -moz-opacity: 0.5;
            opacity: 0.5;
            width: 100px;
            text-align: right;
            height: 18px;
            margin-bottom: -18px;
            display: none;
        }

        .uploader-list .handle span {
            margin-right: 5px;
        }

        .uploader-list .handle span:hover {
            cursor: pointer;
        }

        .uploader-list .file-iteme {
            margin: 12px 0 0 15px;
            padding: 1px;
            float: left;
        }
    </style>

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
        <script type="text/html" id="barDemo">
            <a id="house-img" class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">上传房间照片</a>
        </script>
        <div style="display:none;" id="houseToolBar" class="layui-inline">
            <button type="button" class="layui-btn layui-btn-sm" id="add-house-btn"  lay-event="add">增加</button>
            <button type="button" class="layui-btn layui-btn-sm " id="update-house-btn" lay-event="update">编辑</button>
            <button type="button" class="layui-btn layui-btn-sm"  id="delete-house-btn" lay-event="delete">删除</button>
        </div>

        <%--        增加招租信息弹出层--%>
        <div id="add-house-layer" style="display: none; padding: 20px;width: 400px">
            <form id="add-house-form" class="layui-form layui-form-pane" >
                <div class="layui-form-item" style="height: 20px;display: none" >
                    <label class="layui-form-label">房源编号</label>
                    <div class="layui-input-block">
                        <input type="text" name="id" class="layui-input" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px" >
                    <label class="layui-form-label">房源类型</label>
                    <div class="layui-input-block">
                        <select name="houseType" lay-filter="houseType">
                            <option value="房东直租" selected="">房东直租</option>
                            <option value="有房转租" >有房转租</option>
                            <option value="有房找室友">有房找室友</option>
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
                            <option value="整租" selected="">整租</option>
                            <option value="合租" >合租</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">房间类型</label>
                    <div class="layui-input-block">
                        <select name="roomType" lay-filter="roomType">
                            <option value=""></option>
                            <option value="主卧" selected="">主卧</option>
                            <option value="次卧" >次卧</option>
                            <option value="隔间">隔间</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" style="height: 20px;margin-top: 30px" >
                    <label class="layui-form-label">月租金</label>
                    <div class="layui-input-block">
                        <input type="text" name="rent" class="layui-input" lay-verify="required" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item" style="margin-top: 30px">
                    <label class="layui-form-label">房屋标签</label>
                    <div class="layui-input-block">
                        <input type="checkbox" name="houseLabel" title="可短租" value="可短租" >
                        <input type="checkbox" name="houseLabel" title="月付" value="月付"  >
                        <input type="checkbox" name="houseLabel" title="南向" value="南向"  >
                        <input type="checkbox" name="houseLabel" title="无中介费" value="无中介费"  >
                        <input type="checkbox" name="houseLabel" title="独卫" value="独卫" >
                        <input type="checkbox" name="houseLabel" title="独立阳台" value="独立阳台"  >
                        <input type="checkbox" name="houseLabel" title="电梯房" value="电梯房"  >
                        <input type="checkbox" name="houseLabel" title="带飘窗" value="带飘窗"  >
                        <input type="checkbox" name="houseLabel" title="精装修" value="精装修"  >
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房屋配置</label>
                    <div class="layui-input-block">
                        <input type="checkbox" name="houseDeploy" title="床" value="床" >
                        <input type="checkbox" name="houseDeploy" title="WIFI" value="WIFI"  >
                        <input type="checkbox" name="houseDeploy" title="空调" value="空调"  >
                        <input type="checkbox" name="houseDeploy" title="衣柜" value="衣柜"  >
                        <input type="checkbox" name="houseDeploy" title="书桌" value="书桌" >
                        <input type="checkbox" name="houseDeploy" title="椅子" value="椅子"  >
                        <input type="checkbox" name="houseDeploy" title="沙发" value="沙发"  >
                        <input type="checkbox" name="houseDeploy" title="冰箱" value="冰箱"  >
                        <input type="checkbox" name="houseDeploy" title="洗衣机" value="洗衣机"  >
                        <input type="checkbox" name="houseDeploy" title="电视机" value="电视机" >
                        <input type="checkbox" name="houseDeploy" title="热水器" value="热水器"  >
                        <input type="checkbox" name="houseDeploy" title="燃气灶" value="燃气灶"  >
                        <input type="checkbox" name="houseDeploy" title="微波炉" value="微波炉"  >
                        <input type="checkbox" name="houseDeploy" title="油烟机" value="油烟机" >
                        <input type="checkbox" name="houseDeploy" title="餐桌椅" value="餐桌椅"  >
                        <input type="checkbox" name="houseDeploy" title="智能锁" value="智能锁"  >
                        <input type="checkbox" name="houseDeploy" title="台灯" value="台灯"  >
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
                <div class="layui-form-item" style="height: 20px;display: none" >
                    <label class="layui-form-label">房源编号</label>
                    <div class="layui-input-block">
                        <input type="text" name="id" class="layui-input" autocomplete="off">
                    </div>
                </div>
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
                        <button class="layui-btn" lay-submit lay-filter="update-house-form-submit">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>


        <%--照片--%>
        <div id="update-house-img" style="display: none;padding: 20px">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend>房间照片</legend>
            </fieldset>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test1">选择图片</button>
                <button type="button" style="display:none;" class="layui-btn" id="send1">上传</button>
                <button type="button"  class="layui-btn" id="send11">上传</button>
                <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;width: 88%">
                    预览图：
                    <div class="layui-upload-list uploader-list" style="overflow: auto;" id="demo1"></div>
                </blockquote>
            </div>
        </div>
    </div>

</div>
<script src="../../../layui/layui.js"></script>
<script>
    layui.use(['jquery', 'table', 'layer', 'form','element', 'util','laydate','upload'], function(){
        var $ = layui.$;
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        var element = layui.element;
        var util = layui.util;
        upload = layui.upload;
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
                ,{field: 'id', title: '房源编号', width:100}
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
                ,{fixed: 'right', width: 85, align:'center', toolbar: '#barDemo'}
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
                shade:0//遮罩透明度
            });
            // 添加招租信息表单提交
            form.on('submit(add-house-form-submit)', function(data) {
                // ajax方式添加
                $.ajax({
                    url: 'house/add',//添加接口
                    type: "POST",
                    data: $('#add-house-form').serialize(),
                    // data: JSON.stringify(data.field),
                    // contentType: 'application/json',
                    dataType: 'json',
                    success: function(data) {
                        if (data.status == 1) {
                            layer.close(layer.index);
                            layer.msg('添加成功');
                            table.reload('demo');
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
                arr.push(data.id);
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
                    console.log(arr);
                    // ajax方式删除
                    $.ajax({
                        type: 'POST',
                        // contentType: "application/json;charset=UTF-8",
                        url: 'house/delete',//删除接口
                        // data: JSON.stringify(arr),
                        data: {ids:arr},
                        traditional: true,//传数组一定要加的
                        dataType: 'json',
                        success: function (data) {
                            if (data.status == 1) {
                                layer.close(layer.index);
                                layer.msg('删除成功');
                                table.reload('demo');
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
                        "id":data[0].id,
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
                    url: '/house/edit',//编辑接口
                    type: "POST",
                    data: $('#update-house-form').serialize(),
                    // data: JSON.stringify(data.field),
                    // contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        if (data.status == 1) {
                            layer.close(layer.index);
                            layer.msg('更新成功');
                            table.reload('demo');
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

        //监听工具条
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                console.log(data.id);
                //房间照片
                layer.open({
                    type: 1,
                    title: '更新房间照片信息',
                    skin: 'layui-layer-molv',
                    area: ['500px','80%'],
                    content: $('#update-house-img'),
                    shade:0,
                });
            }
            //上传前的询问框
            $("#send11").click(function(){
                //获取子元素，如果为0则还未选择图片
                var a =  $("#demo1").children("div").length;
                if (a==0) {
                    layer.msg("请选择图片")
                } else {
                    var buy = document.getElementById('send1');
                    layer.confirm('确定上传图片吗，上传之后无法修改？', {icon: 3, title:'提示'}, function(index){
                        buy.click();
                    })
                }

            })
            upload.render({
                elem: '#test1'
                ,url:  "/house/upload?houseId="+data.id
                ,multiple: true
                ,auto:false
                ,bindAction:"#send1"
                ,size: 10*1024
                , choose: function (obj) {
                    files = obj.pushFile();
                    obj.preview(function(index, file, result){
                        $('#demo1').append(
                            '<div id="" class="file-iteme">' +
                            //	  		            '<div class="handle"><span value="'+res.data.sel+'" class="glyphicon glyphicon-trash">X</span></div>' +
                            '<div class="handle"><span class="glyphicon glyphicon-trash">X</span></div>' +
                            '<img src="'+ result +'" alt="'+ file.name +'"  width="100" height="100" class="layui-upload-img">' +
                            //	  		            '<img src="'+ res.data.addImgs +'" width="100" height="100"  class="layui-upload-img">' +
                            '<div class="info">' + file.name + '</div>' +
                            '</div>'
                        );
                        $(".file-iteme .handle").click(function () {
                            delete files[index]; //删除对应的文件
                            $(this).parent().remove();
                        })
                    });
                }
                ,done: function(res,index,upload){
                    //上传完毕
                    if(res.code === 0){
                        layer.msg("上传成功")
                        $("#demo1").load(location.href + " #demo1")

                        //从文件队列中删除图片
                        delete files[index];
                        //删除图片右上角的 X 上传成功后不能再删除当前图片
                        $(".glyphicon-trash").parent().remove();
                    }else{
                        layer.msg("上传失败，再重新选择一遍吧！")
                    }
                }
                ,errror:function(){
                    layer.msg("好像出问题了，刷新一下试试吧！")
                }
            });
        });

        //多图片上传
        /*upload.render({
            elem: '#test2'
            ,url: '/house/upload' //改成您自己的上传接口
            ,multiple: true
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
                });
            }
            ,done: function(res){
                if(res.status==1){
                    layer.msg('上传成功');
                }
                //上传完毕
            }
            ,error: function(){
                //请求异常回调
            }
        });*/




    });
</script>

</body>
</html>