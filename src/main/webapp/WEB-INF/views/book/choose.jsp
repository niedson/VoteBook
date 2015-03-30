<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<title></title>
<style type="text/css">
</style>
</head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS -->
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oleo+Script">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/form-elements.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/buttons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/ultm.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/media-queries.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/assets/images/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/assets/images/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/assets/images/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/images/apple-touch-icon-57-precomposed.png">



<body style="background-color: #3d3d3d">
       <div class="whos-behind-container">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 whos-behind">
	                    <h3>Vote no Livro</h3>
	                    <p>
	                    	Selecione o melhor livro na sua opinião.
	                    </p>
	                </div>
	            </div>
            	<form action="choose" method="post">
					<input type="hidden" name="voteBookHistId" value="${voteBookHist.id}">
					<input type="hidden" name="selectedBookId" id="selectedBookId">
		            <div class="row">
		            	<!-- Book FOR - start -->
						<c:forEach items="${ bookList }" var="book" varStatus="status">
			                <div class="col-sm-6 whos-behind-box-1">
			                	<div class="whos-behind-photo vote-book" data-book-id="${book.id}" style="height: auto;">
			                		<img src="${pageContext.request.contextPath}/assets/images/livro-senhor-dos-aneis.jpg" alt="" style="-webkit-border-radius: initial;">
			                		<div class="features-box-1-icon">
			                		</div>
				                </div>
			                    <h4>${book.name}</h4>
			                    <h5>${book.name}</h5>
			                    <p>
			                    	${book.author }
			                    </p>
			                </div>
						</c:forEach>
		            	
		            	<!-- Book FOR - End -->

		            </div>
				</form>
	        </div>
        </div>
        
        
        <!-- Footer -->
        <footer>
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-7 footer-copyright">
	                    <p>© Vote Livro por Niedson Araujo<br>Todos os direitos reservados.</p>
	                </div>
	                <div class="col-sm-5 footer-social">
	                    <a class="ultm ultm-facebook ultm-48 ultm-square ultm-gray-to-color" target="_blank" href="https://github.com/niedson">
	                    	<img src="${pageContext.request.contextPath}/assets/images/github.jpeg">
	                    </a>
	                </div>
	            </div>
	        </div>
        </footer>
	
    <!-- Javascript -->
    <script src="${pageContext.request.contextPath}/assets/javascript/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/javascript/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/javascript/jquery.backstretch.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/javascript/retina-1.1.0.min.js"></script>
    
    <!--[if lt IE 10]>
        <script src="assets/js/placeholder.js"></script>
    <![endif]-->	
	
	<script>
	$(document).ready(function(){
		$('.vote-book').click(function(){
			var $this = $(this);
			var bookId = $this.attr('data-book-id');
			$('#selectedBookId').val(bookId);
			$('form').submit();
		});
	});
	</script>
</body>



</html>
