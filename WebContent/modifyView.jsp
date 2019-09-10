<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>게시판 | 게시글 작성</title>
		<style>
			.wrapper {
				max-width: 700px;
				margin:auto;
				padding:16px;
			}
			.form-group{
				margin-bottom:0px !important;
			}
		</style>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
<body>
	<div class="wrapper">
		<h2>게시글 수정</h2>
		<form action="/modify.do" method="post" style="margin-top:30px;">
			<table class="table">
				<tbody>
					<tr>
						<th width="30%">작성자</th>
						<td width="70%">
						    <div class="form-group">
								<input class="form-control" type="text" disabled value="${post.bName}">
						    </div>
						</td>
					</tr>
					<tr>
						<th> 제목 </th>
						<td>
						    <div class="form-group">
								<input type="text" name="bTitle" class="form-control" placeholder="제목" value="${post.bTitle}" required>
						    </div>
						</td>
					</tr>
					<tr>
						<th> 내용 </th>
						<td>
						    <div class="form-group">
						    	<textarea
						    		class="form-control"
						    		placeholder="내용 입력"
						    		name="bContent"
						    		required
						    		style="resize:none; width:100%; padding:10px; height:300px;"
						    	>${post.bContent}</textarea>
						    </div>
						</td>
					</tr>
				</tbody>
				<tr>
					<td colspan="2" style="text-align:center;">
						<input class="btn btn-success" type="submit" value="수정" style="margin-right:10px;">
						<a class="btn btn-secondary" href="/list.do">목록</a>
					</td>
				</tr>
			</table>
			<input type="hidden" name="bId" value="${post.bId}">
		</form>
	</div>
</body>
</html>