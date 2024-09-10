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
  <title>JSP ex07</title>
</head>
<body>
<h1>JSP TagLib</h1>
<pre style="background-color: #f5f5f5; border: 1px solid #ccc; padding: 10px;">
<h3>JSP TAG</h3>
<h4>빌트인 객체 - JSP에서 기본적으로 사용할 수 있는 객체</h4>
<%--
  용어정리
  1) JSP 빌트인 객체 : JSP 서블릿 클래스를 만들 떄 _jspService() 메서드에서 기본적으로 준비하는 객체
  JSP 엔진은 반드시 다음과 같은 이름으로 레퍼런스를 선언한다.
--%>
<%
// JSP의 기본 객체
request.setAttribute("REQ", "Request");
session.setAttribute("SESSION", "Session");
application.setAttribute("APP", "Application");
out.println("OUT");
%>
</pre>
</body>
</html>
<%--
JSP 빌트인 객체
- JSP를 가지고 서블릿 클래스를 만들 때 _jspService() 메서드에서 기본으로 준비하는 객체
- JSP 엔진은 반드시 다음과 같은 이름으로 레퍼런스를 선언해야 한다.
  즉 서블릿 컨테이너(ex: 톰캣, jetty, resin 등)에 상관없이 이름이 같다.

1) request - HttpServletRequest => _jspService() 파라미터이다.
2) response - HttpServletResponse => _jspService() 파라미터이다.
3) pageContext - PageContext => _jspService()의 로컬 변수이다.
4) session - HttpSession => _jspService()의 로컬 변수이다.
5) application - ServletContext => _jspService()의 로컬 변수이다.
6) config - ServletConfig => _jspService()의 로컬 변수이다.
7) out - JspWriter => _jspService()의 로컬 변수이다.
8) page - 서블릿 객체를 가리킨다. 즉 this 이다. => _jspService()의 로컬 변수이다.
9) exception - Throwable => _jspService()의 로컬 변수이다.
   - 이 변수는 JSP 페이지가 <%@ page isErrorPage="true"%>로 설정되었을 때만 존재한다.
   - 주로 오류가 발생되었을 때 실행되는 JSP 페이지인 경우 위 설정을 붙인다.

scope는
기본 "page"이며
page(PageContext)            --> 서블릿 현재 페이지내 / 새로고침 시 사라짐
request(ServletRequest)      --> 서블릿 요청 파라미터에 담긴 객체 / 요청 끝날 시 사라짐
session(HttpSession)         --> HTTP 세션에 담긴 파라미터에 담긴 객체 / 브라우저 닫거나 세션 만료되면 사라짐
application(ServletContext)  --> 서블릿 전체에 대한 파라미터에 담긴 객체 / 애플리케이션 실행되는 동안 유지 서버 꺼지면 사라짐
--%>