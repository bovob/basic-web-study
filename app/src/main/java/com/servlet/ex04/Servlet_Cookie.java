package com.servlet.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet/ex10/~
 *
 * Cookie 란
 * 웹서버가 웹브라우저에게 맡기는 데이터이다.
 * 웹브라우저는 응답헤더로 받은 쿠키 데이터를 보관하기 있다가
 * 지정된 URL을 요청할 때 요청 헤더에 포함시켜 웹 서버에서 쿠키를 다시 보낸다.
 *
 * Set-Cookie는 `이름=값` 형태로 되어있다.
 *
 * !! 여기서 주의 할 점은 Cookie는 저장시
 * ISO-8859-1 로 저장되기 때문에 UTF-8로 보내고 싶다면
 * URLEncoder.encode("값", "UTF-8")로 ASCII 코드화 시켜 보내야 한다.
 *
 *
 */

@WebServlet("/ex04/cookie")
public class Servlet_Cookie extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Cookie를 생성한다.
        // ISO-8859-1 & UTF-8 encoding
        Cookie c1 = new Cookie("name_orgin", "홍길동");
        Cookie c2 = new Cookie("name_UTF8", URLEncoder.encode("홍길동", "UTF-8"));

        // MaxAge(초) Cookie의 유통기한을 정할 수 있다.
        Cookie c3 = new Cookie("cookies1", URLEncoder.encode("사라지지 않는 무기한 쿠키 값"));
        Cookie c4 = new Cookie("cookies2", URLEncoder.encode("10초 뒤 사라지는 쿠키 값"));
        c4.setMaxAge(10);

        // setPath(경로) Cookie의 사용범위를 지정할 수 있다.
        Cookie c5 = new Cookie("cookie_every", URLEncoder.encode("어디든 사용할 수 있는 쿠키 값"));
        c5.setPath("/");
        Cookie c6 = new Cookie("cookie3", URLEncoder.encode("Cookie3 [/ex04/cookie3] 만 사용할 수 있는 쿠키 값"));
        c6.setPath("/ex04/cookie3");

        resp.addCookie(c1);
        resp.addCookie(c2);
        resp.addCookie(c3);
        resp.addCookie(c4);
        resp.addCookie(c5);
        resp.addCookie(c6);

        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("/ex04/cookie 쿠키를 보냈습니다.");

    }
}
