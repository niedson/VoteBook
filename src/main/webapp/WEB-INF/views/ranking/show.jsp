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
	<div class="whos-behind-container">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 whos-behind">
					<h3>Ranking</h3>
				</div>
			</div>
			
			<c:if test="${ errorMessage == null }">
				<div class="col-sm-12 whos-behind">
					<p>Votos do usu�rio ${userBookCount.user.name}</p>
				</div>
				<c:forEach items="${  userBookCount.listRankingBookCount }"
					var="bookCount">
					<div class="col-sm-6 whos-behind-box-1">
						<div class="whos-behind-photo vote-book" data-book-id="${book.id}"
							style="height: auto;">
							<h5>${bookCount.count}
								<c:if test="${bookCount.count == 1 }"> Voto</c:if>
								<c:if test="${bookCount.count > 1 }"> Votos</c:if>
							</h5>
							<img
								src="${pageContext.request.contextPath}/assets/images/${bookCount.book.image}"
								alt="" style="-webkit-border-radius: initial;">
							<div class="features-box-1-icon"></div>
							<p>${bookCount.book.name}</p>
						</div>
					</div>
				</c:forEach>
	
	
	
				<div class="row">
					<div class="col-sm-12 whos-behind">
						<p>Todos os Votos</p>
					</div>
				</div>
				<c:forEach items="${ listBookCount }" var="bookCount">
					<div class="col-sm-6 whos-behind-box-1">
						<div class="whos-behind-photo vote-book" data-book-id="${book.id}"
							style="height: auto;">
							<h5>${bookCount.count}
								<c:if test="${bookCount.count == 1 }"> Voto</c:if>
								<c:if test="${bookCount.count > 1 }"> Votos</c:if>
							</h5>
							<img
								src="${pageContext.request.contextPath}/assets/images/${bookCount.book.image}"
								alt="" style="-webkit-border-radius: initial;">
							<div class="features-box-1-icon"></div>
							<p>${bookCount.book.name}</p>
						</div>
					</div>
				</c:forEach>
			</c:if>
			
			
			<div class="col-sm-12 col-md-12 col-lg-12">
				<p>${ errorMessage } </p>
			</div>
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="top-button">
	            	<a class="button-1" href="${pageContext.request.contextPath}/book/choose">
	            		Votar Novamente
	            	</a>
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
