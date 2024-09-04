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
 * GET과 POST의 차이
 *
 * **GET
 * GET은 URL에 경로 뒤 ? (Query String)을 통하여 파라미터 값을 전송한다.
 * 이는 멱등성에 의하여 항상 같은 값을 return 하며 간단하게 데이터 값을 보낼 수 있다.
 *
 * 주로 글 조회, 검색 등에 쓰이며 URL에 데이터 쿼리스트링값 (QS)를 포함하기 때문에
 * 웹 브라우저가 cache에 저장하여(쿠키) 다른 사용자에게 노출 될 수 있다.
 * 따라서 보안이 요구되는 경우 적합하지 않다.
 *
 * 또한 단순 값만 전송이 가능하기 때문에 URL의 크기가 제한되어 있다.
 *
 * **POST
 * POST는 URL자체에 데이터를 담지 않아 QS가 없다.
 * Request Body에 값을 가지고 있으며 데이터를 생성/수정/삭제 할 때 주로 사용된다.
 * 크기에 제한이 없으며 대량의 데이터를 보낼 때 적합하며
 * GET처럼 값을 캐싱하지 않으며 파라미터가 노출되지 않기 때문에 보안이 더 높다.
 *
 * multipart/form-data를 이용하여 파일을 전송할 수 있다.
 * 대량의 데이터나 바이너리 데이터, 로그인처럼 노출되어서는 안돼는 데이터를 전송할 때 사용한다.
 */

@WebServlet("/ex02/s1")
public class Servlet01 extends GenericServlet {

    // /webapp/html/test01.html 을 통한 GET 테스트
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        // 파라미터 Request값을 받기 위한 변수선언
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        // 응답 및 인코딩 UTF-8
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.printf("이름=%s\n", name);
        out.printf("나이=%s\n", age);
    }
}
