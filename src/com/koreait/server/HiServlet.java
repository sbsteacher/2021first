package com.koreait.server;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/hi")
public class HiServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println("name : " + name);
        System.out.println("age : " + age);

        PrintWriter out = res.getWriter();

        TestVO vo = new TestVO();
        vo.setName("haha");
        vo.setAge(20);

        String result = String.format("{ \"name\": \"%s\", \"age\": %s }", vo.getName(), vo.getAge());
        System.out.println("result: " + result);

        Gson gson = new Gson();
        String result2 = gson.toJson(vo);

        TestVO vo2 = gson.fromJson(result2, TestVO.class);

        System.out.println("result2: " + result2);
        out.print(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String data = Utils.getJson(req);

        Gson gson = new Gson();
        TestVO vo = gson.fromJson(data, TestVO.class);

        System.out.println("name : " + vo.getName());
        System.out.println("age : " + vo.getAge());
        System.out.println(data);
    }


}
