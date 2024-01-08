package sbs.jsp.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    final HttpServletRequest req;
    final HttpServletResponse resp;



    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;

        try {
            req.setCharacterEncoding("utf-8"); // 들어오는 데이터를 UTF-8 로 해석 한다
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("utf-8"); // 완성되는 HTML의 인코딩을 UTF-8 로 해석 함
        resp.setContentType("text/html; charset UTF-8"); // 브라우저에게 우리가 만든 결과물이 UTF-8 이라는걸 의미
    }

    public int getIntParam(String paraName, int defaultValue) {
        String value = req.getParameter(paraName);

        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NullPointerException e) {
            return defaultValue;
        }
    }

    public String getParam(String paraName, String defaultValue) {
        String value = req.getParameter(paraName);

        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    public void appendBody(String str) {
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
