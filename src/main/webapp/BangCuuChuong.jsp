<%-- 
    Document   : BangCuuChuong
    Created on : May 9, 2022, 2:57:12 PM
    Author     : Hung Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
                border: 1px solid black;
                /*text-align: center;*/ 
            }
        </style>
    </head>
    <body>
        <h1>Bảng cửu chương</h1>
        <table>
            <%
                for (int i = 1; i <= 9; i++) {
                    out.print("<tr>");
                    for (int j = 1; j <= 9; j++) {
                        out.print("<td>");
                        out.println(i + " * " + j + " = " + (i * j));
                        out.print("</td>");
                    }
                    out.print("</tr>");
                }
            %>
        </table>
    </body>
</html>
