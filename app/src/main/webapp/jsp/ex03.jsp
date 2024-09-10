<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>JSP ex03</title>
</head>
<body>
<h1>JSP 문장과 표현식</h1>
<pre style="background-color: #f5f5f5; border: 1px solid #ccc; padding: 10px;">
<h3>JSP 활용</h3>
<h4>표현식(expression element)</h4>
<%--
  용어정리
  1) 문장(statement) : 로직구현이나 출력이 없다.
     if(){}, for(){}, int a = 100;
  사용 : <% %>
  2) 표현식(expression) : 반환값이 있으며 즉시 출력된다.
     a*b         => 곱하기 결과 리턴
     (..)? a : b => 삼항연산 결과 리턴
     plus(10, 20)=> plus() 메서드 결과 값 리턴
  사용 : <%= %>
--%>
<% String[] names = {"홍길동", "임꺽정", "유관순"};%>
<ul>
<%for (String name : names) {%>
<li><%=name%></li>
<%}%>
</ul>
</pre>
</body>
</html>