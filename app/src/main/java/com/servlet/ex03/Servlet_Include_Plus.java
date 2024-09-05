package com.servlet.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet/ex07/~
 *
 * PrintWriter를 통해 serivce()의 Response값을 출력시
 * service() 메서드가 종료되고 난 후 내부에 저장해 두었던 buffer에서 출력한다.
 *
 * 만약 출력전에 Buffer에 값이 가득 찬다면 바로 출력해버려
 * 이후 액션을 취할 수 없게 된다. [ 보통 8kb 크기 ]
 * 
 */

@WebServlet("/ex03/iplus")
public class Servlet_Include_Plus extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 이미 이전 서블릿에서 setContentType()을 호출했기 떄문에 해당 서블릿엔 필요가 없다.
        PrintWriter out = resp.getWriter();
        // 계산연산자 파라미터
        // +는 예약어로 %2B로 QS를 보내야한다.
        String op = req.getParameter("op");

        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));

        out.printf("%d + %d = %d\n", a, b, a+b);
        RequestDispatcher rd = null;

        // service의 호출이 완료되면 이전 서블릿으로 되돌아간다.
    }
}
