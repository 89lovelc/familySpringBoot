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
    <script src="${ctx}/static/flatlab/js/jquery.js"></script>
</head>

<body class="login-body">

<div class="container" id = "main-content">

    <form class="form-signin" >
        <h2 class="form-signin-heading">注册</h2>
        <div class="login-wrap">
            <p>请填写个人信息</p>
            <input type="text" v-model ="user.email" class="form-control" placeholder="邮箱" autofocus>
            <input type="text" v-model ="user.tel" class="form-control" placeholder="电话" autofocus>
            <input type="text" v-model ="user.birthday" class="form-control" placeholder="生日" autofocus>

            <p>详情</p>
            <input type="text" v-model = "user.userName" class="form-control" placeholder="昵称" autofocus>
            <input type="password" v-model ="user.userPassword" class="form-control" placeholder="密码">
            <input type="password" v-model="pwd" class="form-control" placeholder="再次确认密码">
            <button class="btn btn-lg btn-login btn-block" @click = "savePo()" type="button">提交</button>

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
                    email:'',
                    birthday:'',
                    tel:'',
                    userPassword:''
                },
                pwd:''
            }
        },
        methods :{
            savePo:function () {
                if(this.user.userPassword == this.pwd){
                   $.ajax({
                        type : 'post',
                        async:true,
                        data:JSON.stringify(this.user),
                        url :"${ctx}/user",
                        contentType: 'application/json',
                        success:function (data) {
                            alert("注册成功！");
                            window.location.href = "${ctx}/login"
                        }
                    });
                }else{
                    alert("密码不同！");
                }
            }
        },
        created:function(){
        }
    });

</script>

</body>
</html>
