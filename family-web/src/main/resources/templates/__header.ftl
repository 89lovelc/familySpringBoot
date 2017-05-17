<header class="header white-bg">
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
    </div>
    <!--logo start-->
    <a href="index.ftl" class="logo">家庭<span>控制</span></a>
    <!--logo end-->
    <div class="top-nav ">
        <!--search & user info start-->
        <ul class="nav pull-right top-menu">
            <!-- user login dropdown start-->
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <span class="username">${Session.user.userName}</span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu extended logout">
                    <div class="log-arrow-up"></div>
                    <li><a href="${ctx}/fmr/person/profile"><i class=" fa fa-suitcase"></i>个人信息</a></li>
                    <li><a href="${ctx}/fmr/person/profile-edit"><i class="fa fa-cog"></i> 设置</a></li>
                    <li><a href="${ctx}/fmr/lock"><i class="fa fa-key"></i> 锁定</a></li>
                    <li><a href="${ctx}/login"><i class="fa fa-key"></i> 注销</a></li>
                </ul>
            </li>
            <!-- user login dropdown end -->
        </ul>
        <!--search & user info end-->
    </div>
</header>