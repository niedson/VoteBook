<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title></title>
<style type="text/css">
</style>
</head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Favicon and touch icons -->


<body style="background-color: #3d3d3d">
	<div class="whos-behind-container">
		<div class="container">
			<div class="row">
                <div class="col-sm-12 whos-behind">
                    <h3>Ranking</h3>
                </div>
            </div>			
    
            <div class="col-sm-12 whos-behind">
                <p>Votos do usuário ${userBookCount.user.name}</p>
            </div>
			<c:forEach items="${  userBookCount.listRankingBookCount }" var="bookCount">
			<div class="col-sm-6 whos-behind-box-1">
               	<div class="whos-behind-photo vote-book" data-book-id="${book.id}" style="height: auto;">
                   <h5>${bookCount.count} <c:if test="${bookCount.count == 1 }"> Voto</c:if><c:if test="${bookCount.count > 1 }"> Votos</c:if> </h5>
               		<img src="${pageContext.request.contextPath}/assets/images/${bookCount.book.image}" alt="" style="-webkit-border-radius: initial;">
               		<div class="features-box-1-icon">
               		</div>
                   <p>${bookCount.book.name}</p>
                </div>
            </div>	
			</c:forEach>		
			
			<div class="row">
                <div class="col-sm-12 whos-behind">
                    <p>Geral</p>
                </div>
            </div>				
			<c:forEach items="${ listBookCount }" var="bookCount">
			<div class="col-sm-6 whos-behind-box-1">
               	<div class="whos-behind-photo vote-book" data-book-id="${book.id}" style="height: auto;">
                   <h5>${bookCount.count} <c:if test="${bookCount.count == 1 }"> Voto</c:if><c:if test="${bookCount.count > 1 }"> Votos</c:if> </h5>
               		<img src="${pageContext.request.contextPath}/assets/images/${bookCount.book.image}" alt="" style="-webkit-border-radius: initial;">
               		<div class="features-box-1-icon">
               		</div>
                   <p>${bookCount.book.name}</p>
                </div>
            </div>	
			</c:forEach>
		</div>
	</div>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-sm-7 footer-copyright">
					<p>
						VoteLivro por Niedson Araujo
					</p>
				</div>
				<div class="col-sm-5 footer-social">
					<a
						class="ultm ultm-facebook ultm-48 ultm-square ultm-gray-to-color"
						target="_blank" href="https://github.com/niedson"> <img
						src="${pageContext.request.contextPath}/assets/images/github.jpeg">
					</a>
				</div>
			</div>
		</div>
	</footer>

	<!-- Javascript -->

	<!--[if lt IE 10]>
       <script src="assets/js/placeholder.js"></script>
    <![endif]-->
</body>



</html>
