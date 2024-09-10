<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    import="java.util.List"
    errorPage="ex11_error.jsp"
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>JSP ex11</title>
</head>
<body>
<h1>JSP Error</h1>
<pre style="background-color: #f5f5f5; border: 1px solid #ccc; padding: 10px;">
<h1>errorPage 속성과 isErrorPage 속성</h1>
http://localhost:8888/jsp/ex11.jsp?value="10" 처럼 QS쿼리스트링 줄 것
10 나누기 value 값
<%
int value = Integer.parseInt(request.getParameter("value"));
%>
10 / <%=value%> = <%=10 / value%>

</pre>
</body>
</html>
<%--
errorPage
=> JSP를 실행하는 중에 오류가 발생했을 때 실행할 JSP를 지정할 수 있다.
=> 사용법
     <%@ page errorPage="URL"%>
=> 이 속성에 URL을 지정하지 않으면 오류가 발생했을 때
   서블릿 컨테이너의 기본 오류 출력 페이지가 실행된다.

isErrorPage
=> 오류가 발생했을 때 실행되는 JSP 쪽에서
   그 오류 내용을 받을 때 사용한다.
--%>