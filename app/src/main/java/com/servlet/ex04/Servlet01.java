package com.servlet.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * servlet/ex09/~
 *
 * 웹 보관소
 * 웹은 여러가지 데이터 객체를 저장해둘 수 있는 공간들이 있다.
 *
 * 1. Servlet Context
 * => 웹 애플리케이션 당 1개 생성
 * => 웹 애플리케이션을 실행하는 동안 사용할 객체를 보관한다.
 * ex) DAO, Service 트랜잭션 관리자 등
 *
 *  2. Http Session
 *  => 클라이언트 당 1개 생성
 *  => 클라이언트가 로그인 되어 있는 동안 사용할 객체를 보관한다.
 *  ex) 로그인 사용자 정보, 이전 화면에서 입력받아 전달된 값 등
 *
 *  3. Servlet Request
 *  => 매 요청 당 1개 생성
 *  => 요청을 처리하는 동안 사용할 객체를 보관한다.
 *  ex) DAO, Service 객체의 리턴 값 등
 *
 *  4. JSP Context
 *  => JSP를 실행하는 동안 유지
 *  => JSP 태그 핸들러와 값을 공유 할 때 사용한다.
 *  ex) JSP 핸들러, JSP 내에서 사용하는 객체 값 등
 */

@WebServlet(value="/ex04/s1", loadOnStartup=1)
@SuppressWarnings("serial") // Serial 관련 경고를 무시한다.
public class Servlet01 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. ServletContext를 사용하는 모든 서블렛에서 사용할 수 있는 보관
        // 해당 객체는 웹 애플리케이션이 시작될 때 생성된다.
        ServletContext sc = this.getServletContext();
        sc.setAttribute("context", "모두가 쓸 수 있다.");
        String contextString = (String) sc.getAttribute("context");

        // 2. HttpSession는 웹브라우저에서 세션 아이디를 제공받아야 한다.
        // 해당 객체는 getSession()을 호출할 때 생성된다.
        // getSession을 호출할 때 기존에 생성했던 세션 객체를 리턴한다.
        // 이미 클라이언트에게 받은 `세션 아이디`가 있다면 해당 객체를 리턴하며
        // 만약 응답에 `세션 아이디`가 없다면 세션 객체를 만들어 준다.
        HttpSession session = req.getSession();
        session.setAttribute("session", "세션 아이디를 가진 클라이언트 만 쓸 수 있다.");
        String sessionString = (String) session.getAttribute("session");

        // 3. ServletRequest 는 클라이언트 요청시 만들어진다.
        // 해당 Servlet에서만 사용이 가능하다.
        req.setAttribute("servlet_req", "서블릿 Request를 받은 클라이언트 만 쓸 수 있다.");
        String reqString = (String) req.getAttribute("servlet_req");

        // Servlet 인코딩 설정
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("/ex04/s1 실행 | 보관소에 값을 넣었습니다.");
        out.printf("Context = %s\n", contextString);
        out.printf("Session = %s\n", sessionString);
        out.printf("Request = %s\n", reqString);
    }
}
