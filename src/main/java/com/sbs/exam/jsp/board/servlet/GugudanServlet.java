package com.sbs.exam.jsp.board.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 들어오는 데이터를 UTF-8 로 해석 한다
        resp.setCharacterEncoding("UTF-8"); // 완성되는 HTML의 인코딩을 UTF-8 로 해석 함
        resp.setContentType("text/html; charset UTF-8"); // 브라우저에게 우리가 만든 결과물이 UTF-8 이라는걸 의미


        // int dan 이니까 정수형 타입으로 형변환 해주고 getParameter 씀
        // 주소창에 http://localhost:8081/gugudan?dan=(원하는 숫자)
        int dan = Integer.parseInt(req.getParameter("dan"));

        // limit 값 설정 가능.
//        int limit = Integer.parseInt(req.getParameter("limit"));
        resp.getWriter().append("<h1>%d단</h1>\n".formatted(dan)); // %d를 사용하여 정수값을 대체
        // for
        for(int a = 1; a < 10; a++){
            resp.getWriter().append("<div>%d * %d = %d</div>".formatted(dan,a,dan*a));
        }
    }
}
