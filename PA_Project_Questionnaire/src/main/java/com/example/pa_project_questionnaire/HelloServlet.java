package com.example.pa_project_questionnaire;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private AtomicInteger count = new AtomicInteger(0);
    private AtomicInteger mood1 = new AtomicInteger(0);
    private AtomicInteger mood2 = new AtomicInteger(0);
    private AtomicInteger mood3 = new AtomicInteger(0);
    private AtomicInteger mood4 = new AtomicInteger(0);
    private AtomicInteger field1 = new AtomicInteger(0);
    private AtomicInteger field2 = new AtomicInteger(0);
    private AtomicInteger field3 = new AtomicInteger(0);
    private AtomicInteger field4 = new AtomicInteger(0);



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        StringBuilder sb = new StringBuilder();
        sb.append(req.getParameter("name")).append(req.getParameter("age")).append(req.getParameter("surname"));
        String str;
        str = "<body>" + sb.toString() + "</body></html>";
        String AnswToQuest1 = req.getParameter("quest1");
        String AnswToQuest2 = req.getParameter("quest2");
        count.getAndIncrement();

        if (AnswToQuest1.equals("nice")) {
            mood1.getAndIncrement();
        }
        if (AnswToQuest1.equals("ok")) {
            mood2.getAndIncrement();
        }
        if (AnswToQuest1.equals("bad")) {
            mood3.getAndIncrement();
        }
        if (AnswToQuest1.equals("verybad")) {
            mood4.getAndIncrement();
        }
        if (AnswToQuest2.equals("it")) {

            field1.getAndIncrement();
        }
        if (AnswToQuest2.equals("jur")) {

            field2.getAndIncrement();
        }
        if (AnswToQuest2.equals("kult")) {

            field3.getAndIncrement();
        }
        if (AnswToQuest2.equals("medic")) {

            field4.getAndIncrement();
        }

        PrintWriter pw = resp.getWriter();
        pw.println("<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=utf-8\">");
        pw.println("<title>Статистика</title> <link rel=\"stylesheet\" href=\"https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css\" integrity=\"2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj\" crossorigin=\"anonymous\">");
        pw.println("<div class=\"container text-center\">");
        pw.println("<h1>Статистика по настроению</h1>    <table class=\"table table-striped table-bordered\">" +
                "            <thead class=\"thead-dark\">" +
                "                <tr>" +
                "                    <th>Всего опрошено</th>" +
                "                    <th>С отличным настроением:</th>" +
                "                    <th>С хорошим настроением:</th>" +
                "                    <th>С плохим настроением: </th>" +
                "                    <th>С ужасным настроением:</th>" +
                "                </tr>" +
                "            </thead>" +
                "            <tbody>" +
                "                <tr >" +
                "                    <td >" + count + "</td>" +
                "                    <td >" + mood1 + "</td>" +
                "                    <td >" + mood2 + "</td>" +
                "                   " +
                "                     <td >" + mood3 + "</td>" +
                "                     <td>" + mood1 + "</td>" +
                "             " +
                "                </tr>" +
                "            </tbody>" +
                "        </table>");

        pw.println("<h1>Статистика по специальности</h1> <table class=\"table table-striped table-bordered\">" +
                "            <thead class=\"thead-dark\">" +
                "                <tr>" +
                "                    <th>IT:</th>" +
                "                    <th>Юрист:</th>" +
                "                    <th>Культура:</th>" +
                "                    <th>Медик: </th>" +
                "                </tr>" +
                "            </thead>" +
                "            <tbody>" +
                "                <tr >" +
                "                    <td >" + field1 + "</td>" +
                "                    <td >" + field2 + "</td>" +
                "                    <td >" + field3 + "</td>" +
                "                   " +
                "                     <td >" + field4 + "</td>" +

                "             " +
                "                </tr>" +
                "            </tbody>" +
                "        </table>");
        pw.println("<form action=\"index.html\" >" +
                "   <button>Повторить </button>" +
                "  </form>");
    }
}