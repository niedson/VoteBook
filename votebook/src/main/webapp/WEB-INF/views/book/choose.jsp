<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<title></title>
<style type="text/css">
</style>
</head>
<body>
	<br>
	<br>
	<form action="choose" method="post">
		<input type="hidden" name="voteBookHistId" value="${voteBookHist.id}">
		<input type="hidden" name="selectedBookId" id="selectedBookId">
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
		$('#selectedBookId').val(bookId);
		$('form').submit();
	});
});
</script>


</html>
