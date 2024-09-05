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

@WebServlet("/ex03/ierror")
public class Servlet_Include_Error extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter out = resp.getWriter();
        out.println("해당 연산은 지원하지 않습니다.");
        System.out.println("/ex03/ierror 호출");
    }
}
