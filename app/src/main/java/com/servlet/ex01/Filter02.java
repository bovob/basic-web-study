package com.servlet.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * java/servlet/web/ex02
 * Filter
 * => 필터는 서블릿 사용하기 전/후에 필요한 작업을 수행한다.
 *
 * 예시
 * 처리 전 필터
 * => 웹브라우저가 보낸 암호화 파라미터값 암호 해제
 * => 웹브라우저가 보낸 압축된 데이터를 전달하기 전 압축
 * => 사용자 검사 및 로깅
 *
 * 처리 후 필터
 * => 클라이언트로 보낼 데이터 압축
 * => 클라이언트로 보낼 데이터 암호화
 *
 * 사용방법
 * => DD 파일(web.xml)에 설정하기
 *      <!-- 필터 등록 -->
 *      <filter>
 *          <filter-name>필터별칭</filter-name>
 *          <filter-class>패키지경로</filter-class>
 *      </filter>
 *
 *      <!-- 필터를 적용할 URL 설정 -->
 *      <filter-mapping>
 *          <filter-name>필터별칭</filter-name>
 *          <url-pattern>url경로(/포함, * 와일드카드 사용가능)</url-pattern>
 *      </filter-mapping>
 * => 애노테이션으로 설정하기
 *      @WebFilter(URL)
 *
 */

public class Filter02 implements Filter {

    // 요청이 들어올 때 마다 호출된다.
    // 단 필터를 설정할 때 지정된 URL의 요청에 의해서만 호출된다.
    // 서블릿 실행 전 실행되며 서블릿 실행 후 다시 필터로 리턴한다.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        System.out.println("필터2 doFilter() 시작");

        // 다음 필터를 실행한다.
        // 만약 다음 필터가 없으면 서블릿의 service() 를 호출한다.
        // service() 메서드 호출이 끝나면 리턴된다.
        chain.doFilter(request, response);
        
        // 체인이 연결된 필터나 서블릿이 모두 종료 된 다음 
        // 다시 해당 필터로 리턴된다.
        System.out.println("필터2 doFilter() 종료");
    }

    // 웹 애플리케이션을 실행할 때 필터는 객체가 자동으로 생성된다.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("필터2 init()");
    }

    // 웹 애플리케이션을 종료할 떄 호출된다.
    // init()에서 준비한 자원을 해제한다.
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
