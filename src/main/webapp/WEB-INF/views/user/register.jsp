<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<script
	src="${pageContext.request.contextPath}/assets/javascript/jquery.min.js"></script>
<title></title>
<style type="text/css">
</style>
</head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/fonts/OleoScript">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/fonts/OpenSans">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/stylesheet/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/stylesheet/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/stylesheet/form-elements.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/stylesheet/buttons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/stylesheet/ultm.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/stylesheet/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/stylesheet/media-queries.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Favicon and touch icons -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/assets/images/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${pageContext.request.contextPath}/assets/images/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${pageContext.request.contextPath}/assets/images/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${pageContext.request.contextPath}/assets/images/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath}/assets/images/apple-touch-icon-57-precomposed.png">



<body style="background-color: #3d3d3d">
	<div class="subscribe-container">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 subscribe" style="height: 70%">
					<h3>Cadastro</h3>
					<p>Informe seu nome e email para entrar no ranking</p>
					<form class="form-inline" role="form" action="save" method="post">
						<div class="row">
							<div class="form-group">
								<label class="sr-only" for="subscribe-email">Email address</label> 
								<input type="text" name="email" placeholder="Email" class="subscribe-email" id="subscribe-email"> 
								<input type="text" name="name" placeholder="Nome" class="subscribe-email" id="subscribe-name">
							</div>
							<br/>
						</div>
						<br />
						<div class="row">
							<button type="submit" class="btn">Enviar</button>
						</div>
					</form>
					<div class="success-message" style="display: none;"></div>
					<div class="error-message" style="display: none;"></div>
				</div>
			</div>
		</div>
	</div>


	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-sm-7 footer-copyright">
					<p>VoteLivro por Niedson Araujo</p>
				</div>
				<div class="col-sm-5 footer-social">
					<a
						class="ultm ultm-facebook ultm-48 ultm-square ultm-gray-to-color"
						target="_blank" href="https://github.com/niedson/VoteBook"> <img
						src="${pageContext.request.contextPath}/assets/images/github.jpeg">
					</a>
				</div>
			</div>
		</div>
	</footer>

	<!-- Javascript -->
	<script
		src="${pageContext.request.contextPath}/assets/javascript/jquery-1.11.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/javascript/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/javascript/jquery.backstretch.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/javascript/retina-1.1.0.min.js"></script>

	<!--[if lt IE 10]>
        <script src="assets/js/placeholder.js"></script>
    <![endif]-->
</body>
</html>
