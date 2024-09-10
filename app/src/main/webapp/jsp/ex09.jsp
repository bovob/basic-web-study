<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    import="java.util.List"
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>JSP ex09</title>
</head>
<body>
<h1>JSP TagLib</h1>
<pre style="background-color: #f5f5f5; border: 1px solid #ccc; padding: 10px;">
<h3>JSP TAG</h3>
<h4>JSP 액션태그 및 객체 보관(이어서)</h4>
<%--
  용어정리
  1) scope 기본 "page"이며
    page(PageContext)            --> 서블릿 현재 페이지내 / 새로고침 시 사라짐
    request(ServletRequest)      --> 서블릿 요청 파라미터에 담긴 객체 / 요청 끝날 시 사라짐
    session(HttpSession)         --> HTTP 세션에 담긴 파라미터에 담긴 객체 / 브라우저 닫거나 세션 만료되면 사라짐
    application(ServletContext)  --> 서블릿 전체에 대한 파라미터에 담긴 객체 / 애플리케이션 실행되는 동안 유지 서버 꺼지면 사라짐
--%>
<%-- --%>
application.setAttribute("s1", "홍길동");
session.setAttribute("s2", "임꺽정");
request.setAttribute("s3", "안중근");
pageContext.setAttribute("s4", "윤봉길");


<%-- Scope를 지정하지 않았다면 기본은 ! Page !--%>
<%-- <jsp:useBean scope="보관소명" id="객체명" type="클래스명"/> --%>
<%--
<jsp:useBean id="s1" type="java.lang.String" scope="page"/>
<jsp:useBean id="s2" type="java.lang.String" scope="request"/>
<jsp:useBean id="s3" type="java.lang.String" scope="session"/>
<jsp:useBean id="s4" type="java.lang.String" scope="application"/>
--%>
<%=s1%> => out.print(s1);<br>
<%=s2%> => out.print(s2);<br>
<%=s3%> => out.print(s3);<br>
<%=s4%> => out.print(s4);<br>

</pre>
</body>
</html>
<%--
  String s1 = (String)application.getAttribute("s1");
  if (s1 == null) {
    throw new Exception("..."); // 해당 이름으로 저장된 객체가 없다면 예외를 발생시킨다.
  }
--%>