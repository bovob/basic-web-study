<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>JSP ex02</title>
</head>
<body>
<h1>JSP Template</h1>
<pre style="background-color: #f5f5f5; border: 1px solid #ccc; padding: 10px;">
<h3>JSP 텍스트 출력</h3>
<h4>- JSP 파일에 그냥 작성하는 텍스트는 자바 출력 코드를 생성한다.</h4>
  예시) 그냥 텍스트로 나옴
        out.write("write 예시")
        out.print("print 예시")

<h3>JSP 자바코드 입력을 위한 "<""%"스크립트릿 (scriptlet)"%"">"</h3>
<!-- HTML 주석 으로 JSP 엔진에서는 단순 출력문으로 바꿀 템플릿 데이터 -->
<%-- JSP 주석 으로 JSP 엔진에서 무시 --%>
<%
// 스크립 트릿 안에서는 자바 주석을 사용할 수도 있다.
// 아래는 x 변수 선언
int x;
x = 5;
%>
스크립트릿(scriptlet)
  - "<""%" 자바코드 "%"">" 로 작성된다.
  - _jspService() 메서드 안에 작성된 순서 그대로 복사된다.
  예시) if&for를 이용한 숫자출력
<%
  if (x < 10)
    for (int i = 0 ; i <= x ; i++) {
       out.print("<p>" + i + "</p>");
    }
%>
</pre>
</body>
</html>