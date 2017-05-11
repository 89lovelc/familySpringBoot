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
                              硬件设备
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
                                  <th>所属树莓派</th>
                                  <th>硬件名称</th>
                                  <th>硬件类型</th>
                                  <th>硬件gpios</th>
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody id = "tbody">
                              <tr v-for = "po in pos">
                                  <td>{{ po.raspberryPo.raspberryName }}</td>
                                  <td>{{ po.equipmentName }}</td>
                                  <td >{{ po.equipmentType }}</td>
                                  <td>{{po.equipmentGpios}}</td>
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
                          <h4 class="modal-title">硬件管理</h4>
                      </div>
                      <div class="modal-body">
                          <form role="form">
                              <div class="form-group">
                                  <label for="exampleInputEmail1">硬件名称名称</label>
                                  <input v-model = "equipment.equipmentName" class="form-control" placeholder="名称">
                              </div>
                              <div class="form-group">
                                  <label for="exampleInputPassword1">硬件类型</label>
                                  <#--<input v-model = "equipment.equipmentType" class="form-control" placeholder="xxx.xxx.xxx.xxx">-->
                                  <select v-model = "equipment.equipmentType" class="form-control m-bot15">
                                      <option value = "开关" >开关</option>
                                      <option value = "步进电机">步进电机</option>
                                      <option value = "继电器">继电器</option>
                                      <option value = "待定">待定</option>
                                      <option value = "待定">待定</option>
                                  </select>
                              </div>
                              <div class="form-group">
                                  <label for="exampleInputPassword1">所属树莓派</label>
                                  <select v-model = "equipment.raspberryId" class="form-control m-bot15">
                                      <option v-for = "r in rasps" :value="r.raspberryId" >{{r.raspberryName}}</option>
                                  </select>

                              </div>
                              <div class="form-group">
                                  <label for="exampleInputPassword1">gpio口</label>
                                  <input v-model = "equipment.equipmentGpios" class="form-control" placeholder="xxx|xxx|xxx|xxx">
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
      </section>
      <!--main content end-->
  </section>
  <#include "../__comom.ftl">
  <script>
      function initData(){
          var text = $.ajax({
              type : 'get',
              async:false,
              url :"${ctx}/equipment/getData",
              contentType: 'application/json',
          }).responseText;
          return JSON.parse(text);
      }

      function raspAll(){
          var text = $.ajax({
              type : 'get',
              async:false,
              url :"${ctx}/rasp/search/listAll",
              contentType: 'application/json',
          }).responseText;
          return JSON.parse(text);
      }



      var equip  ={
          equipmentId:'',
          equipmentName:'',
          equipmentType:'',
          equipmentGpios:'',
          raspberryId:''
      };

      new Vue({
          el:'#main-content',
          data:function () {
              return {
                  pos:[],
                  equipment:$.extend({},equip),
                  rasps:[]
              };
          },
          methods :{
              deletePo:function (po) {
                  var _self = this;
                  $.ajax({
                      type:'delete',
                      async:true,
                      url:'${ctx}/equipment/'+po.equipmentId,
                      contentType: 'application/json',
                      success:function(data){
                          _self.pos = initData();
                      }
                  });
              },
              editPo:function (po) {
                  this.equipment = po;
                  $('#myModal').modal('show');
              },
              savePo:function () {
                  var _self = this;
                  $.ajax({
                      type:'post',
                      async:true,
                      url:'${ctx}/equipment/',
                      data:JSON.stringify(this.equipment),
                      contentType: 'application/json',
                      success:function(data){
                          $('#myModal').modal('hide');
                          _self.pos = initData();
                      }
                  });
              },
              openModel:function () {
                  this.equipment = $.extend({},equip);
                  $('#myModal').modal('show');
              }
          },
          created:function(){
              this.pos = initData();
              this.rasps = raspAll()._embedded.raspberryPoes;

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
      $("#device").addClass("active");
  </script>
  </body>
</html>
