package com.sbs.exam.jsp.board.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet { // HttpServelt 을 상속받음

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); // 들어오는 데이터를 UTF-8 로 해석 한다
        resp.setCharacterEncoding("utf-8"); // 완성되는 HTML의 인코딩을 UTF-8 로 해석 함
        resp.setContentType("text/html; charset UTF-8"); // 브라우저에게 우리가 만든 결과물이 UTF-8 이라는걸 의미

        resp.getWriter().append("김민재");

    }
}

