package com.servlet.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet/ex08/~
 *
 * Redirect
 * 클라이언트의 요청을 받은 후 콘텐트를 보내는 대신
 * 다른 페이지의 URL을 알려줄 때 사용한다.
 *
 * 웹 브라우저는 응답 받는 즉시 해당 페이지를 요청한다.
 *
 * 리프래시와 달리 서버는 콘텐트(message-body)를 보내지 않는다.
 *
 */

@WebServlet("/ex03/redi")
public class Servlet_Redirect extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/ex03/redirect => service()");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head>");
        out.println("<title>리다이렉트</title>");
        out.println("</head><body>");

        out.println("리다이렉트 입니다.");
        out.println("</body></html>");

        // Redirect
        resp.sendRedirect("s100");
    }
}
