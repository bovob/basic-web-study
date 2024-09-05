package com.servlet.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet/ex08/~
 *
 * Refresh
 * 서버로 부터 응답을 받고 "내용을 출력" 한 후
 * 지정된 시간이 경과하면 특정 URL을 자동으로 요청하도록 만든다.
 *
 */

@WebServlet("/ex03/ref")
public class Servlet_Refresh extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/ex03/refresh => service()");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head>");
        // 1번 Meta 태그에 http-equiv Refresh 적용 / content 3초후 ; url s100으로
        //out.println("<meta http-equiv='Refresh' content='3;url=s100'>");
        out.println("<title>리프레시</title>");
        out.println("</head><body>");
        out.println("리프레시 입니다.");
        out.println("</body></html>");


        // 2번 Header 변경
        resp.setHeader("Refresh", "3;url=s100");

    }
}
