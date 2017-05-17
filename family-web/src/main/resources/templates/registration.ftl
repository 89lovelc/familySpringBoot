<#assign ctx= request.contextPath/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">
    <title>智能家居</title>
    <#include "__css.ftl">
</head>

<body class="login-body">

<div class="container">

    <form class="form-signin" action="index.html">
        <h2 class="form-signin-heading">注册</h2>
        <div class="login-wrap">
            <p>请填写个人信息</p>
            <input type="text" class="form-control" placeholder="邮箱" autofocus>
            <input type="text" class="form-control" placeholder="电话" autofocus>
            <input type="text" class="form-control" placeholder="生日" autofocus>

            <p> Enter your account details below</p>
            <input type="text" class="form-control" placeholder="昵称" autofocus>
            <input type="password" class="form-control" placeholder="密码">
            <input type="password" class="form-control" placeholder="再次确认密码">
            <button class="btn btn-lg btn-login btn-block" type="submit">提交</button>

            <div class="registration">
                已经注册
                <a class="" href="${ctx}/login">
                    登录
                </a>
            </div>

        </div>

    </form>

</div>

<script>
    var vue =  new Vue({
        el:'#main-content',
        data:function () {
            return {
                user:{
                    userId:'',
                    userName:'',
                    user
                }
            }
        },
        methods :{
        },
        created:function(){
        }
    });

</script>

</body>
</html>
