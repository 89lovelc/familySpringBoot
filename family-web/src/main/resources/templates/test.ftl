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
    <script src="${ctx}/static/vue/vue.js" ></script>
    <script  src="${ctx}/static/element-ui/element-ui.min.js"></script>
    <link  rel="stylesheet" href = "${ctx}/static/element-ui/element-ui.min.css"/>
</head>
<body>
<div  id ="main-content">
<el-slider v-model="value2"></el-slider>
</div>

</body>

<script>

    var vue =  new Vue({
        el:'#main-content',
        data:function () {
            return {
                value2:30
            }
        },
        methods :{
        },
        created:function(){
        }
    });

</script>

</html>