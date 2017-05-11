 <#assign ctx= request.contextPath/>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="${ctx}/static/flatlab/img/favicon.png">

    <title>404</title>

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
</head>




  <body class="body-404">

    <div class="container">

      <section class="error-wrapper">
          <i class="icon-404"></i>
          <h1>error</h1>
          <h2>报错了知道不</h2>
          <p class="page-404">Something went wrong: ${status} ${error} </p>
      </section>

    </div>


  </body>
</html>
