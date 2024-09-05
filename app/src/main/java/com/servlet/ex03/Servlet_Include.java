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

@WebServlet("/ex03/i1")
public class Servlet_Include extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 응답 인코딩 변경 및 PrintWriter 준비
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("계산 결과:");

        // 계산연산자 파라미터
        // +는 예약어로 %2B로 QS를 보내야한다.
        String op = req.getParameter("op");

        RequestDispatcher rd = null;

        if (op.equals("+")){
            rd = req.getRequestDispatcher("/ex03/iplus");
        } else if (op.equals("-")) {
            rd = req.getRequestDispatcher("/ex03/iminus");
        } else {
            rd = req.getRequestDispatcher("/ex03/ierror");
        }

        // include는 다른 서블릿에서 실행을 위임하더라도
        // 현재 서블릿의 실행 결과를 유지한다.
        // include는 현재 서블릿에서 setContentType()을 설정해야한다.
        // forward는 현재 서블릿의 setContentType()이 무시된다.
        rd.include(req, resp);

        // include 서블릿을 실행한 후에 리턴되면
        // 현재 서블릿은 계속해서 출력할 수 있다.
        out.println("----------------------");
    }
}
