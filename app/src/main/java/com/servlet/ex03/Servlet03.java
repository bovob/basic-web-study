package com.servlet.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet/ex06/~
 *
 * Servlet에서 사용할 값(환경변수 등)을 미리
 * DD 설정할 수 있다.
 *
 * 애너테이션 사용
 * WebServlet (
 *              value="/ex03/s3",
 *              loadOnStartup=3,
 *              initParams={
 *                          WebInitParam(name="jdbc.driver", value="org.mariadb.jdbc.Driver"),
 *                          WebInitParam(name="jdbc.url", value="jdbc:mariadb://localhost/study"),
 *                          WebInitParam(name="jdbc.username", value="org.mariadb.jdbc.Driver"),
 *                          WebInitParam(name="jdbc.password", value="org.mariadb.jdbc.Driver")})
 *
 *
 * web.xml 에 설정
 * [전역설정]
 * <context-param>
 *     <param-name>jdbc2.driver</param-name>
 *     <param-value>org.mariadb.jdbc.Driver</param-value>
 * </context-param>
 *                     ...
 *
 * ServletContext 값을 가져와서 초기화
 *
 * [특정서블릿]
 * <servlet>
 *     ...
 *     <init-param>
 *          <param-name>jdbc2.driver</param-name>
 *          <param-value>org.mariadb.jdbc.Driver</param-value>
 *     </init-param>
 *    ...
 * </servlet>
 *
 * ServletConfig 값을 가져와서 초기화
 */

@WebServlet(value="/ex03/s3", loadOnStartup = 1)
public class Servlet03 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ServletContext sc = this.getServletContext();
        ServletContext sc2 = this.getServletConfig().getServletContext();

        System.out.println(sc == sc2);
        System.out.printf("driver=%s\n", sc.getInitParameter("jdbc.driver"));
        System.out.printf("url=%s\n", sc.getInitParameter("jdbc.url"));
        System.out.printf("username=%s\n", sc.getInitParameter("jdbc.username"));
        System.out.printf("password=%s\n", sc.getInitParameter("jdbc.password"));
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.printf("/ex03/s3 => service()");
    }
}
