package com.servlet.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

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
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/ex02/s4")
public class Servlet04 extends GenericServlet {
    
    // 파일 저장 위치
    private String uploadDir;

    // 생성자를 통한 upload 위치 설정
    @Override
    public void init() throws ServletException {
        this.uploadDir = this.getServletContext().getRealPath("/upload");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpServletRequest httpReq = (HttpServletRequest) req;

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("<html>");
        out.printf("<head><title>Servlet04</title></head>");
        out.printf("<body><h1>파일 업로드 결과</h1>");

        // 기존 TEXT 입력 값은 그대로 받는다.
        out.printf("이름=%s<br>\n", httpReq.getParameter("name"));
        out.printf("나이=%s<br>\n", httpReq.getParameter("age"));

        // 파일 데이터는 getPart를 사용한다.
        Part photoPart = httpReq.getPart("photo");
        if(photoPart.getSize() > 0){
            // UUID 를 사용하여 이름이 중복 되더라도 덮어쓰지 않도록 한다. (1조개 중 1/10억 확률로 중복)
            // 따라서 salt 값을 추가하여 저장한다면 (저장시간 등) 절대 같은 값이 나올 수 없다.
            String filename = UUID.randomUUID().toString();
            photoPart.write(this.uploadDir + "/" + filename);
            // 파일명, 사진 크기변경, 사진 출력
            out.printf("사진=%s<br>\n", filename);
            out.printf("<img src='../upload/%s' height='50'><br>\n", filename);
            out.printf("<img src='../upload/%s'><br>\n", filename);
        }
        out.printf("</body></html>");
    }
}


