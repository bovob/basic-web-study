<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    import="java.util.List"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>JSP ex06</title>
</head>
<body>
<h1>JSP TagLib</h1>
<pre style="background-color: #f5f5f5; border: 1px solid #ccc; padding: 10px;">
<h3>JSP TAG</h3>
<h4>지시문(directive element)</h4>
<%--
  !! taglib 사용시 의존성 패키지 설치해야된다.
     maven repo ==>> jstl
  용어정리
  1) 지시문(direcrive element) : JSP에서 사용될 속성, 인코딩 등 설정을 관여한다.
      - page : 서블릿 실행과 관련하여 특정 기능을 설정
      - include : 다른 파일 내용을 복사한다.
      - taglib : JSTL 등 외부에서 정의한 태그 정보를 가져온다.
  사용 : <%@ %>
  !! 아래 ${n} 는 EL (Expression Language)
--%>
<c:forEach items="홍길동,임꺽정,유관순" var="n">
이름=<%=pageContext.getAttribute("n")%>, ${n}<br>
</c:forEach>
</pre>
</body>
</html>
<%--
tablib 지시문
=> 외부에 따로 정의된 JSP 확장 태그를 가져올 때 사용한다.
=> JSP 확장 태그
   1) JSTL(JSP Standard Tag Library)
      - JSP 명세에 추가로 정의된 태그이다.
      - Servlet/JSP API에서는 JSTL 구현체를 제공하지 않는다.
      - 따로 구현된 라이브러리를 다운로드 받아야 한다.
        mvnrepository.com에서 JSTL 라이브러리를 검색하여 프로젝트에 추가하라.
      - 보통 apache.org 사이트에서 구현한 것을 사용한다.
   2) 개발자가 정의한 태그
      - 개발자가 따로 태그를 정의할 수 있다.
      - 그러나 실무에서는 유지보수 일관성을 위해 JSTL과 같은 표준 API를 사용한다.
      - 즉 개발자가 자신의 회사에서만 사용할 태그를 따로 정의하지 않는다.

=> 사용법
      <%@ taglib
          uri="확장 태그를 정의할 때 부여한 확장 태그 URI"
          prefix="확장태그를 사용할 때 붙이는 접두사"%>
   JSP 페이지에서 사용하기
      <확장_태그_접두사:사용자_태그명 속성명="값" .../>
 --%>