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
				            <br/>
		                    <div class="row">
		                    	<button type="submit" class="btn" >Enviar</button>
		                    	
		                    	
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
	                    <a class="ultm ultm-facebook ultm-48 ultm-square ultm-gray-to-color" target="_blank" href="https://github.com/niedson">
	                    	<img src="${pageContext.request.contextPath}/assets/images/github.jpeg">
	                    </a>
	                </div>
	            </div>
	        </div>
        </footer>
	
    <!--[if lt IE 10]>
        <script src="assets/js/placeholder.js"></script>
    <![endif]-->	
</body>
</html>
