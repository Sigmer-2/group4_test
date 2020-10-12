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
                <option value="0">区域</option>
                <option value="1">地铁</option>
                <option value="2">月租金</option>
                <option value="3">房源类型</option>
                <option value="4">出租方式</option>
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
<%--    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>--%>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
<%--        <button type="button" class="layui-btn layui-btn-sm" lay-event="getInsert">--%>
<%--            <i class="layui-icon ">&#xe608;</i> 添加--%>
<%--        </button>--%>
        <button type="button" class="layui-btn layui-btn-sm  layui-btn-danger" lay-event="getDelete">
            <i class="layui-icon">&#x1006;</i> 删除
        </button>
        <button type="button" class="layui-btn layui-btn-sm" lay-event="getRefresh">
            <i class="layui-icon">&#xe9aa;</i> 刷新
        </button>
    </div>
</script>
<script type="text/html" id="titleTpl1">
    <a href='javascript:;' class=" layui-btn layui-btn-primary layui-btn-xs" onclick="regionClick('{{d.regionId}}','{{d.region.distrctName}}','{{d.region.street}}');">{{d.region.distrctName}}<b>·</b>{{d.region.street}}</a>
</script>
<script type="text/html" id="titleTpl2">
    <a href='javascript:;' class=" layui-btn layui-btn-primary layui-btn-xs" onclick="metroClick('{{d.metroId}}','{{d.metro.metroLine}}','{{d.metro.station}}');">{{d.metro.metroLine}}<b>·</b>{{d.metro.station}}</a>
</script>
<script type="text/html" id="titleTpl3">
    <a href='javascript:;' class=" layui-btn layui-btn-primary layui-btn-xs" onclick="noteClick('{{d.id}}','{{d.houseIntroduction}}');">{{d.houseIntroduction}}</a>
    <%--return '<div class=" layui-btn layui-btn-primary layui-btn-xs">'+"客户介绍"+'</div>'--%>
