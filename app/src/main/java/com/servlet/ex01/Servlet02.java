package com.servlet.ex01;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
 *
 * 서블릿 컨테이너 등록방법
 * 1) WEB-INF/web.xml (DD File - Deployment Descriptor File)에 등록
 *
 * <servlet>
 *     <servlet-name>서블릿별칭</servlet-name>
 *     <servlet-class>서블릿 클래스의 전체이름[패키지포함]</servlet-class>
 * </servlet>
 *
 * <servlet-mapping>
 *     <servlet-name>서블릿별칭</servlet-name>
 *     <url-pattern>클라이언트에서 요청할 떄 사용할 URL[/로 시작]</url-pattern>
 * </servlet-mapping>
 *
 * 2) @WebServlet 애노테이션 사용하여 등록
 *
 * @WebServlet
 * @WebServlet(URL)
 * @WebServlet(value=URL)
 * @WebServlet(urlPatterns={"URL1","URL2", ...})
 *
 * value는 String[]로 URL을 1개만 입력할땐 {} 를 생략할 수 있다.
 */

//@WebServlet("/ex01/second")
public class Servlet02 implements Servlet {

    ServletConfig config;

    public Servlet02(){
        System.out.println("2번 Servlet()");
    }

    // 서블릿 객체 생성 후 해당 메서드가 호출된다.
    // ServerConfig를 객체로 받아 인스턴스 변수에 보관해 둔다.
    // 서블릿 클래스마다 객체는 한 개만 생성된다.
    // 따라서 init()은 처음 한번만 호출 된다.
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("2번 init()");
    }

    // 클라이언트가 이 서블릿에 실행 요청을 보낼 때 마다 호출되는 메서드
    // 클라이언트의 요청을 수행한다.
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 웹에서 사용하기 위해 HTTP 프로토콜 Request와 Response로 형변환을 한다.
        HttpServletRequest req2 = (HttpServletRequest) req;
        HttpServletResponse res2 = (HttpServletResponse) res;

        System.out.println("2번 service()");
    }

    // 웹 애플리케이션을 종료할 때(서버 종료 포함) 호출된다.
    // => 이 서블릿이 만든 자원을 해제하는 코드를 해당 메서드에 넣는다.
    @Override
    public void destroy() {
        System.out.println("2번 destroy()");
    }

    // 서블릿에서 작업을 수행하는 중 서블릿 관련 설정 정보를 꺼낼 때 호출된다.
    // 해당 메서드가 리턴하는 값은 ServerConfig 이며
    // 보통 init()의 파라미터 값을 리턴한다.
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    // 서블릿 컨테이너가 관리자 화면에 출력할 때 호출된다.
    // 보통 서블릿을 소개하는 간단한 문자열을 리턴한다.
    @Override
    public String getServletInfo() {
        return "2번 Servlet";
    }
}
