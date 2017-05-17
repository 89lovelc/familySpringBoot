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

    <title>Profile Edit</title>

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
                                  <img id ="imgAvatar" alt="">
                              </a>
                              <h1>{{user.userName}}</h1>
                              <p>{{user.email}}</p>
                          </div>

                          <ul class="nav nav-pills nav-stacked">
                              <li ><a href="${ctx}/fmr/person/profile"> <i class="fa fa-user"></i> 个人信息</a></li>
                              <li class="active"><a href="${ctx}/fmr/person/profile-edit"> <i class="fa fa-edit"></i> 编辑个人信息</a></li>
                          </ul>

                      </section>
                  </aside>
                  <aside class="profile-info col-lg-9">
                      <section class="panel">
                          <div class="bio-graph-heading">
                              Success is the ability to go from failure to failure without losing your enthusiasm.
                          </div>
                          <div class="panel-body bio-graph-info">
                              <h1> 个人信息设置</h1>
                              <form class="form-horizontal" role="form">
                                  <div class="form-group">
                                      <label  class="col-lg-2 control-label">昵称</label>
                                      <div class="col-lg-6">
                                          <input type="text" class="form-control" v-model = "user.userName" id="f-name" placeholder=" ">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label  class="col-lg-2 control-label">电话</label>
                                      <div class="col-lg-6">
                                          <input type="text" class="form-control" v-model = "user.tel" id="l-name" placeholder=" ">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label  class="col-lg-2 control-label">邮箱</label>
                                      <div class="col-lg-6">
                                          <input type="text" class="form-control"   v-model = "user.email" id="c-name" placeholder=" ">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label  class="col-lg-2 control-label">生日</label>
                                      <div class="col-lg-6">
                                          <input type="text" class="form-control" v-model = "user.birthday"  id="b-day" placeholder=" ">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <div class="col-lg-offset-2 col-lg-10">
                                          <button type="button" @click="savePo" class="btn btn-success">保存</button>
                                      </div>
                                  </div>
                              </form>
                          </div>
                      </section>
                      <section>
                          <div class="panel panel-primary">
                              <div class="panel-heading"> 设置新密码</div>
                              <div class="panel-body">
                                  <form class="form-horizontal" role="form">
                                      <div class="form-group">
                                          <label  class="col-lg-2 control-label">新密码</label>
                                          <div class="col-lg-6">
                                              <input type="password" class="form-control" v-model = "pwd"  >
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label  class="col-lg-2 control-label">再次输入新密码</label>
                                          <div class="col-lg-6">
                                              <input type="password" class="form-control" v-model = "password"  >
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <div class="col-lg-offset-2 col-lg-10">
                                              <button type="button" @click = "changePwd()"  class="btn btn-info">保存</button>
                                          </div>
                                      </div>
                                  </form>
                              </div>
                          </div>
                      </section>
                      <section>
                          <div class="panel panel-primary">
                              <div class="panel-heading"> 设置头像</div>
                              <div class="panel-body">
                                  <form class="form-horizontal" method="post" enctype="multipart/form-data" action="${ctx}/upload/avatar" >
                                      <div class="form-group">
                                          <label  class="col-lg-2 control-label">头像</label>
                                          <div class="col-lg-6">
                                              <input type="file" name="file" class="file-pos" >
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <div class="col-lg-offset-2 col-lg-10">
                                              <button type="submit" class="btn btn-info">保存</button>
                                          </div>
                                      </div>
                                  </form>
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
                  user:'',
                  password:'',
                  pwd:''
              };
          },
          methods :{
              savePo:function () {
                  $.ajax({
                      type : 'post',
                      async:false,
                      data:JSON.stringify(this.user),
                      url :"${ctx}/user/saveProfile",
                      contentType: 'application/json',
                      success:function(data){
                          window.location.href = "${ctx}/fmr/person/profile-edit"
                      }
                  })
              },
              changePwd:function () {
                  var _self = this;
                  var pwd = _self.pwd;
                  if(this.password ==  this.pwd){
                      $.ajax({
                          type : 'post',
                          async:true,
                          data:JSON.stringify(pwd),
                          url :"${ctx}/user/changePwd",
                          contentType: 'application/json',
                          success:function(data){
                              alert("成功");

                          }
                      })
                      _self.password  = '';
                      _self.pwd = '';
                  }else{
                      alert("两次输入密码不同");
                      this.password  = '';
                      this.pwd = '';
                  }
              }
          },
          created:function(){
              this.user =   initData();
              $("#imgAvatar").attr("src","${ctx}/files/"+this.user.avatar);
          }
      });


  </script>

  <script>
      $("#profile").addClass("active");
  </script>

  </body>
</html>
