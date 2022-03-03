<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>혼밥자랑 메인</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</head>
<body>
<!-- <a></a> BEST게시판 이동 링크 --> ${BragBest1.user_PK } ${BragBest1.content } ${BragBest1.location }
	
	<div class="row justify-content-center">
		<div class="col mt-5">
			<div class="card p-4">
				<h5 class="fw-bolder">이달의혼밥</h5>
				<div class="text-center">
					<!--  <h5 class="fw-bolder">이달의 혼밥</h5>-->
				</div>
				<div class="card-body">
					<img width="450px" height="450px" class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
				</div>
				
			</div>
		</div>
		
		
		<div class="col mt-5">
			<div class="card p-4">
			<a href="/brag/best"><h5 class="fw-bolder">BEST</h5></a>
				<div class="card-body">
					<table>
						<tr>
							<td>
								<img width="230px" height="230px"  class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
							</td>
						</tr>
						<tr>
							<td>
								<img width="230px" height="230px"  class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
							</td>
						</tr>
					</table>
					
				</div>
			</div>
		</div>
		</div>
		
		<div>
		<!-- 나중에 onclick으로 변경 -->
		<a style="float: right;" href="/brag/writeform"><button>글쓰기</button></a>
		</div>
		
			<div class="col mt-5">
			<div class="card p-4">
				<div class="text-center">
					 <a href="/brag/brag"><h5 class="fw-bolder">혼밥자랑</h5></a>
				</div>
				<div class="card-body">
					<table>
						<tr>
							<td>
								<img width="230px" height="230px"  class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
							</td>
							<td>
								<img width="230px" height="230px"  class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
							</td>
							<td>
								<img width="230px" height="230px"  class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
							</td>
							<td>
								<img width="230px" height="230px"  class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
							</td>
						</tr>
						<tr>
							<td>
								<img width="230px" height="230px"  class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
							</td>
							<td>
								<img width="230px" height="230px"  class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
							</td>
							<td>
								<img width="230px" height="230px"  class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
							</td>
							<td>
								<img width="230px" height="230px"  class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
							</td>
						</tr>
					</table>
					
				</div>
			</div>
		</div>
			
	
</body>
</html>