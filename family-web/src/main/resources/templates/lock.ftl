<!DOCTYPE html>
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

    <title>Lock Screen</title>

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

    <script src="${ctx}/static/vue/vue.js" ></script>
    <script src="${ctx}/static/flatlab/js/jquery.js"></script>
</head>

<body class="lock-screen" onload="startTime()">

<div  id = "main-content" class="lock-wrapper">

    <div id="time"></div>

    <div class="lock-box text-center">
        <img id ="imgAvatar" width="85px" alt="lock avatar"/>
        <h1>{{user.userName}}</h1>
        <span class="locked">Locked</span>
        <form role="form" class="form-inline" action="${ctx}/fmr/index">
            <div class="form-group col-lg-12">
                <button class="btn btn-lock" type="submit">
                    <i class="fa fa-arrow-right"></i>
                </button>
            </div>
        </form>
    </div>
</div>
<script>
    function startTime()
    {
        var today=new Date();
        var h=today.getHours();
        var m=today.getMinutes();
        var s=today.getSeconds();
        // add a zero in front of numbers<10
        m=checkTime(m);
        s=checkTime(s);
        document.getElementById('time').innerHTML=h+":"+m+":"+s;
        t=setTimeout(function(){startTime()},500);
    }

    function checkTime(i)
    {
        if (i<10)
        {
            i="0" + i;
        }
        return i;
    }
    function initData(){
        var text = $.ajax({
            type : 'get',
            async:false,
            url :"${ctx}/user/userData",
            contentType: 'application/json',
        }).responseText;
        return JSON.parse(text);
    }

    new Vue({
        el:'#main-content',
        data:function () {
            return {
                user:''
            };
        },
        methods :{

        },
        created:function(){
            this.user = initData();
            $("#imgAvatar").attr("src","${ctx}/files/"+this.user.avatar);
        }
    });

</script>
</body>
</html>
