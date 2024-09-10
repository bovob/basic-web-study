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
  <title>JSP ex10</title>
</head>
<body>
<h1>JSP TagLib</h1>
<pre style="background-color: #f5f5f5; border: 1px solid #ccc; padding: 10px;">
<h3>JSP TAG include</h3>
<h4>JSP Header, Footer</h4>
<jsp:include page="ex10_header.jsp"/>
<p>테스트</p>
<jsp:include page="ex10_footer.jsp"/>

</pre>
</body>
</html>
