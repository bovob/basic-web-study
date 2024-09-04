package com.servlet.ex01;


import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

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

public class Listener02 implements ServletRequestListener {
    
    public Listener02() {
        System.out.println("리스너2 호출");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // 요청이 들어왔을 때 호출된다.
        System.out.println("Listener2 init()");
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        System.out.println("클라이언트 IP : "+request.getRemoteAddr());
        System.out.println("요청 URL : "+request.getServletPath());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 요청 처리가 완료 되었을 때 호출된다.
        System.out.println("Listener2 destroy()");
    }
}
