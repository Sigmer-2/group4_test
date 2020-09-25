<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>管理员-招租管理</title>
    <link rel="stylesheet" href="<%=basePath%>/layui/css/layui.css" media="all" >
    <script src="<%=basePath%>/layui/layui.js"></script>
    <script src="<%=basePath%>/js/jquery-3.4.1.js"></script>
    <style>
        body{margin: 10px;}
        .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
        #formSelect{
            width:250px;display: inline-block;
        }
        #dr{display: inline-block;}



    </style>
</head>
<body>


<form class="layui-form" action="" id="formSelect" >
    <div class="layui-form-item">
        <label class="layui-form-label" >查询方式:</label>
        <div class="layui-input-block" >
            <select name="city" lay-verify="required" lay-filter="selectfilter">
                <option value="0">订单编号</option>
                <option value="1">客户名称</option>
                <option value="2">产品名称</option>
            </select>
        </div>
    </div>
</form>
<div class="demoTable " id="dr" style="text-align:left">

    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off" placeholder="请输入查询内容">
    </div>
    <button id="reloadbutton" class="layui-btn" data-type="reload">查询</button>
</div>


<table class="layui-hide" id="demo" lay-filter="test"></table>



<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button type="button" class="layui-btn layui-btn-sm" lay-event="getInsert">
            <i class="layui-icon ">&#xe608;</i> 添加
        </button>
        <button type="button" class="layui-btn layui-btn-sm  layui-btn-danger" lay-event="getDelete">
            <i class="layui-icon">&#x1006;</i> 删除
        </button>
        <button type="button" class="layui-btn layui-btn-sm" lay-event="getRefresh">
            <i class="layui-icon">&#xe9aa;</i> 刷新
        </button>
    </div>
</script>
<script type="text/html" id="titleTpl1">


    <a href='javascript:;' class=" layui-btn layui-btn-primary layui-btn-xs" onclick="regionClick('{{d.regionId}}');">{{d.region.distrctName}}<b>·</b>{{d.region.street}}</a>
</script>
<script type="text/html" id="titleTpl2">


    <a href='javascript:;' class=" layui-btn layui-btn-primary layui-btn-xs" onclick="metroClick('{{d.metroId}}');">{{d.metro.metroLine}}<b>·</b>{{d.metro.station}}</a>

</script>
<script type="text/html" id="titleTpl3">


    <a href='javascript:;' class=" layui-btn layui-btn-primary layui-btn-xs" onclick="noteClick('{{d.orderId}}','{{d.note}}');">订单要求</a>
    <%--return '<div class=" layui-btn layui-btn-primary layui-btn-xs">'+"客户介绍"+'</div>'--%>
</script>


