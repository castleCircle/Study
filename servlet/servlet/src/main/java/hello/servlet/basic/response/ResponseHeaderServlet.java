package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setStatus(HttpServletResponse.SC_OK);

        resp.setStatus(HttpServletResponse.SC_OK);

//        resp.setHeader("myHeader","test");
//        resp.setHeader("Content-Type","text/plain;charset=UTF-8");
//        resp.setHeader("Cache-Control","no-cache,no-store");
//        resp.setHeader("Content-Type","text/plain;charset=UTF-8");
//        resp.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
//        resp.setHeader("Pragma","no-cache");
//        resp.setHeader("my-header","hello");
//
//        content(resp);
//        cookie(resp);
//
        redirect(resp);

        PrintWriter writer = resp.getWriter();
        writer.println("안녕");
    }

    private void redirect(HttpServletResponse resp) throws IOException{
//        resp.setStatus(HttpServletResponse.SC_FOUND);
//        resp.setHeader("Location","/basic/hello-form.html");
//        resp.sendRedirect("/basic/hello-form.html");

        resp.setStatus(HttpServletResponse.SC_FOUND);
        resp.setHeader("Location","/basic/hello-form.html");
    }

    private void content(HttpServletResponse response){
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/plain");
//        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response){
        Cookie cookie = new Cookie("myCookie", "good1");
        cookie.setMaxAge(6000);
        response.addCookie(cookie);
    }
}
