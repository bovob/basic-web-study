<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>JSP ex01</title>
</head>
<body>
<h1>JSP 구동원리</h1>
<pre style="background-color: #f5f5f5; border: 1px solid #ccc; padding: 10px;">
<h3>1) 웹 브라우저 ===> 서블릿 컨테이너</h3>
   - JSP 실행 요청
     예) http://localhost:8888/jsp/ex01.jsp
<h3>2) 서블릿 컨테이너가 실행</h3>
   1. JSP의 서블릿 컨테이너 객체를 찾는다.
   2. 서블릿 객체를 호출한다.
      service() ---> _jspService()
   3. 서블릿 객체가 없을시 JSP 엔진을 이용하여 JSP 파일이용하여 서블릿 자바 소스 파일을 생성한다.
   4. 자바 컴파일러가 소스 파일을 컴파일 한다.
   5. 서블릿 객체가 생성된다.
      init() ---> _jspService()
   6. 이미 컴파일 되어 있다면 5번이 반복된다.
<h3>3) 서블릿 컨테이너 ===> 웹 브라우저</h3>
   - 서블릿 실행 결과 응답
<p><h3>JSP 파일을 가지고 생성한 서블릿 소스(.jsva)와 클래스 (.class)의 위치</h3>
  - org.eclipse.wst.server.core/tmpx/work</p>
<h3>정리</h3>
  * JSP 파일은 Python이나 PHP 처럼 스크립트가 인터프리팅 되는 것이 아니다.
  * JSP 엔진의 역할은 서블릿 클래스를 생성하는 것이다.
  * 즉 JSP 파일 자체가 실행되는 것이 아니다.
  * 서블릿 클래스를 만드는 재료이며 `틀`이라 `템플릿(template)`라고 부른다.
<h3>JSP 엔진이 서블릿을 만들 때 지켜야할 규칙</h3>
  - JSP 파일을 가지고 서블릿을 만들 땐 HttpJspPage를 구현해야 한다.
  - 클래스 계층도
    Servlet
      ㄴ init(ServletConfig):void
      ㄴ destory():void
      ㄴ service(ServletRequest, ServletResponse):void
      ㄴ getServletInfo():String
      ㄴ getServletConfig():ServletConfig
      +---> JspPage
              ㄴ jspInit():void
              ㄴ jspDestroy():void
              +---> HttpJspPage
                      ㄴ _jspService(HttpServletRequest, HttpServletResponse):void
</pre>
</body>
</html>