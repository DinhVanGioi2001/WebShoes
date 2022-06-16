<%-- 
    Document   : HomePage
    Created on : Apr 30, 2022, 9:29:51 AM
    Author     : Hung Dinh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="a" class="dao.DAO" scope="request"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
            <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
            <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <!------ Include the above in your HEAD tag ---------->
            <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
            <link href="css/style.css" rel="stylesheet" type="text/css"/>
            <!--            <style>
                            #pt {
                                float: right;
                                margin-top: 15px;
                                flex-direction: row;
                                justify-content: right;
                                align-content: center;
                                font-size: 15px;
                            }
                            .pt2{
                                border: 1px solid black;
                                background-color: yellowgreen;
                                color: black;
                                padding: 5px;
                                margin: 3px auto;
                            }
                        </style>-->

        </head>
        <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Category</a></li>
                                <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>
                    <div class="col-sm-9">
                        <div id="content" class="row">
                        <%--<c:forEach begin="1" end="6" var="o">--%>
                        <c:forEach items="${listP}" var="o">
                            <div class="product col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${o.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.price} $</p>
                                            </div>
                                            <div class="col">
                                                <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach> 
                    </div>
                    <!--sử dụng boottrap-->
                    <br>
                    <!--buttol load more để load dữ liệu với ajax-->
                    <button onclick="loadMore()" class="btn btn-primary">Load more</button>
                    <nav aria-label="...">
                        <ul class="pagination pagination-sm justify-content-end">
                            <c:forEach begin="1" end="${a.getTotalPage()}" var="i">
                                <li class="page-item ${indexPage == i ? "active":""}"><a class="page-link" href="home?index=${i}">${i}</a></li>
                                </c:forEach>
                        </ul>
                    </nav>

                    <!--code tự viết-->

                    <!--<div id="pt">-->
                    <%--<c:forEach begin="1" end="${a.getTotalPage()}" var="i">--%>
                        <!--<a class="pt2" href="#">${i}</a>-->
                    <%--</c:forEach>--%>
                    <!--<a class="pt2" href="#">...</a>-->
                    <!--</div>-->
                </div>
            </div>
        </div>

        <jsp:include page="Footer.jsp"></jsp:include>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
        //    function searchByName(parameter) {
        //        var txtSearch = parameter.value;
        //        $.ajax({
        //            url: "/ProjectShoes/searchajax",
        //            type: "get",
        //            data: {
        //                txt: txtSearch
        //            },
        //            success: function (data) {
        //                var row = document.getElementById("content");
        //                row.innerHTML = data;
        //            }
        //        })
        //    }

//             hàm loadmore sử dụng ajax để tải lần lượt sản phẩm lên
            function loadMore() {
                var amount = document.getElementsByClassName("product").length; // lấy số lượng
//                            console.log(amount);
                $.ajax({
                    url: "/ProjectShoes/loadMore",
                    type: "GET",
                    data: {
                        exits: amount
                    },
                    success: function (mount) {
                        var row = document.getElementById("content");
                        row.innerHTML += mount;
                    }
                })
            }

            // sử dụng fetch

            function searchByName(parameter) {
                var txtSearch = parameter.value;
                fetch('searchajax?txt=' + txtSearch)
                .then(res => {
                    return res.text();
                })
                .then(data => {
                    var row = document.getElementById("content");
                    row.innerHTML = data;
                })
            }
        </script>
    </body>
</html>


