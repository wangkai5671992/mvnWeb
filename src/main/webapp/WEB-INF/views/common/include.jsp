<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<c:set var="BASE_FRONT" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
    BASE = '${BASE}';
    BASE_FRONT = '${BASE_FRONT}';
</script>
<link rel="stylesheet" type="text/css" href="${BASE_FRONT}/app/lib/bootstrap/css/bootstrap.min.css"/>
<script type="text/javascript" charset="utf-8" src="${BASE_FRONT}/app/lib/jquery-3.0.0.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${BASE_FRONT}/app/lib/bootstrap/js/bootstrap.min.js"></script>