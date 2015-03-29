<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<html>
<head>
<title></title>
<style type="text/css">
</style>
</head>
<body>
	<br>
	<br>
	<form action="choose" method="post">
		<input type="hidden" name="id" value="${voteBookHist.id}">
		<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align:center;">
			<c:forEach items="${ bookList }" var="book" varStatus="status">
				<div class="vote-book" data-book-id="${book.id}">
					${ book.id } ${ book.name }
				</div>
				<br/>
			</c:forEach>
		</div>
	</form>
</body>

<script>
$(document).ready(function(){
	$('.vote-book').click(function(){
		var $this = $(this);
		var bookId = $this.attr('data-book-id');
	});
});
</script>


</html>
