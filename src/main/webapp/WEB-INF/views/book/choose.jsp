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
			                		<img src="${pageContext.request.contextPath}/assets/images/${book.image}" alt="" style="-webkit-border-radius: initial;">
			                		<div class="features-box-1-icon">
			                		</div>
			                    <p>${book.name}</p>
			                    <h5>${book.author}</h5>
				                </div>
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
	                    <p>VoteLivro por Niedson Araujo</p>
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
    <!--[if lt IE 10]>
        <script src="assets/js/placeholder.js"></script>
    <![endif]-->	
	
</body>



</html>
