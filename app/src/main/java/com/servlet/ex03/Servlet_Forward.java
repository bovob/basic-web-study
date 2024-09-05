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

@WebServlet("/ex03/f1")
public class Servlet_Forward extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 응답 인코딩 변경 및 PrintWriter 준비
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("더하기 계산 결과:");

        // 계산연산자 파라미터
        // +는 예약어로 %2B로 QS를 보내야한다.
        String op = req.getParameter("op");
        if (!op.equals("+")){
            // 다른 서블릿으로 요청을 위임한다.
            RequestDispatcher rd = req.getRequestDispatcher("/ex03/f2");
            // forward는 현재 서블릿에서의 출력을 취소하고
            // 버퍼를 비우고 전달한다.
            rd.forward(req, resp);

            // 리턴 확인용 디버깅코드
            System.out.println("/ex03/f1 로 리턴됨");
            out.println("출력이 될까?");

            // 포워딩 서블릿에서 다시 원래 서블릿으로 돌아온 후엔
            // 하위 코드를 실행하지 않고 바로 종료되도록 return을 삽입한다.
            return;
        }

        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));

        out.printf("%d + %d = %d\n", a, b, a+b);
    }
}
