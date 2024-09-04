package com.servlet.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * servlet/ex04/3~6
 *
 * 파일전송
 * GET으로는 SUBMIT을 통하여 파일을 전달해도 파일명만 전달된다.
 *
 * POST도 기존 form -> application/x-www-form-urlencoded 는 보낼 수 없다.
 * 따라서 form의 인코딩 형식을 multipart/form-data 로 바꾸어야 한다.
 *
 * @애노테이션을 사용하지 않을 시
 * DD파일 설정값
 *
 * <servlet>
 *     <servlet-name>서블릿별칭</servlet-name>
 *     <servlet-class>서블릿클래스 위치</servlet-class>
 *     <multipart-config>
 *         <max-file-size>10000000</max-file-size>
 *     </multipart-config>
 * </servlet>
 *
 */

// 멀티파트 형식의 데이터를 처리할 @애노테이션을 설정한다.
@WebServlet("/ex02/s3")
public class Servlet03 extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();

        // 기존 TEXT 입력 값은 그대로 받는다.
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String photo = req.getParameter("photo");

        res.setContentType("text/plain;charset=UTF-8");

        out.printf("이름=%s\n", name);
        out.printf("나이=%s\n", age);
        out.printf("사진=%s\n", photo);

    }
}
