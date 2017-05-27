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
      <script  src="${ctx}/static/element-ui/element-ui.min.js"></script>
      <link  rel="stylesheet" href = "${ctx}/static/element-ui/element-ui.min.css"/>
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
                  <div class="col-lg-4">
                      <div class="row">
                          <div class="col-xs-12">
                              <section class="panel">
                                  <header class="panel-heading">
                                      情景模式模块
                                      <button type="button" @click="addElement()" class="btn btn-info">添加</button>
                                  </header>
                                  <div class="panel-body">
                                      <div class="table-responsive">
                                          <el-table
                                                  ref="singleTable"
                                          :data="scenes"
                                                  highlight-current-row
                                                  style="width: 100%">
                                              <el-table-column
                                                      property="sceneName"
                                                      label="名称"
                                                      width="120">
                                              </el-table-column>
                                              <el-table-column
                                                      property="userName"
                                                      label="创建者">
                                              </el-table-column>
                                              <el-table-column
                                                      label="操作"
                                                      inline-template >
                                                  <div>
                                                      <el-button type="info" size="mini" icon="edit" @click.native="clickEdit(row)"></el-button>
                                                      <el-button type="danger" size="mini" icon="delete" @click.native="clickDelete(row)"></el-button>
                                                  </div>
                                              </el-table-column>
                                          </el-table>
                                      </div>
                                  </div>
                              </section>
                          </div>
                      </div>
                  </div>
                  <div class="col-lg-8">
                      <section class="panel">
                          <header class="panel-heading">
                              编辑模块
                          </header>
                          <div class="panel-body">
                              <form role="form">
                                  <div class="form-group">
                                      <label for="exampleInputEmail1">情景名称</label>
                                      <input  v-model ="scene.sceneName" class="form-control" >
                                  </div>
                                  <div class="form-group">
                                      <button type="button" @click="openModel()" class="btn btn-default">添加设备</button>
                                  </div>
                                  <div class="form-group" v-for="(p,index) in scene.stepList">
                                      <label >设备名称：{{p.equipmentName}}    内容：{{p.content}}</label>
                                      <button type="button" class="btn btn-danger btn-sm" @click = "deleteEquipemt(index)">删除</button>
                                  </div>
                                  <button type="button" class="btn btn-info" @click = "savePo()">保存</button>
                              </form>
                          </div>
                      </section>
                  </div>
              </div>
            </section>

          <div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                          <h4 class="modal-title">设备添加</h4>
                      </div>
                      <div class="modal-body">
                          <form role="form">
                              <div class="form-group">
                                  <label for="exampleInputEmail1">设备名称</label>
                                  <el-select v-model="equipment.equipment" placeholder="请选择">
                                      <el-option
                                              v-for="item in equipments"
                                              :label="item.equipmentName"
                                              :value="item">
                                      </el-option>
                                  </el-select>
                              </div>
                              <div class="form-group">
                                  <label >内容</label>
                                  <input class="form-control" v-model="equipment.content">
                              </div>
                          </form>
                      </div>
                      <div class="modal-footer">
                          <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                          <button class="btn btn-success" type="button" @click="saveEquipment()">保存修改</button>
                      </div>
                  </div>
              </div>
          </div>
          <#include  "../confirmModal.ftl">

      <!--main content end-->
  </section>
  </section>
  <#include "../__comom.ftl">
  <script>
      var userName = "${Session.user.userName}";
      function getData(url,type,data){
          var text = $.ajax({
              type : type,
              data:data,
              async:false,
              url :"${ctx}"+url,
              contentType: 'application/json',
          }).responseText;
          return JSON.parse(text);
      }

    var equip ={
        equipment:'',
        content:'',
    };
      var s = {
          sceneId:'',
          sceneName:'',
          userName:userName,
          stepList:[]
      }

      new Vue({
          el:'#main-content',
          data:function () {
              return {
                  equipments:[],
                  equipment:$.extend({},equip),
                  scene:$.extend({},s),
                  scenes:[],
                  temp:''
              };
          },
          methods :{
              confirmModal:function () {
                  $("#confirmModal").modal("hide");
                  var num =  -1;
                  console.log(this.temp);
                  $.ajax({
                      type : 'get',
                      data:'',
                      async:false,
                      url :"${ctx}/scene/delete/"+this.temp.sceneId,
                      contentType: 'application/json',
                  });
                  for(var i = 0 ; i < this.scenes.length ; i ++){
                      if( this.scenes[i].sceneId == this.temp.sceneId){
                          break;
                      }
                  }
                  this.scenes.splice(i,1);
                  this.scene = $.extend({},s);
              },
              clickDelete:function (row) {
                  $("#confirmModal").modal("show");
                  this.temp =row;
              },
              addElement:function () {
                  this.scene = $.extend({},s);
              },
              clickEdit:function (po) {
                    this.scene = po;
              },
              saveEquipment:function () {
                  this.scene.stepList.push({
                                                equipmentName:this.equipment.equipment.equipmentName,
                                                content:this.equipment.content,
                                                equipmentId:this.equipment.equipment.equipmentId
                                            });
                  $('#myModal').modal('hide');
              },
              deleteEquipemt:function (index) {
                  this.scene.stepList.splice(index,1);
              },
              editPo:function (po) {
                  this.equipment = po;
                  $('#myModal').modal('show');
              },
              savePo:function () {
                  var _self = this;
                  console.log(this.scene);
                  $.ajax({
                      type:'post',
                      async:true,
                      data:JSON.stringify(_self.scene),
                      url:'${ctx}/scene/save',
                      contentType: 'application/json',
                      success:function(data){
                          if(_self.scene.sceneId == ''){
                              _self.scenes.push(_self.scene);
                          }
                          _self.scene = $.extend({},s);
                      }
                  });
              },
              openModel:function () {
                  this.equipment = $.extend({},equip) ;
                  $('#myModal').modal('show');
              }
          },
          created:function(){
              this.equipments = getData("/equipment/search/listAll",'get',{})._embedded.equipmentPoes;
              this.scenes = getData("/scene/listAll","get",{});
              console.log(this.scenes);
          }
      });
  </script>

  <script>
      $("#equipment").addClass("active");
      $("#scene").addClass("active");
  </script>
  </body>
</html>