<form  class="layui-form" action="" style="display: none" enctype="multipart/form-data" id="formInsert">
    <br><br>

    <div class="layui-form-item">
        <label class="layui-form-label">订单编号：</label>
        <div class="layui-input-block">
            <input type="text" id="i1" name="orderId" lay-verify="title" autocomplete="off" placeholder="必填项" class="layui-input" style="width: 30%">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">订购客户：</label>
        <div class="layui-input-block" style="width: 25%">
            <select  id="i2" name="customId" lay-verify="required" lay-filter="customInsertFilter" >
                <option value=""></option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">订购客户：</label>
        <div class="layui-input-block" style="width: 25%">
            <select  id="i3" name="productId" lay-verify="required" lay-filter="productInsertFilter" >
                <option value=""></option>
            </select>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">订购数量：</label>
        <div class="layui-input-block">
            <input type="text" id="i4" name="quantity" lay-verify="title" autocomplete="off"  class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">税前单价：</label>
        <div class="layui-input-block">
            <input type="text" id="i5" name="unitPrice" lay-verify="title" autocomplete="off"  class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单位：</label>
        <div class="layui-input-block">
            <input type="text" id="i6" name="unit" lay-verify="title" autocomplete="off"  class="layui-input" style="width: 30%">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label" >订单状态：</label>
        <div class="layui-input-block" id="is" style="width: 25%">
            <select name="status" lay-verify="required" lay-filter="insertfilter" id="i7">
                <option value="0">未开始</option>
                <option value="1">已开始</option>
                <option value="2">已完成</option>
                <option value="3">订单取消</option>
            </select>
        </div>
    </div>

    <div class="layui-inline">
        <label class="layui-form-label">订购日期：</label>
        <div class="layui-input-inline">
            <input type="text" name="orderDate" class="layui-input" id="i8" placeholder="请选择">
        </div>
    </div><br><br>

    <div class="layui-inline">
        <label class="layui-form-label">要求日期：</label>
        <div class="layui-input-inline">
            <input type="text" name="requestDate" class="layui-input" id="i9" placeholder="请选择">
        </div>
    </div><br><br>

    <div class="layui-form-item">
        <label class="layui-form-label" style="white-space:nowrap">合同扫描件：</label>
        <div class="layui-input-block">
            <%-- <input type="text" id="i10" name="title" lay-verify="title" autocomplete="off"  class="layui-input" style="width: 30%">--%>
            <input type="file" name="pictureFile" id="pictureFile" value="请选择图片" />
        </div>
    </div>
    <%--<div class="layui-form-item">
        <label class="layui-form-label" style="white-space:nowrap">合同扫描件：</label>
        <div class="layui-upload">
            <button type="button" class="layui-btn" id="test1">上传图片</button>
            <div class="layui-upload-list">
                <img class="layui-upload-img" id="demo1">
                <p id="demoText"></p>
            </div>
        </div>
    </div>--%>




    <div class="layui-form-item">
        <label class="layui-form-label">附件：</label>
        <div class="layui-input-block">
            <input type="text" id="i11" name="" lay-verify="title" autocomplete="off"  class="layui-input" style="width: 30%">
        </div>
    </div>




    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">订单要求：</label>
            <div class="layui-input-block">
                <textarea id="i12" style="display: none;"></textarea>
            </div>
        </div>
    </div>
</form>




<form  class="layui-form" action="" id="formUpdate" style="display: none" lay-filter="formUpdateFilter">



    <div class="layui-form-item">
        <label class="layui-form-label">订购客户：</label>
        <div class="layui-input-block" style="width: 25%">
            <select name="customUpdate" id="u2" lay-verify="required" lay-filter="customInsertFilter" >
                <%--<option value=""></option>--%>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">订购客户：</label>
        <div class="layui-input-block" style="width: 25%">
            <select name="productUpdate" id="u3" lay-verify="required" lay-filter="productInsertFilter" >
                <option value=""></option>
            </select>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">订购数量：</label>
        <div class="layui-input-block">
            <input type="text" id="u4" name="quantity" lay-verify="title" autocomplete="off"  class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">税前单价：</label>
        <div class="layui-input-block">
            <input type="text" id="u5" name="unitPrice" lay-verify="title" autocomplete="off"  class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单位：</label>
        <div class="layui-input-block">
            <input type="text" id="u6" name="unit" lay-verify="title" autocomplete="off"  class="layui-input" style="width: 30%">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label" >订单状态：</label>
        <div class="layui-input-block" style="width: 25%">
            <select name="status" lay-verify="required" lay-filter="updatefilter" id="u7">
                <option value="0">未开始</option>
                <option value="1">已开始</option>
                <option value="2">已完成</option>
                <option value="3">订单取消</option>
            </select>
        </div>
    </div>

    <div class="layui-inline">
        <label class="layui-form-label">订购日期：</label>
        <div class="layui-input-inline">
            <input type="text" name="orderDate" class="layui-input" id="u8" placeholder="请选择">
        </div>
    </div><br><br>

    <div class="layui-inline">
        <label class="layui-form-label">要求日期：</label>
        <div class="layui-input-inline">
            <input type="text" name="requestDate" class="layui-input" id="u9" placeholder="请选择">
        </div>
    </div><br><br>

    <div class="layui-form-item">
        <label class="layui-form-label" style="white-space:nowrap">合同扫描件：</label>
        <div class="layui-input-block">
            <input type="text" id="u10" name="image" lay-verify="title" autocomplete="off"  class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">附件：</label>
        <div class="layui-input-block">
            <input type="text" id="u11" name="file" lay-verify="title" autocomplete="off"  class="layui-input" style="width: 30%">
        </div>
    </div>



    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">订单要求：</label>
            <div class="layui-input-block">
                <textarea id="u12"  name="note" style="display: none;"></textarea>
            </div>
        </div>
    </div>
</form>

