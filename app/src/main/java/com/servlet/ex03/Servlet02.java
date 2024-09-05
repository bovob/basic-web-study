package com.servlet.ex03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet/ex06/~
 *
 * loadOnStartup = 실행순서
 *
 * 클라이언트가 실행을 요청하지 않아도 서블릿을 미리 생성하고 싶다면
 * loadOnStartup을 사용할 수 있다.
 *
 * 이를 통하여 작업시 서블릿이 자원을 준비하는데 시간을 줄일 수 있으며
 * 에러를 빠르게 처리할 수 있다.
 *
 * 사용예) DB 연결, 소켓 연결, 필요한 환경변수 로딩, 스프링 IoC 컨테이너 준비 등
 *
 * Deployment Descriptor : 배포설명자
 * web.xml 에서의 loadOnStartup 설정
 *
 * 마지막 줄에 위치한다.
 * <servlet>
 *     ...
 *     <load-on-startup>순위(번호)</load-on-startup>
 * </servlet>
 */

//@WebServlet(value="/ex03/s2", loadOnStartup=1) => DD file
@SuppressWarnings("serial")
public class Servlet02 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("/ex03/s2 => init()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/ex03/s2 => service()");
    }
}
