<aside>
    <div id="sidebar"  class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
            <li>
                <a id = "controlBar" href="${ctx}/fmr/index" >
                    <i class="fa fa-dashboard"></i>
                    <span>控制总台</span>
                </a>
            </li>

            <li  class="sub-menu">
                <a id="equipment"  href="javascript:;" >
                    <i class="fa fa-laptop"></i>
                    <span>设备管理</span>
                </a>
                <ul class="sub">
                    <li id = "raspberry"><a  href="${ctx}/fmr/raspberry/raspberry">树莓派管理</a></li>
                    <li id = "device"><a  href="${ctx}/fmr/device/device">硬件管理</a></li>
                    <li id ="scene"><a  href="${ctx}/fmr/scene/scene">模式管理</a></li>
                    <li id="camera"><a  href="${ctx}/fmr/camera/camera">摄像管理</a></li>
                </ul>
            </li>
            <li>
                <a  id = "profile" href="${ctx}/fmr/person/profile" >
                    <i class="fa fa-user"></i>
                    <span>个人中心</span>
                </a>
            </li>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>