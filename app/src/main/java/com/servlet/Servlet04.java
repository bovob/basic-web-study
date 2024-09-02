package com.servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * java/servlet/web/ex01
 * Servlet
 * => 클라이언트의 요청을 처리하고
 *    그 결과를 반환하는 자바 웹 프로그래밍 기술
 *
 * 사용방법
 * => 서블릿 클래스 생성 후
 *    서블릿 컨테이너에 등록해야만 사용할 수 있다.
 */

@WebServlet("/ex01/forth")
public class Servlet04 extends HttpServlet {

    ServletConfig config;

    public Servlet04(){
        System.out.println("4번 Servlet()");
    }

    // HttpServlet은 GenericServlet을 상속받았다.
    // 따라서 동일하게 init, destroy, getServletConfig와 getServletInfo를 생성할 필요가 없다.
    // 거기에 더해 GET, POST, PUT, DELETE 등 HTTP Request를 사용할 수 있다.
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 웹에서 사용하기 위해 HTTP 프로토콜 Request와 Response로 형변환을 한다.
        System.out.println("4번 service()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("4번 GET 요청");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("4번 POST 요청");
    }
}
