<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>登录页</title>
    <link rel="stylesheet" href="<%=basePath%>/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/style.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jq22.css">
    <link rel="stylesheet" href="<%=basePath%>/css/iconfont.css">
    <style>
        .code {
            width: 100%;
            margin: 0 auto;
        }
        .input-val {
            width: 63%;
            background: #ffffff;
            height: 2.8rem;
            padding: 0 2%;
            border-radius: 5px;
            border: none;

            border: 1px solid rgba(0,0,0,.2);
            font-size: 0.9rem;
        }
        #canvas {
            float: right;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 5px;
            cursor: pointer;
        }
        .loginbtn{
            margin-left: 17px;
            margin-top: 20px;
        }
        .savebtn{
            width: 150px;
            border-radius: 5px;
            background-color:#8ABF3B ;
        }
        .resbtn{
            width: 150px;
            border-radius: 5px;
            background-color:#3BC9A2;
        }
        .iconfont{
            /*color: #8ECE8A;*/
            color: #8ABF3B;
        }
        .title{
            text-align:center;
            font-size: 12px;
        }
    </style>

</head>
<body>
<div id="login">
    <div class="wrapper">
        <div class="login">
            <form action="#" method="post" class="layui-form container offset1 loginform">
                <div id="owl-login">
                    <div class="hand"></div>
                    <div class="hand hand-r"></div>
                    <div class="arms">
                        <div class="arm"></div>
                        <div class="arm arm-r"></div>
                    </div>
                </div>
                <div class="pad">
                    <input type="hidden" name="_csrf" value="9IAtUxV2CatyxHiK2LxzOsT6wtBE6h8BpzOmk="/>
                    <div class="control-group">
                        <div class="controls">
                            <label for="userName" class="control-label"><i class="iconfont icon-user" aria-hidden="true"></i></label>
                            <input type="text" name="username" id="username" required lay-verify="required" placeholder="用户名" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label for="password" class="control-label"><i class="iconfont icon-mima" aria-hidden="true"></i></label>
                            <input type="password" name="password" id="password" required lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="control-group">
                        <div class="layui-row">
                            <div class="layui-col-xs8">
                                <label for="password" class="control-label"><i class="iconfont icon-yanzhengma" aria-hidden="true"></i></label>
                                <input type="text" name="vercode" id="vercode" required lay-verify="required" placeholder="图形验证码" class="layui-input">
                            </div>
                            <div class="layui-col-xs4">
                                <div style="margin-left: 15px">
                                    <canvas id="canvas" width="100" height="36"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class=" control-group login-btn  loginbtn">
                        <div class="layui-row">
                        <div class="layui-col-xs6">
                        <button lay-submit lay-filter="login" class="layui-btn savebtn">登录</button>
                        </div>
                        <div class="layui-col-xs6">
                            <button  class="layui-btn resbtn"><a href="register" ><font color="#FFFFFF"> 注册</font></a></button>
                        </div>
                        </div>
                    </div>
<%--                    <p><a href="register" class="fl">立即注册</a></p>--%>
                    <p></p>
                    <p class="title">会找房后台管理系统</p>
                    <%--        <a href="forget" class="fr">忘记密码？</a>--%>
                </div>

            </form>

        </div>
    </div>
</div>




<script src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
<script src="<%=basePath%>/layui/layui.js"></script>
<script type="text/javascript">
    var show_num=[];
    $(function()
    {
        $(function() {
            $('#login #password').focus(function() {
                $('#owl-login').addClass('password');
            }).blur(function() {
                $('#owl-login').removeClass('password');
            });

        });
        draw(show_num);
        $("#canvas").on('click',function()
        {
            draw(show_num);
        })
    });
    layui.use(['form','layer','jquery'], function () {

        // 操作对象
        var form = layui.form,
            $ = layui.jquery;




        form.on('submit(login)',function (data) {
            console.log(data.field);
            data = data.field;
            if (data.username == '') {
                layer.msg('用户名不能为空');
                return false;
            }
            if (data.password == '') {
                layer.msg('密码不能为空');
                return false;
            }
            var verificationCode = show_num.join("");
            if (data.vercode == '') {
                layer.msg('验证码不能为空');
                return false;
            } else if(data.vercode.toLowerCase() != verificationCode) {
                layer.msg('验证码输入错误');
                $("#canvas").click()
                return false;
            }
            var param = {"userName": $("#username").val(), "userPassword": $("#password").val()};
            $.ajax({
                url:'<%=basePath%>user/login',
                data: JSON.stringify(param),
                contentType: 'application/json',
                dataType: 'json',
                type:'post',
                success:function (data) {
                    if (data.status == 1){
                        if(data.type == 2){
                            window.location.href = "main";
                        }else{
                            window.location.href = "home";
                        }
                    }else{
                        layer.msg('登录名或密码错误');
                    }
                }
            })
            return false;
        })
    });
    function draw(show_num) {
        var canvas_width = $('#canvas').width();
        var canvas_height = $('#canvas').height();
        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
        canvas.width = canvas_width;
        canvas.height = canvas_height;
        var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
        var aCode = sCode.split(",");
        var aLength = aCode.length;//获取到数组的长度

        for (var i = 0; i <= 3; i++) {
            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
            var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
            var txt = aCode[j];//得到随机的一个内容
            show_num[i] = txt.toLowerCase();
            var x = 10 + i * 20;//文字在canvas上的x坐标
            var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
            context.font = "bold 23px 微软雅黑";

            context.translate(x, y);
            context.rotate(deg);

            context.fillStyle = randomColor();
            context.fillText(txt, 0, 0);

            context.rotate(-deg);
            context.translate(-x, -y);
        }
        for (var i = 0; i <= 5; i++) { //验证码上显示线条
            context.strokeStyle = randomColor();
            context.beginPath();
            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.stroke();
        }
        for (var i = 0; i <= 30; i++) { //验证码上显示小点
            context.strokeStyle = randomColor();
            context.beginPath();
            var x = Math.random() * canvas_width;
            var y = Math.random() * canvas_height;
            context.moveTo(x, y);
            context.lineTo(x + 1, y + 1);
            context.stroke();
        }
    }

    function randomColor() {//得到随机的颜色值
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }

</script>
</body>
</html>
