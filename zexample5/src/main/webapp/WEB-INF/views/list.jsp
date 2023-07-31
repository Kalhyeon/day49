<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap 5, jQuery -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	.finish {text-decoration: line-through;}
</style>
<script>
	$(document).ready(function() {
		$('.update').on('click', function() {
			const tno = $(this).attr('data-tno');
			
			// 동적 폼을 만들자.
			const form = `
				<form action='/update' method='post'>
					<input type='hidden' name='tno' value='\${tno}'>
				</form>
			`;

			// 기억할 것 : <form> 을 body 에 붙인 다음에
			//			submit 해야한다.
			// 부모.append(자식) => 결과는 부모
			// 자식.appendTo(부모) => 결과는 자식
			
			// $('#page') => HTML 요소를 선택하여 jQuery
			//				 객체를 만든다.
			// $('<form>') => <form> 을 jQuery 객체로 만든다.
			$(form).appendTo($('body')).submit();
		});
	});
</script>
</head>
<body>
	<div id="page">
		<header>
			<jsp:include page="include/header.jsp"></jsp:include>
		</header>
		<nav>
			<jsp:include page="include/nav.jsp"></jsp:include>
		</nav>
		<main>
			<aside>
				<jsp:include page="include/aside.jsp"></jsp:include>
			</aside>
			<section>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>할 일</th>
							<th>등록일</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${todos}" var="todo">
							<tr>
								<td>${todo.tno}</td>
								<td class="${todo.finish? 'finish':''}">
									${todo.job} ${todo.finish? '(완료)':''}
								</td>
								<td>${todo.writeday}</td>
								<td>
									<button data-tno="${todo.tno}" class="update">
										변경
									</button>
									<button>삭제</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
			<aside>
				<jsp:include page="include/aside.jsp"></jsp:include>
			</aside>
		</main>
		<footer>
			<jsp:include page="include/footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>