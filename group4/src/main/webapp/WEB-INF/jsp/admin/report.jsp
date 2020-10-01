<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>举报信息查看</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<form class="layui-form" action="" id="formSelect" lay-filter="select" style="width:250px;display: inline-block">
    <div class="layui-form-item">
        <label class="layui-form-label" >查询方式:</label>
        <div class="layui-input-block" >
            <select name="city" lay-verify="required" lay-filter="selectfilter">
                <option value="0">举报用户昵称</option>
                <option value="1">房东昵称</option>
            </select>
        </div>
    </div>
</form>
<div class="demoTable " id="dr" style="text-align:left;display: inline-block">

    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off" placeholder="请输入查询内容">
    </div>
    <button id="reloadbutton" class="layui-btn" data-type="reload">查询</button>
</div>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script src="<%=basePath%>/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="update">审核</a>
</script>
<script type="text/html" id="f1">
    <div>{{createFormat(d.user.userName)}}</div>
</script>
<script type="text/html" id="r1">
    <a class="layui-btn layui-btn-xs" lay-event="detail">举报详情</a>
</script>
<script>
    function createFormat(o){
        return o;
    };
    layui.use(['table','form'], function () {
        var table = layui.table
        ,form = layui.form;

        table.render({
            elem: '#test'
            , url: '<%=basePath%>/report/reportMessage'
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , page: true
            , cols: [[
                {field: 'id', width: 80, title: '举报ID', fixed: 'left'}
                , {width: 180, title: '举报用户昵称',templet:'#f1'}
                , {width: 180, title: '举报用户联系方式',templet:'<div>{{createFormat(d.user.tel)}}</div>'}
                , {width: 180, title: '房东昵称',templet:'<div>{{createFormat(d.house.call)}}</div>'}
                , {width: 180, title: '房东联系方式',templet:'<div>{{createFormat(d.house.tel)}}</div>'}
                , {field: 'reportReason', width: 180, width: '15%',title: '举报标题'}
                , {field: '', title: '举报详情', width: '10%', minWidth: 100,toolbar: '#r1'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {
                    field: 'reportStatus', title: '举报状态', width: 100,
                    templet: function (d) {
                        if (d.reportStatus == '0') return '<span style="color:red">未审核</span>'
                        else return '<span style="color:green">已审核</span>'
                    }
                }
                , {field: '', title: '操作', toolbar: '#bar', align: 'center', fixed: 'right'}
            ]]
            , id: 'testReload'
        });
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            if (layEvent === 'update') { //更改
                    $.ajax({
                          type:"put",
                        url:"<%=basePath%>/report/updateReportById/"+data.id,
                        contentType:"application/json",
                        dataType:"json",
                        success:function(res) {
                            if (res.status == 1) {
                                layer.msg("审核成功");
                            setTimeout(function(){
                                window.location.reload();
                            },1000);

                        }else{
                                layer.msg('审核失败');
                            }
                        }
                        }
                    )

            }
            if(layEvent === 'detail'){
                alert(data.reportDetails);
            }
        });
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
                    url:"<%=request.getContextPath()%>/report/selectReportBy",
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

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

</body>
</html>