<form  class="layui-form" action="" id="formRegionClick" style="display: none" lay-filter="formCustomFilter">
    <div class="layui-form-item">
        <label class="layui-form-label">客户名称：</label>
        <div class="layui-input-block">
            <input type="text" id="c2" name="customName" lay-verify="title" autocomplete="off" placeholder="必填项" class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">客户全称：</label>
        <div class="layui-input-block">
            <input type="text" id="c3" name="fullName" lay-verify="title" autocomplete="off" placeholder="必填项" class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址：</label>
        <div class="layui-input-block">
            <input type="text" id="c4" name="address" lay-verify="title" autocomplete="off" placeholder="必填项" class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">传真：</label>
        <div class="layui-input-block">
            <input type="text" id="c5" name="fax" lay-verify="title" autocomplete="off" placeholder="必填项" class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱：</label>
        <div class="layui-input-block">
            <input type="text" id="c6" name="email" lay-verify="title" autocomplete="off" placeholder="必填项" class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">经理姓名：</label>
        <div class="layui-input-block">
            <input type="text" id="c7" name="ownerName" lay-verify="title" autocomplete="off" placeholder="必填项" class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系电话：</label>
        <div class="layui-input-block">
            <input type="text" id="c8" name="ownerTel" lay-verify="title" autocomplete="off" placeholder="必填项" class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" >客户状态：</label>
        <div class="layui-input-block" id="" style="width: 25%">
            <select name="status" lay-verify="required" lay-filter="updatefilter" id="c9">
                <option value="1">有效客户</option>
                <option value="0">无效客户</option>

            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">备注：</label>
            <div class="layui-input-block">
                <textarea id="c10" name="note" style="display: none;"></textarea>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="customClick">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>

