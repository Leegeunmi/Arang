<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="delete_gallery.do" method="get">
	<h3> 갤러리 삭제</h3>
		<ul>
			<li>삭제할 ID: <input type="text" name="galleryId"/></li>			
			<li><input type="submit" value="확인"/></li>				
		</ul>
	</form>
</body>
</html>