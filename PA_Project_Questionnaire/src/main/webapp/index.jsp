<%@ page import="java.util.concurrent.atomic.AtomicInteger" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.01.2021
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    AtomicInteger count = new AtomicInteger(0);
    AtomicInteger mood1 = new AtomicInteger(0);
    AtomicInteger mood2 = new AtomicInteger(0);
    AtomicInteger mood3 = new AtomicInteger(0);
    AtomicInteger mood4 = new AtomicInteger(0);
    AtomicInteger field1 = new AtomicInteger(0);
    AtomicInteger field2 = new AtomicInteger(0);
    AtomicInteger field3 = new AtomicInteger(0);
    AtomicInteger field4 = new AtomicInteger(0);
%>
<%
    request.setCharacterEncoding("UTF-8");
    String userName = request.getParameter("name")+" "
            +request.getParameter("surname")+" Возраст "
            +request.getParameter("age");
    String AnswToQuest1 = request.getParameter("quest1");
    String AnswToQuest2 = request.getParameter("quest2");
    count.getAndIncrement();
    if (AnswToQuest1 != null && AnswToQuest1.equals("nice")) {
        mood1.getAndIncrement();
    }
    if (AnswToQuest1 != null && AnswToQuest1.equals("ok")) {
        mood2.getAndIncrement();
    }
    if (AnswToQuest1 != null && AnswToQuest1.equals("bad")) {
        mood3.getAndIncrement();
    }
    if (AnswToQuest1 != null && AnswToQuest1.equals("verybad")) {
        mood4.getAndIncrement();
    }
    if (AnswToQuest2 != null && AnswToQuest2.equals("it")) {
        field1.getAndIncrement();
    }
    if (AnswToQuest2 != null && AnswToQuest2.equals("jur")) {
        field2.getAndIncrement();
    }
    if (AnswToQuest2 != null && AnswToQuest2.equals("kult")) {
        field3.getAndIncrement();
    }
    if (AnswToQuest2 != null && AnswToQuest2.equals("medic")) {
        field4.getAndIncrement();
    }
%>
<html>
<head>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8">
    <title>Статистика</title> <link rel="stylesheet" href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" integrity="2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj" crossorigin="anonymous">

</head>
<body>
<div class="container text-center">
    Пользователь: <%=userName%>
    <div>
        <h1>Статистика по настроению</h1>
    </div>

    <div>

        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Всего опрошено</th>
                <th>С отличным настроением:</th>
                <th>С хорошим настроением:</th>
                <th>С плохим настроением:</th>
                <th>С ужасным настроением:</th>
            </tr>
            </thead>
            <tbody>
            <tr >
                <td ><%= count  %></td>
                <td ><%= mood1  %></td>
                <td ><%= mood2  %></td>
                <td><%= mood3  %></td>
                <td><%= mood4  %></td>
            </tr>
            </tbody>
        </table>

        <div>
            <h1>Статистика по специальности</h1>
        </div>

        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>IT:</th>
                <th>Юрист:</th>
                <th>Культура:</th>
                <th>Медик: </th>

            </tr>
            </thead>
            <tbody>
            <tr>

                <td><%= field1  %></td>
                <td ><%= field2  %></td>
                <td ><%= field3  %></td>
                <td ><%= field4  %></td>

            </tr>
            </tbody>
        </table>
    </div>

</body>
</html>