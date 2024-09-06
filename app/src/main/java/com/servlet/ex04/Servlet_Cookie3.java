package com.servlet.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
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

@WebServlet("/ex04/cookie3")
public class Servlet_Cookie3 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        // Cookie를 배열에 저장한다.
        // 쿠키는 getCookie 마냥 특정 쿠키값만 가져올 수 없다.
        Cookie[] cookies = req.getCookies();

        // 쿠키는 요청 헤더에 쿠키가 없으면 리턴되는 것은 빈 배열이 아니라 [ NULL ] 값이다.
        // 따라서 무한반복을 돌리면 안된다.
        if (cookies != null){
            for (Cookie c : cookies){
                // 쿠키 값이 'URL 인코딩' 한 값 이라면
                // 다시 URLDcoder.decode를 통해 디코딩 해주어야 한다.
                out.printf("%s=ISO-8859-1 : %s, UTF-8 : %s\n", c.getName(), c.getValue(), URLDecoder.decode(c.getValue()));
            }
        }
    }
}
