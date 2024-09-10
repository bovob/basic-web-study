<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    import="java.util.List"
    %>
<%@ page import="com.vo.User"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>JSP ex08</title>
</head>
<body>
<h1>JSP TagLib</h1>
<pre style="background-color: #f5f5f5; border: 1px solid #ccc; padding: 10px;">
<h3>JSP TAG</h3>
<h4>JSP 액션태그 및 객체 보관</h4>
<%--
  용어정리
  1) scope 기본 "page"이며
    page(PageContext)            --> 서블릿 현재 페이지내 / 새로고침 시 사라짐
    request(ServletRequest)      --> 서블릿 요청 파라미터에 담긴 객체 / 요청 끝날 시 사라짐
    session(HttpSession)         --> HTTP 세션에 담긴 파라미터에 담긴 객체 / 브라우저 닫거나 세션 만료되면 사라짐
    application(ServletContext)  --> 서블릿 전체에 대한 파라미터에 담긴 객체 / 애플리케이션 실행되는 동안 유지 서버 꺼지면 사라짐

  2) JSP 액션태그
  => JSP 에서 기본으로 제공하는 전용 태그
  => taglib 를 사용하여 선언 할 필요 없다
  => <jsp:태그 .../>
--%>
<%-- Scope를 지정하지 않았다면 기본은 ! Page !--%>
<%-- <jsp:useBean scope="보관소명" id="객체명" class="클래스명"/> --%>
<jsp:useBean id="u1" class="com.vo.User" scope="page"/>
<jsp:useBean id="u2" class="com.vo.User"/>
<jsp:useBean id="u3" class="com.vo.User"/>

<jsp:setProperty name="u1" property="no" value="1"/>
<jsp:setProperty name="u2" property="no" value="2"/>
<jsp:setProperty name="u3" property="no" value="3"/>

<jsp:setProperty name="u1" property="name" value="홍길동"/>
<jsp:setProperty name="u2" property="name" value="유관순"/>

<%=u1%> => out.print(u1);<br>
<%=u2%> => out.print(u2);<br>
<%=u3%> => out.print(u3);<br>

</pre>
</body>
</html>
<%--
User u1 = (User) pageContext.getAttribute("u1");
if (u1 == null) {
    u1 = new User();
    pageContext.setAttribute("u1", u1);
}
--%>