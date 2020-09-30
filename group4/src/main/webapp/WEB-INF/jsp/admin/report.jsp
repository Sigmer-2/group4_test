<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="demoTable">
    搜索ID：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script src="<%=basePath%>/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="update">审核</a>
</script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: '#test'
            , url: '<%=basePath%>/report/reportMessage'
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , page: true
            , cols: [[
                {field: 'id', width: 80, title: 'ID', fixed: 'left'}
                , {field: 'reportUserId', width: 180, title: '举报用户编号'}
                , {field: 'reportHouseId', width: 180, title: '被举报房间编号'}
                , {field: 'reportReason', width: 180, title: '举报原因'}
                , {field: 'reportDetails', title: '举报详情', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {
                    field: 'reportStatus', title: '举报状态', width: 100,
                    templet: function (d) {
                        if (d.reportStatus == '0') return '<span style="color:red">未审核</span>'
                        else return '<span style="color:green">已审核</span>'
                    }
                }
                , {field: '', title: '操作', toolbar: '#bar', align: 'center', fixed: 'right'}
            ]]
        });
        var $ = layui.$, active = {
            reload: function () {
                var demoReload = $('#demoReload');

                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        key: {
                            id: demoReload.val()
                        }
                    }
                }, 'data');
            }
        };

        $('#test .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            console.log(data);
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            if (layEvent === 'update') { //更改
                    $.ajax({
                          type:"post",
                        url:"<%=basePath%>/report/updateReportById/"+data.id,
                        contentType:"application/json",
                        dataType:"json",
                        success:function(res) {
                            console.log(res.status);
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
        });
    });
</script>

</body>
</html>