<form  class="layui-form" action="" id="formProductClick" style="display: none" lay-filter="formProductFilter">

    <div class="layui-form-item">
        <label class="layui-form-label">产品名称：</label>
        <div class="layui-input-block">
            <input type="text" id="p2" name="productName" lay-verify="title" autocomplete="off" placeholder="必填项" class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产品种类：</label>
        <div class="layui-input-block">
            <input type="text" id="p3" name="productType" lay-verify="title" autocomplete="off" placeholder="必填项" class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" >状态：</label>
        <div class="layui-input-block"  style="width: 25%">
            <select name="status" lay-verify="required" lay-filter="updatefilter" id="p4">
                <option value="1">有效产品</option>
                <option value="0">停产</option>

            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">相关图片：</label>
        <div class="layui-input-block">
            <input type="text" id="p5" name="image" lay-verify="title" autocomplete="off" placeholder="上传图片" class="layui-input" style="width: 30%">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">产品介绍：</label>
            <div class="layui-input-block">
                <textarea id="p6" name="note" style="display: none;"></textarea>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="productClick">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<form  class="layui-form" action="" id="formIntroduce" style="display: none" lay-filter="formIntroduceFilter">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">备注：</label>
            <div class="layui-input-block">
                <textarea id="introduce1" style="display: none;"></textarea>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="checkBoxIntroduce">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<script>
    layui.config({
        version: '1594038786020' //为了更新 js 缓存，可忽略
    });

    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'element', 'slider','form','jquery','layedit','upload'], function(){
        var laydate = layui.laydate //日期
            ,layer = layui.layer //弹层
            ,table = layui.table //表格
            ,form=layui.form //表单
            ,layedit = layui.layedit //富文本编辑器
            ,$=layui.$
            ,upload=layui.upload;


        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,height: 500
            ,url: '<%=basePath%>/adminFindAllHouse' //数据接口
            ,id: 'testReload'
            ,title: '招租信息表'
            ,page: true //开启分页
            ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'id', title: '房屋编号', width:100,align:'center'}
                ,{title: '区域', width:140,templet:$("#titleTpl1"),align:'left'}
                ,{title: '地铁', width:140,templet:$("#titleTpl2"),align:'left'}
                ,{field: 'houseType', title: '房源类型', width:110, sort: true,align:'center'}
                ,{field: 'listingsType', title: '房源户型', width: 110, sort: true,align:'center'}
                ,{field: 'rentalMode', title: '出租方式', width:80,align:'center'}
                ,{field: 'roomType', title: '房间类型', width: 110, sort: true,align:'center'}
                ,{field: 'rent', title: '月租金', width: 110, sort: true,align:'center'}
                ,{field: 'houseIntroduction', title: '房屋介绍', width: 100,align:'center',templet:$("#titleTpl3")}
                ,{field: 'checkinTime', title: '可入住时间', width: 110, sort: true,align:'center'}
                ,{field: 'sex', title: '租客性别', width: 110, sort: true,align:'center'}
                ,{field: 'call', title: '房东称呼', width: 110, sort: true,align:'center'}
                ,{field: 'tel', title: '联系方式', width: 110, sort: true,align:'center'}
                ,{field: 'code', title: '出租状态', width:100, sort: true, templet:function (item) {
                        if(item.status==0){
                            return ' <span style="color: #FF5722;">' + "未租出" + '</span>'
                        }else if(item.status==1){
                            return ' <span style="color: #5FB878;">' + "已租出" + '</span>'
                        }
                    },align:'center'}
                ,{field: 'createTime', title: '创建时间', width: 170,sort: true,templet:function (item) {
                        if(item.createTime!=null){
                            return '<div>'+layui.util.toDateString(item.createTime,"yyyy-MM-dd HH:mm:ss")+'</div>'
                        }else{
                            return "";
                        }
                    },align:'center'}
                ,{field: 'updateTime', title: '更新时间', width: 170, sort: true, templet:function (item) {
                        if(item.updateTime!=null){
                            return '<div>'+layui.util.toDateString(item.updateTime,"yyyy-MM-dd HH:mm:ss")+'</div>'
                        }else{
                            return "";
                        }
                    },align:'center'}

                ,{field: 'image', title: '房屋图片', width: 100,align:'center'}
                ,{field: 'file', title: '房间配置', width: 100,align:'center'}
                ,{field: 'file', title: '房间标签', width: 100,align:'center'}
                ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}

            ]]
        });

        //查询数据 重载表格
        var selectdata;
        form.on('select(selectfilter)', function(data){
            selectdata=data.value;
            //console.log(data.value); //得到被选中的值

        });

        var $ = layui.$, active = {
            reload: function(){
                var demoReload = $('#demoReload');

                //执行重载
                table.reload('testReload', {
                    url:"<%=request.getContextPath()%>/findOrderBy",
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {

                        select: selectdata,
                        data:demoReload.val()


                    }
                });
            }
        };

        $('#dr #reloadbutton').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });



        //监听
        /*var insertdata;
        form.on('select(insertfilter)', function(data){
            insertdata=data.value;
            //console.log(data.value); //得到被选中的值
        });*/




        //监听头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'getInsert':
                    //layer.msg('添加');
                    layer.open({

                        type:1
                        ,area:['700px', '500px']
                        ,title:'添加订单信息'
                        ,content:$("#formInsert") //'请修改用户信息'
                        ,btn: ['添加']
                        ,success:function (layero, index) {

                            indexI12=layedit.build('i12');    //建立编辑器


                            //select标签动态赋值

                            $.ajax({
                                type: "POST",
                                url: "<%=request.getContextPath()%>/selectCustomIdAndName",
                                contentType:'application/json;charset=utf-8',
                                success: function(msg){
                                    //console.log(msg);
                                    $.each(msg.data,function (index,value) {
                                        //console.log(value);
                                        $("#i2").append(new Option(value.customName,value.customId));
                                    });
                                    layui.form.render("select");
                                }
                            });

                            $.ajax({
                                type: "POST",
                                url: "<%=request.getContextPath()%>/selectProductIdAndName",
                                contentType:'application/json;charset=utf-8',
                                success: function(msg){
                                    //console.log(msg);
                                    $.each(msg.data,function (index,value) {
                                        //console.log(value);
                                        $("#i3").append(new Option(value.productName,value.productId));
                                    });
                                    layui.form.render("select");
                                }
                            });

                            /*form.on('submit(insertFilter)', function(data){
                                layedit.sync(indexI12);

                            });*/


                            //普通图片上传
                            /* var uploadInst = upload.render({
                                 elem: '#test1'
                                 ,url: 'https://httpbin.org/post' //改成您自己的上传接口
                                 ,before: function(obj){
                                     //预读本地文件示例，不支持ie8
                                     obj.preview(function(index, file, result){
                                         $('#demo1').attr('src', result); //图片链接（base64）
                                     });
                                 }
                                 ,done: function(res){
                                     //如果上传失败
                                     if(res.code > 0){
                                         return layer.msg('上传失败');
                                     }
                                     //上传成功
                                 }
                                 ,error: function(){
                                     //演示失败状态，并实现重传
                                     var demoText = $('#demoText');
                                     demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                                     demoText.find('.demo-reload').on('click', function(){
                                         uploadInst.upload();
                                     });
                                 }
                             });*/

                        }
                        ,yes: function(index, layero){
                            //按钮【添加】的回调
                            //console.log($("#pictureFile").val())
                            var dataI12=layedit.getContent(indexI12);
                            var orderId=$("#i1").val();
                            var customId=$("#i2").val();
                            var productId=$("#i3").val();
                            var quantity=$("#i4").val();
                            var unitPrice=$("#i5").val();
                            var unit=$("#i6").val();
                            //var status=insertdata;
                            var status=$("#i7").val();
                            //console.log(status);
                            var orderDate=$("#i8").val();
                            var requestDate=$("#i9").val();
                            var image=$("#i10").val();
                            var file=$("#i11").val();
                            var note=dataI12;
                            var order={
                                "orderId":orderId,
                                "customId":customId,
                                "productId":productId,
                                "orderDate":orderDate,
                                "requestDate":requestDate,
                                "note":note,
                                "quantity":quantity,
                                "unitPrice":unitPrice,
                                "unit":unit,
                                "image":image,
                                "file":file,
                                "status":status
                            };


                            var requestBody=JSON.stringify(order);
                            //console.log(requestBody);


                            $.ajax({
                                type: "POST",
                                url: "<%=request.getContextPath()%>/insertOrder",
                                contentType:'application/json;charset=utf-8',
                                data:requestBody,
                                success: function(msg){
                                    if(msg==1) {
                                        layer.close(index);
                                        layer.msg('添加成功');
                                        setTimeout(function(){

                                            window.location.reload();

                                        }, 1000);
                                    }else if(msg==-1){
                                        layer.msg('请输入必填项');
                                    }
                                }
                            });
                        }
                        ,cancel: function(){
                            //右上角关闭回调
                            $("#i2").empty();
                            $("#i3").empty();
                            form.render("select");


                            //return false 开启该代码可禁止点击该按钮关闭
                        }
                    });
                    break;


                case 'getDelete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {
                        var ids=[];
                        for (var i = 0; i < data.length; i++) {
                            ids[i]= data[i].orderId;
                            console.log(ids[i]);
                        }
                        var requestBody=JSON.stringify(ids);
                        //ids = ids.substr(0, ids.length);
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/deleteOrderByIds",
                            contentType:'application/json;charset=utf-8',
                            data: requestBody,
                            success: function(msg){
                                if(msg!=0) {
                                    layer.msg("删除成功");
                                    setTimeout(function(){

                                        window.location.reload();

                                    }, 1000);
                                }
                            }
                        });
                    }
                    break;
                case 'getRefresh':
                    window.location.reload();
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                layer.msg('查看操作');
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令

                    $.ajax({
                        type: "POST",
                        url: "<%=request.getContextPath()%>/deleteOrderById",
                        data: {"id":data.orderId},
                        success: function(msg){
                            if(msg==1) {
                                layer.msg("删除成功");
                                setTimeout(function(){

                                    window.location.reload();

                                }, 1000);
                            }
                        }
                    });

                });
            } else if(layEvent === 'edit'){
                //layer.msg('编辑操作');


                //console.log(data);
                layer.open({

                    type:1
                    ,area:['700px', '500px']
                    ,title:'修改订单信息'
                    ,content:$("#formUpdate") //'请修改用户信息'
                    ,btn: ['修改']
                    ,success:function (layero, index) {



                        $.ajax({
                            type: "POST",
                            //async: false,
                            url: "<%=request.getContextPath()%>/selectCustomIdAndName",
                            contentType:'application/json;charset=utf-8',
                            success: function(msg){

                                $.each(msg.data,function (index,value) {

                                    $("#u2").append(new Option(value.customName,value.customId));

                                    //动态select回显
                                    if(value.customName===data.custom.customName){
                                        $("#u2").val(value.customId);
                                    }
                                });

                                layui.form.render("select");
                            }
                        });

                        $.ajax({
                            type: "POST",
                            //async: false,
                            url: "<%=request.getContextPath()%>/selectProductIdAndName",
                            contentType:'application/json;charset=utf-8',
                            success: function(msg){

                                $.each(msg.data,function (index,value) {

                                    $("#u3").append(new Option(value.productName,value.productId));

                                    if(value.productName===data.product.productName){
                                        $("#u3").val(value.productId)
                                    }
                                });
                                layui.form.render("select");
                            }
                        });

                        //console.log(data);
                        //console.log(data.file);
                        //console.log(data.note)

                        form.val("formUpdateFilter",{
                            "customUpdate":data.custom.customName,
                            "productUpdate":data.product.productName,
                            "quantity":data.quantity,
                            "unitPrice":data.unitPrice,
                            "unit":data.unit,
                            "status":data.status,
                            "orderDate":data.orderDate,
                            "requestDate":data.requestDate,
                            "image":data.image,
                            //"file":data.file,
                            "note":data.note
                        });

                        $("#u11").val(data.file);
                        updateU12=layedit.build('u12');
                        //layui.form.render("select");


                    }
                    ,yes: function(index, layero){
                        //按钮【修改】的回调

                        var dataU12=layedit.getContent(updateU12);


                        var orderId=data.orderId;
                        var customId=$("#u2").val();
                        var productId=$("#u3").val();
                        var quantity=$("#u4").val();
                        var unitPrice=$("#u5").val();
                        var unit=$("#u6").val();
                        var status=$("#u7").val();
                        var orderDate=$("#u8").val();
                        var requestDate=$("#u9").val();
                        var image=$("#u10").val();
                        var file=$("#u11").val();
                        var note=dataU12;
                        var order={
                            "orderId":orderId,
                            "customId":customId,
                            "productId":productId,
                            "orderDate":orderDate,
                            "requestDate":requestDate,
                            "note":note,
                            "quantity":quantity,
                            "unitPrice":unitPrice,
                            "unit":unit,
                            "image":image,
                            "file":file,
                            "status":status
                        };

                        var requestBody=JSON.stringify(order);
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/updateOrderById",
                            contentType:'application/json;charset=utf-8',
                            data: requestBody,
                            success: function(msg){
                                if(msg==1) {
                                    layer.close(index);
                                    layer.msg('修改成功');
                                    setTimeout(function(){

                                        window.location.reload();

                                    }, 1000);
                                }
                            }
                        });
                    }
                    ,cancel: function(){
                        //右上角关闭回调

                        $("#u2").empty();
                        $("#u3").empty();
                        form.render("select");
                        //return false 开启该代码可禁止点击该按钮关闭
                    }
                });
            }
        });

        //日期时间选择器
        laydate.render({
            elem: '#u8'
            ,type: 'datetime'
            ,trigger: 'click'
        });
        laydate.render({
            elem: '#u9'
            ,type: 'datetime'
            ,trigger: 'click'
        });
        laydate.render({
            elem: '#i8'
            ,type: 'datetime'
            ,trigger: 'click'
        });
        laydate.render({
            elem: '#i9'
            ,type: 'datetime'
            ,trigger: 'click'
        });

    });

    function regionClick(id) {
        console.log(id);
        layui.use([ 'layer', 'form','jquery','layedit'], function(){
            var layer = layui.layer,
                form=layui.form,
                $=layui.$,
                layedit=layui.layedit;
            layer.open({
                type:1
                ,area:['700px', '480px']
                ,title:'修改角色信息'
                ,content:$("#formRegionClick") //'请修改用户信息'
                //,btn: ['修改']
                ,success:function (layero, index) {

                    $.ajax({
                        type: "POST",
                        url: "<%=request.getContextPath()%>/findCustomBy",
                        async :false,
                        data:{
                            "select":0,
                            "data":id
                        },
                        success: function(msg){
                            console.log(msg.data);
                            form.val("formCustomFilter",{
                                "customName":msg.data[0].customName,
                                "fullName":msg.data[0].fullName,
                                "address":msg.data[0].address,
                                "fax":msg.data[0].fax,
                                "email":msg.data[0].email,
                                "ownerName":msg.data[0].ownerName,
                                "ownerTel":msg.data[0].ownerTel,
                                "status":msg.data[0].status,
                                "note":msg.data[0].note
                            });
                        }
                    });
                    dataCustomC10=layedit.build('c10');


                    form.on('submit(customClick)', function(data){
                        var dataC10=layedit.getContent(dataCustomC10);
                        var customId=id;
                        var customName=$("#c2").val();
                        var fullName=$("#c3").val();
                        var address=$("#c4").val();
                        var fax=$("#c5").val();
                        var email=$("#c6").val();
                        var ownerName=$("#c7").val();
                        var ownerTel=$("#c8").val();
                        var status=$("#c9").val();
                        var note=dataC10;
                        var custom={
                            "customId":customId,
                            "customName":customName,
                            "fullName":fullName,
                            "address":address,
                            "fax":fax,
                            "email":email,
                            "ownerName":ownerName,
                            "ownerTel":ownerTel,
                            "status":status,
                            "note":note
                        };

                        var requestBody=JSON.stringify(custom);
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/updateCustom",
                            contentType:'application/json;charset=utf-8',
                            data: requestBody,
                            success: function(msg){
                                if(msg==1) {
                                    layer.close(index);
                                    layer.msg('修改成功');
                                    setTimeout(function(){

                                        window.location.reload();

                                    }, 1000);
                                }
                            }
                        });
                        return false;
                    });

                }
            });


        });
    }
    function metroClick(id) {
        console.log(id);
        layui.use([ 'layer', 'form','jquery','layedit'], function(){
            var layer = layui.layer,
                form=layui.form,
                $=layui.$,
                layedit=layui.layedit;
            layer.open({
                type:1
                ,area:['700px', '480px']
                ,title:'修改角色信息'
                ,content:$("#formProductClick") //'请修改用户信息'
                //,btn: ['修改']
                ,success:function (layero, index) {

                    $.ajax({
                        type: "POST",
                        url: "<%=request.getContextPath()%>/findProductBy",
                        async :false,
                        data:{
                            "select":0,
                            "data":id
                        },
                        success: function(msg){
                            console.log(msg.data);
                            form.val("formProductFilter",{
                                "productName":msg.data[0].productName,
                                "productType":msg.data[0].productType,
                                "image":msg.data[0].image,
                                "status":msg.data[0].status,
                                "note":msg.data[0].note
                            });
                        }
                    });
                    dataProductP6=layedit.build('p6');


                    form.on('submit(productClick)', function(data){
                        var dataP6=layedit.getContent(dataProductP6);
                        var productId=id;
                        var productName=$("#p2").val();
                        var productType=$("#p3").val();
                        var status=$("#p4").val();
                        var image=$("#p5").val();
                        var note=dataP6;
                        var product={
                            "productId":productId,
                            "productName":productName,
                            "productType":productType,
                            "status":status,
                            "note":note,
                            "image":image,
                        };

                        var requestBody=JSON.stringify(product);
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/updateProduct",
                            contentType:'application/json;charset=utf-8',
                            data: requestBody,
                            success: function(msg){
                                if(msg==1) {
                                    layer.close(index);
                                    layer.msg('修改成功');
                                    setTimeout(function(){

                                        window.location.reload();

                                    }, 1000);
                                }
                            }
                        });
                        return false;
                    });

                }
            });


        });
    }
    function noteClick(id,note) {
        console.log(id);
        console.log(note);
        layui.use([ 'layer', 'form','jquery','layedit'], function() {
            var layer = layui.layer,
                form = layui.form,
                $ = layui.$,
                layedit=layui.layedit;
            layer.open({
                type:1
                ,area:['700px', '480px']
                ,title:'产品介绍'
                ,content:$("#formIntroduce") //'请修改用户信息'
                //,btn: ['修改']
                ,success:function (layero, index) {
                    $("#introduce1").val(note);
                    introduce1=layedit.build('introduce1');
                    form.on('submit(checkBoxIntroduce)', function(data){
                        var dataIntroduce=layedit.getContent(introduce1);


                        var orderId=id;
                        var note=dataIntroduce;
                        var order={
                            "orderId":orderId,
                            "note":note
                        };

                        var requestBody=JSON.stringify(order);
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/updateOrderById",
                            contentType:'application/json;charset=utf-8',
                            data: requestBody,
                            success: function(msg){
                                if(msg==1) {
                                    layer.close(index);
                                    layer.msg('修改成功');
                                    setTimeout(function(){

                                        window.location.reload();

                                    }, 1000);
                                }
                            }
                        });
                        return false;
                    });
                }
            });


        });
    }
</script>
</body>
</html>
