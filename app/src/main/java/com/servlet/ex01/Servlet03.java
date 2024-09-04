package com.servlet.ex01;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

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

@WebServlet("/ex01/test/third")
public class Servlet03 extends GenericServlet {

    ServletConfig config;

    public Servlet03(){
        System.out.println("3번 Servlet()");
    }

    // GenericServlet은 Servlet과 ServletConfig를 상속받아서
    // init, destroy, getServletConfig와 getServletInfo를 생성할 필요가 없다.
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 웹에서 사용하기 위해 HTTP 프로토콜 Request와 Response로 형변환을 한다.
        System.out.println("3번 service()");
    }
}
