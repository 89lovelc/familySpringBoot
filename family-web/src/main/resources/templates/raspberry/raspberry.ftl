<!DOCTYPE html>
<#assign ctx= request.contextPath/>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>家庭控制</title>
    <#include "../__css.ftl">
  </head>
  <body>

  <section id="container" >
      <!--header start-->
      <#include "../__header.ftl">
      <!--header end-->
      <!--sidebar start-->
      <#include "../__sidebar.ftl">
      <!--sidebar end-->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                              树莓派管理
                          </header>
                          <div class="panel-body">
                              <div class="adv-table editable-table ">
                              <div class="clearfix">
                                  <div class="btn-group">
                                      <button id="editable-sample_new" class="btn green" data-toggle="modal" @click = "openModel()">
                                           添加新设备<i class="fa fa-plus"></i>
                                      </button>
                                  </div>
                              </div>
                              <div class="space15"></div>
                                  <div class="table-responsive">
                                         <table class="table table-striped table-advance table-hover">
                              <thead>
                              <tr>
                                  <th>树莓派名字</th>
                                  <th>树莓派IP及端口</th>
                                  <th>是否连接</th>
                                  <th>管理设备数量</th>
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody id = "tbody">
                              <tr v-for = "po in pos">
                                  <td>{{ po.raspberryName }}</td>
                                  <td >{{ po.raspberryIp }}</td>
                                  <td>{{po.isConnected}}</td>
                                  <td>{{po.count}}</td>
                                  <td>
                                      <button class="btn btn-primary btn-xs" @click="editPo(po)" ><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"  @click="deletePo(po)"   ><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              </tbody>
                          </table>
                                  </div>
                          </div>
                      </section>
                  </div>
          </section>
          <div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                          <h4 class="modal-title">树莓派管理</h4>
                      </div>
                      <div class="modal-body">
                          <form role="form">
                              <div class="form-group">
                                  <label for="exampleInputEmail1">树莓派名称</label>
                                  <input v-model = "raspberry.raspberryName" class="form-control" placeholder="名称">
                              </div>
                              <div class="form-group">
                                  <label for="exampleInputPassword1">树莓派IP及端口</label>
                                  <input v-model = "raspberry.raspberryIp" class="form-control" placeholder="xxx.xxx.xxx.xxx">
                              </div>
                          </form>
                      </div>
                      <div class="modal-footer">
                          <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                          <button class="btn btn-success" type="button" @click="savePo()">保存修改</button>
                      </div>
                  </div>
              </div>
          </div>
          <#include "../confirmModal.ftl">
      </section>
      <!--main content end-->
  </section>
  <#include "../__comom.ftl">
  <script>
      function initData(){
          var text = $.ajax({
              type : 'get',
              async:false,
              url :"${ctx}/raspberry/getData",
              contentType: 'application/json',
          }).responseText;
          return JSON.parse(text);
      }

      var rasp = {
          raspberryId:'',
          raspberryName :'',
          raspberryIp:''
      }

      new Vue({
          el:'#main-content',
          data:function () {
              return {
                  pos:[],
                  raspberry:$.extend({},rasp),
                  temp:''
              };
          },
          methods :{
              confirmModal:function () {
                  $("#confirmModal").modal("hide");
                  var _self = this;
                  $.ajax({
                      type:'delete',
                      async:true,
                      url:'${ctx}/rasp/'+_self.temp.raspberryId,
                      contentType: 'application/json',
                      success:function(data){
                          _self.pos = initData();
                      }
                  });
              },
              deletePo:function (po) {
                  $("#confirmModal").modal("show");
                  this.temp = po;
              },
              editPo:function (po) {
                  this.raspberry = po;
                  $('#myModal').modal('show');
              },
              savePo:function () {
                  var _self = this;
                  $.ajax({
                      type:'post',
                      async:true,
                      url:'${ctx}/rasp/',
                      data:JSON.stringify(this.raspberry),
                      contentType: 'application/json',
                      success:function(data){
                          $('#myModal').modal('hide');
                          _self.pos = initData();
                      }
                  });
              },
              openModel:function () {
                  this.raspberry = $.extend({},rasp);
                  $('#myModal').modal('show');
              }
          },
          created:function(){
              this.pos = initData();
          }
      });
  </script>

  <script>
      //owl carousel
      $(document).ready(function() {
          $("#owl-demo").owlCarousel({
              navigation : true,
              slideSpeed : 300,
              paginationSpeed : 400,
              singleItem : true,
			  autoPlay:true
          });
      });
      //custom select box
      $(function(){
          $('select.styled').customSelect();
      });

      $(window).on("resize",function(){
          var owl = $("#owl-demo").data("owlCarousel");
          owl.reinit();
      });
      $("#equipment").addClass("active");
      $("#raspberry").addClass("active");
  </script>
  </body>
</html>
