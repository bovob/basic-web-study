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
  <title>JSP ex04</title>
</head>
<body>
<h1>JSP 선언문</h1>
<pre style="background-color: #f5f5f5; border: 1px solid #ccc; padding: 10px;">
<h3>JSP 활용</h3>
<h4>선언문(Declaration)</h4>
<%--
  용어정리
  1) 선언문(Declaration) : 메소드나 변수를 선언한다.
  이는 한 번만 선언되며 해당 서블릿의 클래스 멤버로 포함된다.
  문장(스크립트릿)<% %>은 service() 메소드 내에서 사용되지만
  선언문<%! %>은 클래스(해당 서블릿내)에서 사용된다.
  <%! public void jspInit(){...} %>                  ---> 메서드 오버라이딩
  <%! double a = 0.025; %>                           ---> 인스턴스 변수
  <%! { system.out.println("인스턴스블록") }
      static { system.out.println("스태틱블록") } %> ---> 블록 선언
  사용 : <%! %>
--%>
<%! public void jspInit(){
       System.out.println("ex04 jspInit() 오버라이딩");
       }
    public int plus(int a, int b){
        return a + b;
    }
    int a = 99;
    int b = 1;
%>
<h3>a+b 의 값은 : <%=plus(a, b)%></h3>
</ul>
</pre>
</body>
</html>