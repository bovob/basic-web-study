package com.servlet;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * java/servlet/web/ex02
 * Listener
 * 리스너는 서블릿 컨테이너 또는 서블릿, 세션 등의 객체가 변경되었을 때
 * 보고받는 옵저버 디자인 패턴이 적용 된 것이다.
 *
 * ServletContext, ServletRequest, HttpSession 등 인터페이스를 구현한다.
 *
 * 사용방법
 *=> DD 파일(web.xml)에 설정하기
 *      <listener>
 *          <listener-class>com.eomcs.web.ex02.Listener01</listener-class>
 *      </listener>
 *
 *=> 애노테이션으로 설정하기
 *      @WebListener
 *
 */

@WebListener
public class Listener01 implements ServletContextListener {

    public Listener01() {
        System.out.println("리스너1 호출");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Listener1 destroy()");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener1 init()");
    }
}
