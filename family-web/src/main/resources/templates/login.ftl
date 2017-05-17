<!DOCTYPE html>
<#assign ctx= request.contextPath/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">

    <title>登录界面</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/static/flatlab/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/flatlab/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${ctx}/static/flatlab/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="${ctx}/static/flatlab/css/style.css" rel="stylesheet">
    <link href="${ctx}/static/flatlab/css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="${ctx}/static/flatlab/js/html5shiv.js"></script>
    <script src="${ctx}/static/flatlab/js/respond.min.js"></script>
    <![endif]-->
</head>

  <body class="login-body">

    <div class="container">

      <form class="form-signin" method="post" action="${ctx}/user/login">
        <h2 class="form-signin-heading">智能家居</h2>
        <div class="login-wrap">
            <input type="text" name="userName" class="form-control" placeholder="用户名" autofocus>
            <input type="password" name="password" class="form-control" placeholder="密码">
             <#if  message ??>
                用户不存在或者密码不正确
            </#if>
            <button class="btn btn-lg btn-login btn-block" type="submit">登录</button>
            <div class="registration">
                没有账号么?
                <a class="" href="${ctx}/fmr/registration">
                    创建账号
                </a>
            </div>
        </div>
      </form>
    </div>
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="${ctx}/static/flatlab/js/jquery.js"></script>
    <script src="${ctx}/static/flatlab/js/bootstrap.min.js"></script>


  </body>
</html>