</script>
<script type="text/html" id="titleTpl4">
<%--{{# console.log(d.houseRefImgs);}}--%>
<%--{{# var list = JSON.stringify(d.houseRefImgs);}}--%>
<%--{{# console.log(list);}}--%>
    <img src="{{d.houseRefImgs[0].houseImg.imgUrl}}"  onclick="imgClick('{{d.id}}');"> </img>
</script>
<script type="text/html" id="titleTpl5">
    <div><a href='javascript:;' class=" layui-btn-radius layui-btn-normal layui-btn layui-btn-xs" onclick="labelClick('{{d.houseRefLabel.houseId}}','{{d.houseRefLabel.houseLabelId}}');">房屋标签</a></div>
</script>
<script type="text/html" id="titleTpl6">
    <div><a href='javascript:;' class=" layui-btn-radius layui-btn-normal layui-btn layui-btn-xs" onclick="deployClick('{{d.houseRefDeploy.houseId}}','{{d.houseRefDeploy.houseDeployId}}');">房间配置</a></div>
</script>
<table class="layui-table" lay-size="lg" id="img1">
<%--    <colgroup>--%>
<%--        <col width="150">--%>
<%--        <col width="200">--%>
<%--    </colgroup>--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>图片</th>--%>
<%--        <th>是否为封面</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody id="img">--%>

<%--    </tbody>--%>
</table>
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

<form  class="layui-form" action="" id="formRegionClick" style="display: none" lay-filter="formRegionFilter">
    <div class="layui-form-item" style="display:inline-block;width:40%">
        <div class="layui-input-block">
            <select name="area"  id="selectArea" lay-filter="area">
                <option value="">请选择区域</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="display:inline-block;width:40%">
        <div class="layui-input-block">
            <select name="street" id="selectStreet" lay-filter="street">
                <option value="">请选择街道</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" >
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="regionClick">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>
<form  class="layui-form" action="" id="formMetroClick" style="display: none" lay-filter="formMetroFilter">
    <div class="layui-form-item" style="display:inline-block;width:40%">
        <div class="layui-input-block">
            <select name="line"  id="selectLine" lay-filter="line">
                <option value="">请选择线路</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="display:inline-block;width:40%">
        <div class="layui-input-block">
            <select name="station" id="selectStation" lay-filter="station">
                <option value="">请选择站点</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" >
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="metroClick">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>
<form  class="layui-form" action="" id="formLabelClick" style="display: none" >

    <div class="layui-form-item" pane="">
        <label class="layui-form-label">房屋标签：</label>
        <div class="layui-input-block">
            <input type="checkbox" name="shortRent"  value="1" lay-skin="primary" title="可短租" >
            <input type="checkbox" name="payment" value="2" lay-skin="primary" title="月付">
            <input type="checkbox" name="southward" value="3" lay-skin="primary" title="南向" >
            <input type="checkbox" name="agencyfee" value="4" lay-skin="primary" title="无中介费" >
            <input type="checkbox" name="toilet" value="5" lay-skin="primary" title="独卫" >
            <input type="checkbox" name="balcony" value="6" lay-skin="primary" title="独立阳台" >
            <input type="checkbox" name="elevator" value="7" lay-skin="primary" title="电梯房" >
            <input type="checkbox" name="bayWindow" value="8" lay-skin="primary" title="带飘窗" >
            <input type="checkbox" name="decoration" value="9" lay-skin="primary" title="精装修" >
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="checkBoxClick">提交修改</button>
        </div>
    </div>
</form>
<form  class="layui-form" action="" id="formDeployClick" style="display: none" >

    <div class="layui-form-item" pane="">
        <label class="layui-form-label">房间配置：</label>
        <div class="layui-input-block">
            <input type="checkbox" name="bed"  value="1" lay-skin="primary" title="床" >
            <input type="checkbox" name="wifi" value="2" lay-skin="primary" title="wifi">
            <input type="checkbox" name="conditioner" value="3" lay-skin="primary" title="空调" >
            <input type="checkbox" name="wardrobe" value="4" lay-skin="primary" title="衣柜" >
            <input type="checkbox" name="desk" value="5" lay-skin="primary" title="书桌" >
            <input type="checkbox" name="chair" value="6" lay-skin="primary" title="椅子" >
            <input type="checkbox" name="sofa" value="7" lay-skin="primary" title="沙发" >
            <input type="checkbox" name="refrigerator" value="8" lay-skin="primary" title="冰箱" >
            <input type="checkbox" name="washing" value="9" lay-skin="primary" title="洗衣机" >
            <input type="checkbox" name="tv" value="10" lay-skin="primary" title="电视机" >
            <input type="checkbox" name="heater" value="11" lay-skin="primary" title="热水器" >
            <input type="checkbox" name="stove" value="12" lay-skin="primary" title="燃气灶" >
            <input type="checkbox" name="microwave" value="13" lay-skin="primary" title="微波炉" >
            <input type="checkbox" name="lampblack" value="14" lay-skin="primary" title="油烟机" >
            <input type="checkbox" name="dining" value="15" lay-skin="primary" title="餐桌椅" >
            <input type="checkbox" name="lock" value="16" lay-skin="primary" title="智能锁" >
            <input type="checkbox" name="led" value="17" lay-skin="primary" title="台灯" >
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="checkBoxClick2">提交修改</button>
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
                ,{field: 'estate', title: '小区位置', width:100,align:'center'}
                ,{field: 'houseType', title: '房源类型', width:110, sort: true,align:'center'}
                ,{field: 'listingsType', title: '房源户型', width: 110, sort: true,align:'center'}
                ,{field: 'rentalMode', title: '出租方式', width:80,align:'center'}
                ,{field: 'roomType', title: '房间类型', width: 110, sort: true,align:'center'}
                ,{field: 'rent', title: '月租金', width: 110, sort: true,align:'center'}
                ,{field: 'houseIntroduction', title: '房屋介绍', width: 100,align:'center',templet:$("#titleTpl3")}
                ,{field: 'checkinTime', title: '可入住时间', width: 110, sort: true,align:'center'}
                ,{field: 'sex', title: '租客性别', width: 110, sort: true,templet:function (item) {
                        if(item.sex==0){
                            return "男女不限";
                        }else if(item.sex==1){
                            return "只限男";
                        }else if(item.sex==2){
                            return "只限女";
                        }
                    },align:'center'}
                ,{field: 'call', title: '房东称呼', width: 110, sort: true,align:'center'}
                ,{field: 'tel', title: '联系方式', width: 110, sort: true,align:'center'}
                ,{field: 'code', title: '出租状态', width:100, sort: true, templet:function (item) {
                        if(item.code==0){
                            return ' <span style="color: #FF5722;">' + "未租出" + '</span>'
                        }else if(item.code==1){
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

                ,{title: '房屋图片', width: 140,align:'center',templet:$("#titleTpl4")}
                ,{title: '房间配置', width: 100,align:'center',templet:$("#titleTpl6")}
                ,{title: '房屋标签', width: 100,align:'center',templet:$("#titleTpl5")}
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
                    url:"<%=request.getContextPath()%>/AdminfindHouseBy",
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
                            ids[i]= data[i].id;
                            console.log(ids[i]);
                        }
                        var param={
                            "ids":ids,
                        };
                        var requestBody=JSON.stringify(param);
                        //ids = ids.substr(0, ids.length);
                        $.ajax({
                            type: "POST",
                            url: "<%=basePath%>/adminDeleteHouseByIds",
                            contentType:'application/json;charset=utf-8',
                            data: requestBody,
                            success: function(res){
                                if(res.msg!=0) {
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
            console.log("data",data);
            if(layEvent === 'detail'){
                layer.msg('查看操作');
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令

                    $.ajax({
                        type: "POST",
                        url: "<%=request.getContextPath()%>/adminDeleteHouseById",
                        data: {"id":data.id},
                        success: function(res){
                            if(res.msg==1) {
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

    function regionClick(id,area,street) {
        console.log(id);
        console.log(area);
        console.log(street);


        var regionId = id;
        layui.use([ 'layer', 'form','jquery'], function(){
            var layer = layui.layer,
                form=layui.form,
                $=layui.$;

            layer.open({
                type:1
                ,area:['700px', '480px']
                ,title:'修改区域信息'
                ,content:$("#formRegionClick") //'请修改区域信息'
                ,success:function (layero, index) {
                    // $("#selectArea").val(area);
                    // $("#selectStreet").val(street);
                    $.ajax({
                        type: "POST",
                        url: "<%=request.getContextPath()%>/findAllArea",
                        success: function(msg){
                            //console.log(msg);
                            $.each(msg.data,function (index,value) {
                                //console.log(value);
                                $("#selectArea").append(new Option(value.areaName,value.id));
                                if(value.areaName===area){
                                    $("#selectArea").val(value.id)
                                 }
                            });
                            form.render("select");
                        }
                    });
                    form.on('select(area)', function (data1) {
                        console.log(data1.value);

                        $("#selectStreet").empty();
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/findStreetByAreaId",
                            data:{"id":data1.value},
                            async:false,
                            success: function(msg){
                                //console.log(msg);
                                $.each(msg.data,function (index,value) {
                                    //console.log(value);
                                    $("#selectStreet").append(new Option(value.streetName,value.id));
                                    if(value.streetName===street){
                                        $("#selectStreet").val(value.id)
                                    }
                                });

                                form.render("select");

                            }
                        });
                    });
                    form.on('select(street)',function(data2){
                        form.render("select");
                    });
                    // form.val("formRegionFilter",{
                    //     "area":area,
                    //     "street":street
                    // });
                    form.on('submit(regionClick)', function(data3){
                        var region={
                            "id":regionId,
                            "distrctName":$("#selectArea option:selected").text(),
                            "street": $("#selectStreet option:selected").text()
                        };
                        console.log(region);

                        var requestBody=JSON.stringify(region);
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/adminUpdateRegion",
                            contentType:'application/json;charset=utf-8',
                            data: requestBody,
                            success: function(res){
                                if(res.msg==1) {
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
                    $("#selectArea").empty();
                    $("#selectStreet").empty();
                }

            });


        });
    }
    function metroClick(id,line,station) {
        console.log(id);
        var metroId = id;
        layui.use([ 'layer', 'form','jquery'], function(){
            var layer = layui.layer,
                form=layui.form,
                $=layui.$;

            layer.open({
                type:1
                ,area:['700px', '480px']
                ,title:'修改地铁信息'
                ,content:$("#formMetroClick") //'请修改区域信息'
                ,success:function (layero, index) {
                    $.ajax({
                        type: "POST",
                        url: "<%=request.getContextPath()%>/findAllLine",
                        success: function(msg){
                            //console.log(msg);
                            $.each(msg.data,function (index,value) {
                                //console.log(value);
                                $("#selectLine").append(new Option(value.lineName,value.id));
                                if(value.lineName===line){
                                    $("#selectLine").val(value.id)
                                }
                            });
                            form.render("select");
                        }
                    });
                    form.on('select(line)', function (data1) {
                        console.log(data1.value);

                        $("#selectStation").empty();
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/findStationByLineId",
                            data:{"id":data1.value},
                            async:false,
                            success: function(msg){
                                //console.log(msg);
                                $.each(msg.data,function (index,value) {
                                    //console.log(value);
                                    $("#selectStation").append(new Option(value.stationName,value.id));
                                    if(value.stationName===station){
                                        $("#selectStation").val(value.id)
                                    }
                                });

                                form.render("select");

                            }
                        });
                    });
                    form.on('select(station)',function(data2){
                        form.render("select");
                    });
                    // form.val("formRegionFilter",{
                    //     "area":area,
                    //     "street":street
                    // });
                    form.on('submit(metroClick)', function(data3){
                        var metro={
                            "id":metroId,
                            "metroLine":$("#selectLine option:selected").text(),
                            "station": $("#selectStation option:selected").text()
                        };
                        console.log(metro);

                        var requestBody=JSON.stringify(metro);
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/adminUpdateMetro",
                            contentType:'application/json;charset=utf-8',
                            data: requestBody,
                            success: function(res){
                                if(res.msg==1) {
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
                    $("#selectLine").empty();
                    $("#selectStation").empty();
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
                ,title:'房屋简介'
                ,content:$("#formIntroduce") //'请修改房屋简介信息'
                //,btn: ['修改']
                ,success:function (layero, index) {
                    $("#introduce1").val(note);
                    introduce1=layedit.build('introduce1');
                    form.on('submit(checkBoxIntroduce)', function(data){
                        var dataIntroduce=layedit.getContent(introduce1);


                        var houseId=id;
                        var note=dataIntroduce;
                        var house={
                            "id":houseId,
                            "houseIntroduction":note
                        };

                        var requestBody=JSON.stringify(house);
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/adminUpdateHouseById",
                            contentType:'application/json;charset=utf-8',
                            data: requestBody,
                            success: function(res){
                                if(res.msg==1) {
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
    function imgClick(id) {
        //console.log(JSON.stringify(imgList));

        // var img = "#img"+id;
        // console.log(img);

        layui.use([ 'layer', 'form','jquery'], function() {
            var layer = layui.layer,
                form = layui.form,
                $ = layui.$;
            layer.open({
                type:1
                ,area:['700px', '480px']
                ,title:'房屋图片'
                ,content:$("#img1")
                ,success:function (layero, index) {
                    console.log(id);
                    $.ajax({
                        type: "POST",
                        url: "<%=basePath%>/findImgsByHouseId",
                        async :false,
                        data:{
                            "id":id
                        },
                        success: function(msg){
                            //console.log(msg);
                            //var lis = [];
                            var html = "";
                            html+="<colgroup><col width=\"150\"><col width=\"200\"></colgroup><thead><tr><th>图片</th><th>是否为封面</th></tr></thead><tbody>";

                            //console.log(msg.data);
                            $.each(msg.data,function (index,value) {


                                console.log(value);
                                if(value.houseImg.imgPage==1)
                                {
                                    html+="<tr><td><img src='<%=request.getContextPath()%>"+value.houseImg.imgUrl+"'></td><td>是</td></tr></tbody>"
                                }
                                else
                                {
                                    html+="<tr><td><img src='<%=request.getContextPath()%>"+value.houseImg.imgUrl+"'></td><td>否</td></tr></tbody>"
                                }
                               // $("#img").append(html);
                            });
                            $("#img1").append(html);
                            // lis.push(
                            //     html
                            // );
                        }
                    });
                }
                ,cancel: function() {
                    //右上角关闭回调
                    $("#img1").empty();
                }
            });


        });
    }
    function labelClick(houseId,houseLabelId) {

        console.log(houseId);
        console.log(houseLabelId);
        layui.use([ 'layer', 'form','jquery'], function(){
            var layer = layui.layer,
                form=layui.form,
                $=layui.$;
            layer.open({
                type:1
                ,area:['250px', '400px']
                ,title:'房屋标签'
                ,content: $("#formLabelClick")
                ,success:function (layero, index) {
                    var arr_box=[];
                    $.ajax({
                        type: "POST",
                        url: "<%=request.getContextPath()%>/findLabelByHouseLabelId",
                        async :false,
                        data:{"id":houseLabelId},
                        success: function(msg){
                            console.log(msg.data);
                            if(msg.data.shortRent==1)
                            {
                                $('input[value=1]').prop("checked", true);
                            }
                            if(msg.data.payment==1)
                            {
                                $('input[value=2]').prop("checked", true);
                            }
                            if(msg.data.southward==1)
                            {
                                $('input[value=3]').prop("checked", true);
                            }
                            if(msg.data.agencyfee==1)
                            {
                                $('input[value=4]').prop("checked", true);
                            }
                            if(msg.data.toilet==1)
                            {
                                $('input[value=5]').prop("checked", true);
                            }
                            if(msg.data.balcony==1)
                            {
                                $('input[value=6]').prop("checked", true);
                            }
                            if(msg.data.elevator==1)
                            {
                                $('input[value=7]').prop("checked", true);
                            }
                            if(msg.data.bayWindow==1)
                            {
                                $('input[value=8]').prop("checked", true);
                            }
                            if(msg.data.decoration==1)
                            {
                                $('input[value=9]').prop("checked", true);
                            }
                            // checkBoxLength=msg.data.length;
                            // for(var i=0;i<msg.data.length;i++){
                            //     var checkBoxData = msg.data[i].sysPermissionId;
                            //     arr_boxp[i] = checkBoxData;
                            //     $('input[value=' + checkBoxData + ']').prop("checked", true);
                            // }
                            form.render();
                        }
                    });
                    form.on('submit(checkBoxClick)', function(data2){
                        //console.log(data2.field);
                        /*$('input[type=checkbox]:checked').each(function() {
                            arr_box.push($(this).val());
                        });*/
                        var obj = $("#formLabelClick").find('.layui-form-checked');
                        //console.log(obj);
                        obj.each(function () {
                            arr_box.push($(this).prev().val());
                        });
                        console.log(arr_box);
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/adminUpdateHouseLabel",
                            data: {
                                "id":houseLabelId,
                                "ids":arr_box
                            },
                            traditional:true,
                            success: function(res){
                                //console.log(msg);
                                if(res.msg==1){
                                    layer.close(index);
                                    layer.msg('修改成功');
                                    setTimeout(function () {

                                        window.location.reload();

                                    }, 1000);
                                }
                            }
                        });


                        return false;
                    });
                }
                ,cancel:function(){
                    //右上角关闭回调

                    $('input[type=checkbox]').prop("checked",false);
                    form.render();
                    //return false 开启该代码可禁止点击该按钮关闭
                }
            });
        });

    }
    function deployClick(houseId,houseDeployId) {

        console.log(houseId);
        console.log(houseDeployId);
        layui.use([ 'layer', 'form','jquery'], function(){
            var layer = layui.layer,
                form=layui.form,
                $=layui.$;
            layer.open({
                type:1
                ,area:['320px', '400px']
                ,title:'房间配置'
                ,content: $("#formDeployClick")
                ,success:function (layero, index) {
                    var arr_box=[];
                    $.ajax({
                        type: "POST",
                        url: "<%=request.getContextPath()%>/findDeployByHouseDeployId",
                        async :false,
                        data:{"id":houseDeployId},
                        success: function(msg){
                            console.log(msg.data);
                            if(msg.data.bed==1)
                            {
                                $('input[value=1]').prop("checked", true);
                            }
                            if(msg.data.wifi==1)
                            {
                                $('input[value=2]').prop("checked", true);
                            }
                            if(msg.data.conditioner==1)
                            {
                                $('input[value=3]').prop("checked", true);
                            }
                            if(msg.data.wardrobe==1)
                            {
                                $('input[value=4]').prop("checked", true);
                            }
                            if(msg.data.desk==1)
                            {
                                $('input[value=5]').prop("checked", true);
                            }
                            if(msg.data.chair==1)
                            {
                                $('input[value=6]').prop("checked", true);
                            }
                            if(msg.data.sofa==1)
                            {
                                $('input[value=7]').prop("checked", true);
                            }
                            if(msg.data.refrigerator==1)
                            {
                                $('input[value=8]').prop("checked", true);
                            }
                            if(msg.data.washing==1)
                            {
                                $('input[value=9]').prop("checked", true);
                            }
                            if(msg.data.tv==1)
                            {
                                $('input[value=10]').prop("checked", true);
                            }
                            if(msg.data.heater==1)
                            {
                                $('input[value=11]').prop("checked", true);
                            }
                            if(msg.data.stove==1)
                            {
                                $('input[value=12]').prop("checked", true);
                            }
                            if(msg.data.microwave==1)
                            {
                                $('input[value=13]').prop("checked", true);
                            }
                            if(msg.data.lampblack==1)
                            {
                                $('input[value=14]').prop("checked", true);
                            }
                            if(msg.data.dining==1)
                            {
                                $('input[value=15]').prop("checked", true);
                            }
                            if(msg.data.lock==1)
                            {
                                $('input[value=16]').prop("checked", true);
                            }
                            if(msg.data.led==1)
                            {
                                $('input[value=17]').prop("checked", true);
                            }
                            form.render();
                        }
                    });
                    form.on('submit(checkBoxClick2)', function(data2){
                        //console.log(data2.field);
                        /*$('input[type=checkbox]:checked').each(function() {
                            arr_box.push($(this).val());
                        });*/
                        var obj = $("#formDeployClick").find('.layui-form-checked');
                        //console.log(obj);
                        obj.each(function () {
                            arr_box.push($(this).prev().val());
                        });
                        console.log(arr_box);
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/adminUpdateHouseDeploy",
                            data: {
                                "id":houseDeployId,
                                "ids":arr_box
                            },
                            traditional:true,
                            success: function(res){
                                //console.log(msg);
                                if(res.msg==1){
                                    layer.close(index);
                                    layer.msg('修改成功');
                                    setTimeout(function () {

                                        window.location.reload();

                                    }, 1000);
                                }
                            }
                        });


                        return false;
                    });
                }
                ,cancel:function(){
                    //右上角关闭回调

                    $('input[type=checkbox]').prop("checked",false);
                    form.render();
                    //return false 开启该代码可禁止点击该按钮关闭
                }
            });
        });

    }
</script>
</body>
</html>
