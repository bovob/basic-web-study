package com.servlet.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * servlet/ex11/~
 *
 * Session
 * 세션은 클라이언트를 식별하는 기술이다.
 * HTTP 프로토콜은 Stateless 방식으로 통신한다.
 * 즉 연결 후 응답을 받으면 연결을 끊는다.
 *
 * 따라서 서버에선 클라이언트가 요청할 때 누구인지 알 수 없다.
 * 이를 해결하기 위하여 클라이언트에게 서버에서 고유번호를 발급해준다.(쿠키이용)
 * => 이를 `세션아이디` 라 부른다.
 *
 * 서버에서 클라이언트로 세션 아이디를 보낼 때 유효기간을 설정하지 않기 때문에
 * 웹 브라우저를 종료하면 세션 아이디 쿠키는 자동적으로 `삭제`된다.
 * => /컨텍스트루트로 사용 범위(웹 애플리케이션 경로)에 한정된다.
 * => req.getSession()을 호출하면 발급한다.
 * 
 * 클라이언트
 * 1) 세션아이디가 없을경우 (서버에 리턴값x)
 * => 서버는 새로운 세션아이디를 발급해서 보내준다.
 * 2) 세션아이디가 있는경우
 * => 서버는 해당 세션을 리턴한다.
 * 3) 세션아이디가 만료된 경우
 * => 서버는 새로운 세션 아이디를 발급하여 리턴한다.
 *
 */

@WebServlet("/ex04/session2")
public class Servlet_Session2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션요청
        HttpSession session = req.getSession();
        
        // 세션설정 (데이터 보관)
        session.setAttribute("s1", "세션1");

        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        out.println("/ex04/session2 - 세션확인");
        out.printf("s1=%s\n", session.getAttribute("s1"));
    }
}
