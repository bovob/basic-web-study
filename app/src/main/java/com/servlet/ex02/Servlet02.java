package com.servlet.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * servlet/ex04/~
 *
 * 웹 브라우저가 데이터를 읽을 땐
 * ServletRequest.getParameter("파라미터이름") 을 통해 읽기때문에
 * GET과 POST요청으로 읽어들이는 값이 같다.
 *
 * 하지만 문제는 POST의 경우 값이 깨질 수 있다.
 *
 * GET은 UTF-8 로 보내지만
 * POST는 ISO-8859-1 를 따르기 때문이다.
 *
 * 하지만 서블릿 컨테이너는 UCS2(UTF-16) 문자 코드로 변환되기 때문에
 * getParameter() 가 리턴한 영어는 정상적으로 출력되지만
 * 한글은 깨진다.
 *
 * 따라서 POST 전송 시
 * req.setCharacterEncoding("UTF-8");
 * 요청에 글자 인코딩을 명시해서 넘겨주어야 한다.
 *
 * !! 이는 getParameter()를 최초로 호출하기 전에 먼저 선언해주어야 한다.
 *    이미 getParameter()를 호출 했다면 소용없다.
 *
 * URL 인코딩 예시
 *
 * 문자
 * => A 가
 *
 * Windows (MS949)
 * => 41 B0 A1
 *
 * UTF-8
 * => 41 EA B0 80
 *
 * 변환
 * UTF-16
 * => 00 41 00 EA 00 B0 00 80
 *
 * 따라서 실질적으로
 * A . . . 으로 보인다.
 */

@WebServlet("/ex02/s2")
public class Servlet02 extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 파라미터 Request값을 받기 위한 변수선언
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        // 응답 및 인코딩 UTF-8
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.printf("이름=%s\n", name);
        out.printf("나이=%s\n", age);

        // 입력글자 확인
        char[] chars = name.toCharArray();
        for(char c : chars){
            out.printf("04x\n", (int) c);
        }
    }
}
