package sbs.jsp.board.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sbs.jsp.board.Rq;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rq rq = new Rq(req, resp);

//        // int dan 이니까 정수형 타입으로 형변환 해주고 getParameter 씀
//        // 주소창에 http://localhost:8081/gugudan?dan=(원하는 숫자)
        int dan = rq.getIntParam("dan", 9);
        int limit = rq.getIntParam("limit", 9);

        rq.appendBody("<h1>%d단</h1>\n".formatted(dan));

//        resp.getWriter().append("<h1>%d단</h1>\n".formatted(dan)); // %d를 사용하여 정수값을 대체

        for(int a = 1; a <= limit; a++){
            rq.appendBody("<div>%d * %d = %d</div>\n".formatted(dan,a,dan*a));
        }
    }
}
