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
    <#include "../__css.ftl">
</head>

<body>

<section id="container" class="">
    <!--header start-->
    <#include "../__header.ftl">
    <!--header end-->
    <!--sidebar start-->
    <#include "../__sidebar.ftl">
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <!-- page start-->
            <div class="row">
                <aside class="profile-nav col-lg-3">
                    <section class="panel">
                        <div class="user-heading round">
                            <a href="#">
                                <img id="imgAvatar"  alt="">
                            </a>
                            <h1>{{user.userName}}</h1>
                            <p>{{user.email}}</p>
                        </div>

                        <ul class="nav nav-pills nav-stacked">
                            <li class="active"><a href="${ctx}/fmr/person/profile"> <i class="fa fa-user"></i> 个人信息</a></li>
                            <li><a href="${ctx}/fmr/person/profile-edit"> <i class="fa fa-edit"></i> 编辑个人信息</a></li>
                        </ul>

                    </section>
                </aside>
                <aside class="profile-info col-lg-9">
                    <section class="panel">
                        <div class="bio-graph-heading">
                            Success is the ability to go from failure to failure without losing your enthusiasm.
                        </div>
                        <div class="panel-body bio-graph-info">
                            <h1>详细信息</h1>
                            <div class="row">
                                <div class="bio-row">
                                    <p>姓 名 : {{user.userName}}</p>
                                </div>
                                <div class="bio-row">
                                    <p><span> </span></p>
                                </div>
                                <div class="bio-row">
                                    <p>生 日: {{user.birthday}}</p>
                                </div>
                                <div class="bio-row">
                                    <p>邮 箱 :{{user.email}}</p>
                                </div>
                                <div class="bio-row">
                                    <p>电 话 :{{user.tel}}</p>
                                </div>
                            </div>
                        </div>
                    </section>
                </aside>
            </div>

            <!-- page end-->
        </section>
    </section>
    <!--main content end-->


</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="${ctx}/static/flatlab/js/jquery.js"></script>
<script src="${ctx}/static/flatlab/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="${ctx}/static/flatlab/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${ctx}/static/flatlab/js/jquery.scrollTo.min.js"></script>
<script src="${ctx}/static/flatlab/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${ctx}/static/flatlab/assets/jquery-knob/js/jquery.knob.js"></script>
<script src="${ctx}/static/flatlab/js/respond.min.js" ></script>


<!--common script for all pages-->
<script src="${ctx}/static/flatlab/js/common-scripts.js"></script>

<script>

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

<script>
    //knob
    $(".knob").knob();

    $("#profile").addClass("active");
</script>


</body>
</html>
