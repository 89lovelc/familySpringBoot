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
    <#include "__css.ftl">
  </head>

  <body>

  <section id="container" >
      <!--header start-->
      <#include "__header.ftl">
      <!--header end-->
      <!--sidebar start-->
      <#include "__sidebar.ftl">
      <!--sidebar end-->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <!--state overview start-->
              <div class="row state-overview">
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol terques">
                              <i class="fa fa-home"></i>
                          </div>
                          <div class="value">
                              <h1 class="count">
                                  {{count}}
                              </h1>
                              <p>室内温度 </p>
                          </div>
                      </section>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol red">
                              <i class="fa fa-home"></i>
                          </div>
                          <div class="value">
                              <h1 class=" count2">
                                  {{count1}}
                              </h1>
                              <p>室内湿度</p>
                          </div>
                      </section>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol yellow">
                              <i class="fa fa-cloud"></i>
                          </div>
                          <div class="value">
                              <h1 class=" count3">
                                  {{count2}}
                              </h1>
                              <p>室外温度</p>
                          </div>
                      </section>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol blue">
                              <i class="fa fa-cloud"></i>
                          </div>
                          <div class="value">
                              <h1 class=" count4">
                                  {{count3}}
                              </h1>
                              <p>室外湿度</p>
                          </div>
                      </section>
                  </div>
              </div>

              <div class="row">
                  <div class="col-lg-4">
                      <section class="panel">
                          <header class="panel-heading">
                              开关类
                          </header>
                          <div class="panel-body">
                              <table class="table table-striped table-advance table-hover">
                                  <thead>
                                  <tr>
                                      <th>硬件名称</th>
                                      <th>状态</th>
                                  </tr>
                                  </thead>
                                  <tbody id = "tbody">
                                  <tr v-for = "p in switchPo" >
                                      <td>{{p.equipmentName}}</td>
                                      <td>
                                          <div class="switch switch-square" @click = "switchChange(p)"
                                               data-on-label="<i class=' fa fa-check'></i>"
                                               data-off-label="<i class='fa fa-times'></i>">
                                              <input type="checkbox" id = "hh" :checked="p.status"/>
                                          </div>
                                      </td>
                                  </tr>
                                  </tbody>
                              </table>
                          </div>
                      </section>
                  </div>
                  <div class="col-lg-4">
                      <section class="panel">
                          <header class="panel-heading">
                              步进电机
                          </header>
                          <div class="panel-body">
                          </div>
                      </section>
                  </div>
                  <div class="col-lg-4">
                      <section class="panel">
                          <header class="panel-heading">
                              摄像头
                          </header>
                          <div class="panel-body">
                          </div>
                      </section>
                  </div>
              </div>
              <!--state overview end-->
          </section>
      </section>
      <!--main content end-->


  </section>

    <#include "__comom.ftl">
    <!--script for this page-->
    <script src="${ctx}/static/flatlab/js/sparkline-chart.js"></script>
    <script src="${ctx}/static/flatlab/js/easy-pie-chart.js"></script>
    <script src="${ctx}/static/flatlab/js/count.js"></script>


  <!--custom switch-->
  <script src="${ctx}/static/flatlab/js/bootstrap-switch.js"></script>
  <!--custom tagsinput-->
  <script src="${ctx}/static/flatlab/js/jquery.tagsinput.js"></script>
  <!--custom checkbox & radio-->
  <script type="text/javascript" src="${ctx}/static/flatlab/js/ga.js"></script>


  <script>
    function countUp(count,vue,str)
    {
        var div_by = 100,
                speed = Math.round(count / div_by),
                run_count = 1,
                int_speed = 24;

        var int = setInterval(function() {
            if(run_count < div_by){
                vue[str] = speed * run_count;
                run_count++;
            } else if(vue[str] < count) {
                var curr_count = vue[str]  + 1;
                vue[str]  = curr_count;
            } else {
                clearInterval(int);
            }
        }, int_speed);
    }

      function switchStatus(){
          var text = $.ajax({
              type : 'get',
              async:false,
              url :"${ctx}/equipment/swithStatus",
              contentType: 'application/json',
          }).responseText;
          return JSON.parse(text);
      }

     var vue =  new Vue({
          el:'#main-content',
          data:function () {
              return {
                  switchPo:[],
                  count:0,
                  count1:0,
                  count2:0,
                  count3:0
              }
          },
          methods :{
              switchChange:function (p) {
                  p.status = $('#hh').is(':checked');
                  var text = $.ajax({
                      type : 'post',
                      async:true,
                      data:JSON.stringify(p),
                      url :"${ctx}/equipment/switch/operate",
                      contentType: 'application/json',
                      success:function (data) {
                          if(data == "false"){
                              alert("操作失败");
                          }
                      }
                  });
              },
          },
          created:function(){
//              this.switchPo = switchStatus();
              countUp(32,this,"count");
              countUp(22,this,"count1");
              countUp(36,this,"count2");
              countUp(44,this,"count3");
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
      $("#controlBar").addClass("active");
  </script>
  </body>
</html>
